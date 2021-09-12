package com.study.seeuinthemiddle.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String detailAddress;

    protected Address() {
    }

    public Address(String city, String street, String detailAddress) {
        this.city = city;
        this.street = street;
        this.detailAddress = detailAddress;
    }
}
