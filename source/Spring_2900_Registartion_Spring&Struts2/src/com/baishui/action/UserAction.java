package com.baishui.action;
 

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.baishui.model.User;
import com.baishui.service.UserManager;
 
import com.opensymphony.xwork2.ActionSupport;


@Component(value="userAction")
@Scope(value="prototype")
public class UserAction extends ActionSupport { 
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  UserManager userManager; 
    private String username;
    private String password;
    private String password2; 
	
	public String getUsername() {
		return username;
	} 
	public void setUsername(String username) {
		this.username = username;
	} 
	public String getPassword() {
		return password;
	} 
	public void setPassword(String password) {
		this.password = password;
	} 
	public String getPassword2() {
		return password2;
	} 
	public void setPassword2(String password2) {
		this.password2 = password2;
	} 
 
	
	
	public UserManager getUserManager() {
		return userManager;
	}
	@Resource(name="userManager")
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Override
	public String execute() throws Exception {
	
		try {
			User user = new User();
			user.setUsername(this.username);
			user.setPassword(this.password);
			if(userManager.exists(user)){ 
				userManager.addUser(user);
			}else{
				return "fail";
			}  
		} catch (Exception e) {
			 e.printStackTrace();
			 return "input";
		}
		return  "success";
	}

	
	
}
