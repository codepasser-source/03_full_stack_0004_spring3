package com.baishui.service;
 

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

 
import java.util.List;

import com.baishui.dao.UserDao; 
import com.baishui.dto.UserDto;
import com.baishui.model.User;
 
@Component("userManager")
public class UserManager {
	
	 
	private UserDao userDaoForMySqlImpl;
 

	public UserDao getUserDaoForMySqlImpl() {
		return userDaoForMySqlImpl;
	}
    @Resource(name="userDaoForMySqlImpl")
	public void setUserDaoForMySqlImpl(UserDao userDaoForMySqlImpl) {
		this.userDaoForMySqlImpl = userDaoForMySqlImpl;
	}

	public boolean exists(User u){
		boolean b = userDaoForMySqlImpl.exists(u);
		 return b;
	}
	
	public void addUser(User u){
		
		 
			userDaoForMySqlImpl.addUser(u); 
		 
	}
	
	public  List<User>  list(){ 
		 List<User>  users  = userDaoForMySqlImpl.list(); 
		return  users;
	}
	
	public UserDto load(int id){
		User user=this.userDaoForMySqlImpl.load(id);  
		UserDto userDto = null;
		if(user!=null){
			userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setPassword(user.getPassword());
			userDto.setUsername(user.getUsername());
		} 
		return userDto;
	}

}
