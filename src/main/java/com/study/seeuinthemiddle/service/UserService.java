package com.study.seeuinthemiddle.service;

import com.study.seeuinthemiddle.Exception.DuplicatedUserException;
import com.study.seeuinthemiddle.domain.User;
import com.study.seeuinthemiddle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // TODO : 1. 회원가입
    @Transactional
    public Long join(User user){

        // 중복회원 체크
        validateDuplicatedUser(user);
        userRepository.save(user);

        return user.getId();
    }

    // TODO : 2. 전체 회원조회
    // TODO : 3. 특정 회원조회
    // TODO : 4. 회원 정보수정
    // TODO : 5. 회원 탈퇴

    private void validateDuplicatedUser(User user) {
        User findUser = userRepository.findByEmailAddress(user.getEmail());

        if(findUser != null){
            throw new DuplicatedUserException("이미 가입된 회원입니다.");
        }


    }


}
