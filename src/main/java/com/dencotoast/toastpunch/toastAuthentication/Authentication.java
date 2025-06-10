package com.dencotoast.toastpunch.toastAuthentication;

import java.net.*;
import java.net.http.*;
import java.util.*;

public class Authentication {
    public static void main(String[] args) throws Exception {
        var httpClient = HttpClient.newBuilder().build();

        var payload = String.join("\n"
                , "{"
                , " \"clientId\": \"VKuhk4NaLedOcjZpJM8grvdrsFi3MlcM\","
                , " \"clientSecret\": \"eS960aiKdvgbSDcLUCk68HR2CJKwwHNO2HKfgxjCWxoj27KIp6jFAi2XOOc_oCuv\","
                , " \"userAccessType\": \"TOAST_MACHINE_CLIENT\""
                , "}"
        );

        var host = "https://toast-api-server";
        var pathname = "/authentication/v1/authentication/login";
        var request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .uri(URI.create(host + pathname ))
                .header("Content-Type", "application/json")
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}