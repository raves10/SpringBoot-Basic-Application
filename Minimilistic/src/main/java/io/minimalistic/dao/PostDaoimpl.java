package io.minimalistic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.minimalistic.models.Posts;


@Repository
public class PostDaoimpl implements PostDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean addPost(Posts post) {
		Session session= entityManager.unwrap(Session.class);
		int id = (Integer) session.save(post);
		if(id != 0)
		{
			return true;
		}
		return false;
	}

	public List<Posts> getLoggedInUserPosts(int userId) {
		Query query = entityManager.createQuery(" from Posts where userId =:userId ", Posts.class);
		//query.getResultList().get(0);
		List<Posts> userPosts = new ArrayList<Posts>();
		query.setParameter("userId", userId);
		
		if(!query.getResultList().isEmpty())
		{
			userPosts = query.getResultList();
		}
		return userPosts;
	}

	@Transactional
	public boolean editPost(int id, String description) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createQuery(" Update Posts set postDescription =:description where postId =:id ");
		query.setParameter("description", description);
		query.setParameter("id", id);
		if(query.executeUpdate() > 0 )
		{
			
			return true;
		}
		return false;
	}

	@Transactional
	public boolean deletePost(int id) {
		
		Query query = entityManager.createQuery(" Delete from Posts  where postId =:id ");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0 )
		{
			
			return true;
		}
		return false;
	}

}
