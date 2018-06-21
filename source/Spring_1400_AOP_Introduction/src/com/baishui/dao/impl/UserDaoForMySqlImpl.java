package com.baishui.dao.impl;

import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForMySqlImpl implements UserDao{

	public void saveUser(User u) {  
		System.out.println("UserDaoForMySqlImpl user save");
	}

	public void deleteUser(User u) {
		System.out.println("UserDaoForMySqlImpl user delete ");
		
	}

}
