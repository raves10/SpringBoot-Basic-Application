package io.minimalistic.services;

import java.util.List;

import io.minimalistic.models.Posts;

public interface PostService {

	
	public boolean addPost(Posts post);
	public List<Posts> getLoggedInUserPosts(int userId);
	public boolean editPost(int id, String description);
	public boolean deletePost(int id);
}
