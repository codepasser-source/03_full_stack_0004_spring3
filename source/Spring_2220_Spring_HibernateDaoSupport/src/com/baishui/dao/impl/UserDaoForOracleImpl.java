package com.baishui.dao.impl;

import org.springframework.stereotype.Component;

import com.baishui.dao.UserDao;
import com.baishui.model.User;


@Component(value="userDaoForOracle") 
public class UserDaoForOracleImpl implements UserDao {
 
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoForOracleImpl saveUser method"); 
		//throw new  RuntimeException("Exception!!");
	}

	public void list() {
		// TODO Auto-generated method stub
		
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	 
}
