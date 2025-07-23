package org.example.login.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/***
 * 새로 생성된 날짜와 마지막 수정 날짜를 기록하기 위한 컬럼을
 * 상속 받기 위한 클래스
 */
@Getter
@MappedSuperclass//jpa 에서 공통 매핑을 상속받기 위한 애노테이션
@EntityListeners(AuditingEntityListener.class)//JPA Auditing(감사)를 활성화(자동저장) 하는 에노테이션
public abstract class BaseEntity {
    //생성 날짜 기록
    @CreatedDate
    private LocalDateTime createdAt;
    //마지막으로 수정할 날짜 기록
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
