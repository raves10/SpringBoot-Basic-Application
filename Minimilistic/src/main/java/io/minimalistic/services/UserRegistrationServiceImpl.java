package io.minimalistic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.minimalistic.dao.UserRegistraionDao;
import io.minimalistic.models.User;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	private UserRegistraionDao dao;
	
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

}
