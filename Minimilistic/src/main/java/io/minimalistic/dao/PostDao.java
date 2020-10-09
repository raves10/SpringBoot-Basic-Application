package io.minimalistic.dao;

import java.util.List;

import io.minimalistic.models.Posts;

public interface PostDao {

	public boolean addPost(Posts post);
	public List<Posts> getLoggedInUserPosts(int userId);
	public boolean editPost(int id, String description);
	public boolean deletePost(int id);
}
