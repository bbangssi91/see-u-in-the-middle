package com.study.seeuinthemiddle.formVO.user;

import javax.validation.constraints.NotEmpty;

import com.study.seeuinthemiddle.domain.enumpackage.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class SignUpForm {

	@NotEmpty(message = "이메일 주소는 필수입니다.")
	private String email;
	
	private String name;
	private int age;
	private Gender gender;
	private String address;
	
}
