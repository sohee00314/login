package org.example.login.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key
    private Long id;
    //????
    private String name;
    //??? ? ? ??? ???
    private String loginId;
    //????
    private String password;

    //??
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.User;


}
