package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public User save(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<User> getAll(){
		String queryString = "SELECT r FROM User r";
	    Query query = em.createQuery(queryString);
	    return query.getResultList();
	}
}
