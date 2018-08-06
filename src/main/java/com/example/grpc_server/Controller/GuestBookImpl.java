package com.example.grpc_server.Controller;

import com.example.grpc_server.models.GuestBook;
import com.example.grpc_server.repositories.GuestBookRepository;
import com.example.grpcserver.CommentRequest;
import com.example.grpcserver.CommentResponse;
import com.example.grpcserver.GuestbookGrpc;
import io.grpc.stub.StreamObserver;

public class GuestBookImpl extends GuestbookGrpc.GuestbookImplBase {

    @Override
    public void comment(CommentRequest commentRequest,
                         StreamObserver<CommentResponse> responseObserver) {
        System.out.println(commentRequest);

        String name = commentRequest.getName();
        String comment = commentRequest.getComment();

        GuestBookRepository repository = new GuestBookRepository();
        Integer commentId = repository.save(name, comment);

        CommentResponse commentResponse = CommentResponse.newBuilder()
                .setMessage("Comment submitted using id " + commentId)
                .build();

        responseObserver.onNext(commentResponse);
        responseObserver.onCompleted();
    }
}
