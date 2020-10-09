package io.minimalistic.dao;



//import io.minimalistic.models.CustomUser;
import io.minimalistic.models.User;

public interface LoginDao {
	public boolean checkUserExists(String userName, String pwd);
	public int findByUserName(String username);

}
