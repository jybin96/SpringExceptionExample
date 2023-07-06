package com.example.exeption.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private int age;
    @Column
    private int money;

    public Member(String name, String email, int age, int money) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.money = money;
    }
}
