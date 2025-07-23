package org.example.login.domain;

import jakarta.persistence.*;
import lombok.*;

/***
 * User 테이블을 만들기 위한 클래스
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    //자동으로 증가하는 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key
    private Long id;
    //회원이름
    private String name;
    //로그인 할때 사용할 아이디
    private String loginId;
    //비밀번호
    private String password;

    //유저와 관리인을 나누기 위한 컬럼
    @Enumerated(EnumType.STRING)//데이터를 문자열로 보내는 에노테이션
    @Builder.Default//기본값 설정하기 위한 에노테인션
    private Role role = Role.User;//기본값 User


}
