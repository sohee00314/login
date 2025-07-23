package org.example.login.dto;

import lombok.Getter;
import lombok.Setter;

/***
 * 회원가입 할때 request 받을 유저 클래스
 */
@Getter
@Setter
public class UserCreateRequest {
    //로그인 아이디
    private String loginId;
    //비밀번호
    private String password;
    //이름 value="<%=%>"
    private String name;
    
}
