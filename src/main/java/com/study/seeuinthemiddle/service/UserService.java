package com.study.seeuinthemiddle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.seeuinthemiddle.Exception.DuplicatedUserException;
import com.study.seeuinthemiddle.domain.User;
import com.study.seeuinthemiddle.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
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
    public List<User> findAll(){
    	return userRepository.findAll();
    }
    
    // TODO : 3. 특정 회원조회
    public User findOne(User user) {
    	return userRepository.findOne(user.getId());
    }
    
    // TODO : 4. 회원 정보수정
    
    // TODO : 5. 회원 탈퇴
    
    
    private void validateDuplicatedUser(User user) {
        User findUser = userRepository.findByEmailAddress(user.getEmail());

        if(findUser != null){
            throw new DuplicatedUserException("이미 가입된 회원입니다.");
        }


    }


}
