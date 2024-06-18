package com.example.springGrpcExample.core;

import com.example.springGrpcExample.domain.Users;
import com.example.springGrpcExample.persistence.record.UsersTRec;
import com.example.springGrpcExample.persistence.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public Optional<UsersTRec> findById(Long id) {
        Optional<UsersTRec> usersTRecOptional = userRepository.findById(id);
        log.info(usersTRecOptional.isPresent());

//        return usersTRecOptional
//            .map(
//                u -> Users.builder()
//                    .identifier(u.getId())
//                    .email(u.getEmail())
//                    .fullName(u.getFullName())
//                    .build()
//            );

        return usersTRecOptional;
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void save(Users user) {
        UsersTRec usersTRec = new UsersTRec();
        usersTRec.setEmail(user.getEmail());
        usersTRec.setFullName(user.getFullName());
        userRepository.save(usersTRec);
    }

    @Override
    public void deleteById(Long id) {

    }
}