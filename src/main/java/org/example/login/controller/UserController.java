package org.example.login.controller;

import lombok.RequiredArgsConstructor;
import org.example.login.dto.UserCreateRequest;
import org.example.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/***
 * 회원 가입과 로그인 요청을 위한 Controller
 */
@Controller
@RequiredArgsConstructor//final를 필드하기 위한 애노테이션
public class UserController {
    //할당 후 변경되지 않아야 한다
    private final UserService  userService;

    /***
     * 회원가입 페이지로 요청하는 메서드
     * @return "register"
     */
    @GetMapping("/register")
    public String ShowRegister() {
        return "register";
    }

    /***
     * 회원 가입 기능 요청하는 메서드
     * 회원 가입 후 처음 페이지로 돌아간다
     */
    @PostMapping("/register")
    public String showRegister(UserCreateRequest request) {
        userService.register(request);
        return "redirect:/";
    }

    /***
     * 로그인 페이지로 넘어가는 메서드
     */
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}
