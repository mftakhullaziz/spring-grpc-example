package com.example.springGrpcExample.grpc;

import com.example.springGrpcExample.UsersProtocolBufferGrpc;
import com.example.springGrpcExample.UsersProtocolBufferOuterClass;
import com.example.springGrpcExample.core.UsersService;
import com.example.springGrpcExample.domain.Users;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class UsersGrpc extends UsersProtocolBufferGrpc.UsersProtocolBufferImplBase {

    private final UsersService usersService;

    @Override
    public void findById(UsersProtocolBufferOuterClass.UserByIdRequest request, StreamObserver<UsersProtocolBufferOuterClass.UserResponse> responseObserver) {
        UsersProtocolBufferOuterClass.UserDto userDto = Optional.ofNullable(request)
            .map(UsersProtocolBufferOuterClass.UserByIdRequest::getId)
            .map(usersService::findById)
            .flatMap(res ->
                res.map(userData-> UsersProtocolBufferOuterClass.UserDto.newBuilder().
                    setId(userData.getId()).
                    setEmail(userData.getEmail()).
                    setFullName(userData.getFullName()).build())).orElse(null);
        responseObserver.onNext(UsersProtocolBufferOuterClass.UserResponse.newBuilder().setUser(userDto).build());
        responseObserver.onCompleted();
    }

    @Override
    public void findByEmail(UsersProtocolBufferOuterClass.UserByEmailRequest request, StreamObserver<UsersProtocolBufferOuterClass.UserResponse> responseObserver) {
        super.findByEmail(request, responseObserver);
    }

    @Override
    public void save(UsersProtocolBufferOuterClass.CreateUserRequest request, StreamObserver<Empty> responseObserver) {
        Optional.ofNullable(request).ifPresent(req ->
            usersService.save(Users.builder().
                email(req.getEmail()).
                fullName(req.getFullName()).build()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void update(UsersProtocolBufferOuterClass.UpdateUserRequest request, StreamObserver<Empty> responseObserver) {
        super.update(request, responseObserver);
    }

    @Override
    public void deleteById(UsersProtocolBufferOuterClass.UserByIdRequest request, StreamObserver<Empty> responseObserver) {
        super.deleteById(request, responseObserver);
    }

}
