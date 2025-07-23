package org.example.login.dto;

import lombok.Getter;
import lombok.Setter;

/***
 * 로그인 할 때 request 받을 클래스
 */
@Getter
@Setter
public class UserLoginRequest {
    //아이디
    private String loginId;
    //비밀번호
    private String password;
}
