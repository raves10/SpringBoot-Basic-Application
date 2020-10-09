package io.minimalistic.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import io.minimalistic.models.User;

@Repository
public class LoginDaoimpl implements LoginDao{

	@PersistenceContext
	private EntityManager entityManager;
		

	
	public boolean checkUserExists(String userName, String pwd) {
		Query query = entityManager.createQuery(" from User where username =:userName and password =:pwd", User.class);
		//query.getResultList().get(0);
		
		query.setParameter("userName", userName);
		query.setParameter("pwd", pwd);
		if(!query.getResultList().isEmpty())
		{
			return true;
		}
		return false;
	}



	public int findByUserName(String username) {
		//TypedQuery<User> query = entityManager.createQuery(" select id from User where username =:userName", User.class);
		//query.getResultList().get(0);
		Query query = entityManager.createQuery(" select id from User where username =:userName", Integer.class);
		query.setParameter("userName", username);
		
		if(query.getSingleResult() !=null)
		{
			return (Integer) query.getSingleResult();
		}
		return 0;
	}

}


	