package io.minimalistic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.minimalistic.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	public boolean checkUserExists(String userName, String pwd) {
		// TODO Auto-generated method stub
		return loginDao.checkUserExists(userName,pwd);
		
	}

	

	public int findByUserName(String username) {
		// TODO Auto-generated method stub
		return loginDao.findByUserName(username);
	}

}
