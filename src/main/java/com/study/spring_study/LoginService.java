package com.study.spring_study;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public String login(String id, String pass) {

        User user = userRepository
                .findById(id)
                .orElse(null);

        if (user != null
                && user.getPassword().equals(pass)) {
            return "成功";
        }

        return "失敗";
    }
}