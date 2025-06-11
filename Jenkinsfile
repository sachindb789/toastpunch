pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/sachindb789/toastpunch.git',
                    branch: 'main',
                    credentialsId: 'github'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
//         stage('Run App') {
//             steps {
//                 sh 'nohup java -jar target/toastpunch-0.0.1-SNAPSHOT.jar &'
//             }
//         }

        stage('Deploy') {
            steps {
                sh '''
                    DEPLOY_DIR=/opt/toastpunch
                    SERVICE_NAME=toastpunch.service

                    echo "Removing old app.jar if it exists"
                    sudo /bin/rm -f $DEPLOY_DIR/app.jar

                    echo "Copying new JAR to $DEPLOY_DIR"
                    sudo /bin/cp "$WORKSPACE/target/"*.jar $DEPLOY_DIR/app.jar

                    echo "Restarting $SERVICE_NAME service..."
                    sudo /bin/systemctl restart $SERVICE_NAME

                    echo "$SERVICE_NAME restarted successfully."
                '''
            }
        }

    }

    post {
        success {
            echo ' Build and deployment successful!'
        }
        failure {
            echo ' Build failed.'
        }
    }
}
