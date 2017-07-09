package com.example;

import com.example.handler.HelloHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class JavaHttpServer {
    private static final String SERVER_NAME = "localhost";
    private static final String SERVER_PORT = "8001";

    public static void main(String[] args) throws IOException {
        JavaHttpServer javaHttpServer = new JavaHttpServer();
        javaHttpServer.start(SERVER_NAME);
    }

    private void start(String serverName) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(serverName, Integer.parseInt(SERVER_PORT)), 0);

        server.createContext("/hello", new HelloHandler());
        server.setExecutor(Executors.newFixedThreadPool(15));
        server.start();
    }
}