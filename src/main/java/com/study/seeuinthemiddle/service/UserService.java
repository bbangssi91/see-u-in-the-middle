package com.study.seeuinthemiddle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.seeuinthemiddle.Exception.DuplicatedUserException;
import com.study.seeuinthemiddle.domain.User;
import com.study.seeuinthemiddle.formVO.user.SignUpForm;
import com.study.seeuinthemiddle.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    // TODO : 1. 회원가입
    @Transactional
    public void signUp(User user){
        // 중복회원 체크
        validateDuplicatedUser(user);
        userRepository.save(user);
    }

    // TODO : 2. 전체 회원조회
    public List<User> findAllUsers(){
    	return userRepository.findAll();
    }
    
    // TODO : 3. 특정 회원조회
    public User findOne(User user) {
    	return userRepository.findOne(user.getId());
    }
    
    // TODO : 4. 회원 정보수정
    @Transactional
	public void updateUser(Long userId, SignUpForm userForm) {
    	User resultUser = userRepository.findOne(userId);
    	
    	User.update(userForm);
    	
	}
    
    // TODO : 5. 회원 탈퇴
    
    private void validateDuplicatedUser(User user) {
    	List<User> findUser = userRepository.findByEmailAddress(user.getEmail());

        if(!findUser.isEmpty()){
            throw new DuplicatedUserException("이미 가입된 회원입니다.");
        }


    }




}
