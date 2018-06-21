package com.baishui.dao.impl;

import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForOracleImpl implements UserDao {

	private int daoId;
	
	public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}

	public void saveUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoForOracleImpl save user");
	}

	@Override
	public String toString() {
		 
		return "daoId="+this.daoId;
	}
}
