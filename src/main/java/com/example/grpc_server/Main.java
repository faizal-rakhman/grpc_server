package com.example.grpc_server;

import com.example.grpc_server.Controller.GuestBookImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new GuestBookImpl())
                .build();

        server.start();

        System.out.println("Server started");
        server.awaitTermination();
    }
}
