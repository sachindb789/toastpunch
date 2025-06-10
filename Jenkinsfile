pipeline {
    agent any

    tools {
        jdk 'JDK17'       // Configure this in Jenkins (Manage Jenkins > Global Tool Configuration)
        maven 'Maven3'    // Configure Maven name similarly
    }

    environment {
        JAVA_HOME = "${tool 'JDK17'}"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

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
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Run App') {
            steps {
                sh 'nohup java -jar target/toastpunch-0.0.1-SNAPSHOT.jar &'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
