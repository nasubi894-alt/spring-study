package com.study.spring_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class SpringStudyApplication {

    private final HelloService helloService;
    private final LoginService loginService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/profile")
    public String profile() {
        return "Kota123";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/form")
    public String form() {
        return """
                <form action = "/hello">
                    <input
                type="text"
                name="name"
                required
                minlength="2"
                maxlength="10"
                pattern="[A-Za-z0-9]+">
                    <button type="submit">送信</button>
                </form>
                """;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return helloService.greet(name);
    }

    @GetMapping("/login")
    public String loginForm() {
        return """
                                <form action="/auth">
                    ユーザー名
                    <input name="userId">

                    パスワード
                    <input type="password" name="password">

                    <button>ログイン</button>
                </form>
                                """;
    }

    @GetMapping("/auth")
    public String auth(
            @RequestParam String userId,
            @RequestParam String password) {

        return loginService.login(userId, password);

    }

    @GetMapping("/save")
    public String save() {

        userRepository.save(
                new User("kou", "1234"));

        userRepository.save(
                new User("tanaka", "1111"));

        return "保存完了";
    }

    @GetMapping("/users")
    public String users() {

        return userRepository.findAll().toString();
    }

}