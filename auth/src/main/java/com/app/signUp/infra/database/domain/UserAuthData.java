package com.app.signUp.infra.database.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users_auth")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAuthData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_auth_id")
    private Long id;
    @Column(name = "user_auth_name")
    private String name;
    @Column(name = "user_auth_email")
    private String email;
    @Column(name = "user_auth_password")
    private String password;

}
