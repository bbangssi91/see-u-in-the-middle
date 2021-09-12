package com.study.seeuinthemiddle.repository;

import com.study.seeuinthemiddle.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    /**
     * 이메일주소에 해당하는 회원 검색
     *
     * @param   "email 주소"
     * @return  "해당 이메일 주소에 해당하는 회원"
     */
    public User findByEmailAddress(String email) {
        return em.find(User.class, email);
    }

    /**
     * 회원 가입
     *
     * @param   "사용자 정보"
     */
    public void save(User user) {
        em.persist(user);
    }



}
