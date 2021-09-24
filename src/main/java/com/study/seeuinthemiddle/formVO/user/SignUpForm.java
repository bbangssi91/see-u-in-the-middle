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
	
	@NotEmpty(message = "비밀번호는 필수입니다.")
	private String password;
	
	private String name;
	private int age;
	private Gender gender;
	
	@NotEmpty(message = "우편번호 찾기 버튼으로 주소를 선택하시기 바랍니다.")
	private String postcode; // 우편번호
	@NotEmpty(message = "우편번호 찾기 버튼으로 주소를 선택하시기 바랍니다.")
	private String address; // 기본주소
	@NotEmpty(message = "상세주소를 입력하십시오.")
	private String detailAddress; // 상세주소
	
}
