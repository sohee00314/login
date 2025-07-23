package org.example.login.repository;

import org.example.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/***
 * JPA 가 자동으로 구현체를 생성하재는 인터페이스
 * JpaRepository<User, Long> : DB 접근하는 메서드(save,findAll,findId 등)
 */
public interface UserRepository extends JpaRepository<User, Long> {
    //값을 입력하는 User의 loginId 필드에 자동으로 매칭
    Optional<User> findByLoginId(String loginId);

    /*
     * jpa
     * select
     */
}
