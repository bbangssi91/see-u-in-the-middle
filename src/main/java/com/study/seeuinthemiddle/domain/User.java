package com.study.seeuinthemiddle.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.study.seeuinthemiddle.domain.enumpackage.Gender;
import com.study.seeuinthemiddle.domain.enumpackage.UserAuth;
import com.study.seeuinthemiddle.formVO.user.SignUpForm;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Table(
	name = "USER",
	uniqueConstraints = @UniqueConstraint(columnNames = {"email"})
)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    
    @NotEmpty(message = "이메일 값은 필수입니다.")
    private String email;
    
    private String name;
    private int age;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;
    
    @Enumerated(EnumType.STRING)
    private UserAuth userAuth;
    
	public static User fillSignUp(@Valid SignUpForm form) {
		
		return User.builder()
				.email(form.getEmail())
				.name(form.getName())
				.age(form.getAge())
				.gender(form.getGender())
				.address(Address.builder()
							.postcode(form.getPostcode())
							.address(form.getAddress())
							.detailAddress(form.getDetailAddress())
							.build()
						)
				.userAuth(UserAuth.USER) // 회원가입 form을 통해 접속한 유저 ( default : USER )
				.build();
	}

	@Builder
	public User(Long id, String email, String name, int age, Gender gender, Address address, UserAuth userAuth) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.userAuth = userAuth;
	}

}
