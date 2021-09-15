package com.study.seeuinthemiddle.domain;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Embeddable
public class Address {

    private String address1;
    private String address2;
    

    protected Address() {
    }
    
    @Builder
    public Address(String address1, String address2) {
    	this.address1 = address1;
    	this.address2 = address2;
    }
}
