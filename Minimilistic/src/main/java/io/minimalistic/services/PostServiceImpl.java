package io.minimalistic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.minimalistic.dao.PostDao;
import io.minimalistic.models.Posts;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;
	
	public boolean addPost(Posts post) {
		// TODO Auto-generated method stub
		return postDao.addPost(post);
	}

	public List<Posts> getLoggedInUserPosts(int userId) {
		// TODO Auto-generated method stub
		return postDao.getLoggedInUserPosts(userId);
	}

	public boolean editPost(int id, String description) {
		// TODO Auto-generated method stub
		return postDao.editPost(id, description);
	}

	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		return postDao.deletePost(id);
	}

}
