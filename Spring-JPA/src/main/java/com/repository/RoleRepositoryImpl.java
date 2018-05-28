package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Role;

@Repository("roleRepository")
public class RoleRepositoryImpl implements RoleRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Role save(Role role) {
		em.persist(role);
		em.flush();
		return role;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Role> getAll(){
		String queryString = "SELECT r FROM Role r";
	    Query query = em.createQuery(queryString);
	    return query.getResultList();
	}

	public Role getRole(long role) {
		Role roleInstance = em.find(Role.class, role);
		return roleInstance;
	}

}
