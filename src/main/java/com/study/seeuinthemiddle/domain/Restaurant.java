package com.study.seeuinthemiddle.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Restaurant {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;
    private String restaurantName;

    @Embedded
    private Address address;

    private int totalStarPoint; // 총 별점


}
