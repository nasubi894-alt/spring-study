package com.study.spring_study;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greet(String name) {

        if (!name.matches("[A-Za-z0-9]+")) {
            return "半角英数字のみ入力してください";
        }

        return "こんにちは " + name + "さん";
    }
}