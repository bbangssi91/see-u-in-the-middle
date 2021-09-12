package com.study.seeuinthemiddle.domain;

import com.study.seeuinthemiddle.domain.enumpackage.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String name;
    private int age;
    private Gender gender;

    @Embedded
    private Address address;

}
