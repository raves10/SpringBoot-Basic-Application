package io.minimalistic.services;

public interface LoginService {
	
	
	public boolean checkUserExists(String userName, String pwd);
	public int findByUserName(String username);

}
