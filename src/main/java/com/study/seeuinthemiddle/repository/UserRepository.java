package com.study.seeuinthemiddle.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.study.seeuinthemiddle.domain.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    /**
     * 회원 가입
     *
     * @param   "사용자 정보"
     */
    public void save(User user) {
    	log.debug("===========> " + user.toString() + " ==============");
    	em.persist(user);
    }

    /**
     * 전체 사용자 조회
     * 
     * @return 	"List 전체 사용자 목록"
     */
	public List<User> findAll() {
		return em.createQuery("select u from User u", User.class)
			.getResultList();
	}

	/**
     * 회원 조회 (1인)
     *
     * @param   "조회조건 사용자 id(pk)"
     * 
     * @return 	"사용자"
     */
	public User findOne(Long id) {
		return em.find(User.class, id);
	}
	
    /**
     * 이메일주소에 해당하는 회원 검색
     *
     * @param   "email 주소"
     * @return  "해당 이메일 주소에 해당하는 회원"
     */
    public User findByEmailAddress(String email) {
        return em.find(User.class, email);
    }


}
