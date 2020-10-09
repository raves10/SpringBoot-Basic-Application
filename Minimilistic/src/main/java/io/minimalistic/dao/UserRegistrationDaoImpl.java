package io.minimalistic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import io.minimalistic.models.User;

@Repository
public class UserRegistrationDaoImpl implements UserRegistraionDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean register(User user) {
		// TODO Auto-generated method stub
		Session session= entityManager.unwrap(Session.class);
		int id = (Integer) session.save(user);
		if(id != 0)
		{
			return true;
		}
		return false;
	}

}
