package com.baishui.service;

import org.junit.Assert;
import org.junit.Test;

import com.baishui.model.User;
 

public class UserManagerTest{
    
	
	@Test
	public void testExiset() {
	 
		UserManager userMG = new UserManager();
		User user = new User();
		user.setUsername("myxr");
		user.setPassword("baishui");
		boolean exists = userMG.exists(user) ;
		
		Assert.assertEquals(true, exists);//���Է���
	}

	@Test
	/**
	 * ע����Ժ�� �����ֳ��Ļ�ԭ��Spring + hibernate �ع�
	 */
	public void testAddUser() {
		try {
			UserManager userMG = new UserManager();
			User user = new User();
			user.setUsername("myxr");
			user.setPassword("baishui");
		  if(userMG.exists(user)){
			  userMG.addUser(user);
		  } 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
