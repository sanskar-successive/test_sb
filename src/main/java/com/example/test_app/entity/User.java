package com.example.test_app.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "name", nullable = false)
    private  String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private  String password;

    private  Boolean active;
}
