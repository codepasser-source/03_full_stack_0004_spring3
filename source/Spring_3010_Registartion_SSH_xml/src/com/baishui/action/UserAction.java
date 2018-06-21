package com.baishui.action;
 

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.baishui.dto.UserDto;
import com.baishui.model.User;
import com.baishui.service.UserManager;
 
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
 


//@Component(value="userAction")
//@Scope(value="prototype")
public class UserAction extends ActionSupport  implements ModelDriven{ 
	private static final long serialVersionUID = 1L; 
    /**
	 * 
	 */ 
	private  UserManager userManager;  
	
	private UserDto userDto = new UserDto(); 
	
	public UserManager getUserManager() {
		return userManager;
	}
	//@Resource(name="userManager")
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	} 
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
 
	
	@Override
	public Object getModel() { 
		return this.userDto;
	} 
	
	@Override
	public String execute() throws Exception {
	
		try {
			 
			 User user = new User();
			 user.setUsername(userDto.getUsername());
			 user.setPassword(this.userDto.getPassword());
			 
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
	@Override
	public void validate() {
	 
		String username = this.userDto.getUsername();
	    String password = this.userDto.getPassword();
		String password2 = this.userDto.getPassword2();
		
		if("".equals(username)||"".equals(password)||"".equals(password2)){
			this.addActionError("必填项不能为空");
		}else{
			if(!password.equals(password2)){
				this.addActionError("两次密码输入不一致");
			} 		
		}
		
	}
	
     
	
}
