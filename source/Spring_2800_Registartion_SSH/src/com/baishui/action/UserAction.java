package com.baishui.action;
 

import com.baishui.model.User;
import com.baishui.service.UserManager;
import com.baishui.util.SpringApplactionContext;
 
import com.opensymphony.xwork2.ActionSupport;

 
public class UserAction extends ActionSupport { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
    private  static final UserManager userManager =(UserManager) SpringApplactionContext.getBean("userManager"); 
    
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
