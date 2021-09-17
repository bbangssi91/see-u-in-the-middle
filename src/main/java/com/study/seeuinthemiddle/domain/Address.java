package com.study.seeuinthemiddle.domain;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Embeddable
public class Address {

	private String postcode; // 우편번호
    private String address; // 기본주소
    private String detailAddress; // 상세주소
    
    @Builder
    public Address(String postcode, String address, String detailAddress) {
    	this.postcode = postcode;
    	this.address = address;
    	this.detailAddress = detailAddress;
    }
}
