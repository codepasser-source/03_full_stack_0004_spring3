package com.baishui.dao.impl;

import java.util.*;

import com.baishui.dao.UserDao;
import com.baishui.model.User;

public class UserDaoForOracleImpl implements UserDao {

	private Set<String> sets;
	private List<String> lists;
	private Map<String, String> maps;
	
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoForOracleImpl save user");
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	
}
