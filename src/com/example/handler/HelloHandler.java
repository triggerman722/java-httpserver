package com.example.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Created by greg on 09/07/17.
 */
public class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "";
        int responseCode = HttpURLConnection.HTTP_OK;


        switch (httpExchange.getRequestMethod().toLowerCase()) {
            case "get": {
                String[] parts = httpExchange.getRequestURI().getPath().split("/");
                if (parts.length > 2) {
                    response = "Hello, " + parts[2] + "!!!";
                } else {
                    response = "Hello!!";
                }
                responseCode = HttpURLConnection.HTTP_OK;
                break;
            }
            case "post": {
                responseCode = HttpURLConnection.HTTP_BAD_REQUEST;
                break;
            }
            case "put": {
                responseCode = HttpURLConnection.HTTP_BAD_REQUEST;
                break;
            }
            case "delete": {
                responseCode = HttpURLConnection.HTTP_BAD_REQUEST;
                break;
            }
        }
        httpExchange.sendResponseHeaders(responseCode, response.length());
        final OutputStream os = httpExchange.getResponseBody();
        os.write( response.getBytes() );
        os.close();
    }
}
