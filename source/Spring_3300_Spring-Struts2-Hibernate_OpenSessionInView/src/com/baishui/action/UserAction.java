package com.baishui.action;
 
 
import java.util.List; 
import com.baishui.dto.UserDto;
import com.baishui.model.User;
import com.baishui.service.UserManager; 
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven; 

/* Action����������spring-struts-plugin
 *  Action ��scopeĬ�Ͼ���prototype���Բ��ü����ע��
 * �Զ����ע�� Ĭ�����Ե�ע���Ǹ�������ע��
 * @Component(value="userAction")
@Scope(value="prototype")*/
public class UserAction extends ActionSupport  implements ModelDriven<UserDto>{ 
	private static final long serialVersionUID = 1L; 
    /**
	 * 
	 */ 
	private  UserManager userManager;   
	private UserDto userDto = new UserDto();  
	private  List<User>  users;
	 

	public UserManager getUserManager() {
		return userManager;
	} 
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	} 
	 
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public UserDto getUserDto() {
		return userDto;
	} 
	
	  
	public  List<User>  getUsers() {  
		return users;
	}
	
	@Override
	public UserDto getModel() { 
		return this.userDto;
	}
	
	
	public String add() { 
		try { 
			System.out.println(this.userDto.getUsername());
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
	
	
	
	public String list(){  
		users = this.userManager.list(); 
		return "list";
	} 
	public String load(){  
		
		System.out.println(this.userDto.getId());
		this.userDto = this.userManager.load(this.userDto.getId()); 
	
		return "load";
	}
	
	
	/*@Override
	public void validate() { 
		String username = this.userDto.getUsername();
	    String password = this.userDto.getPassword();
		String password2 = this.userDto.getPassword2();
		
		if("".equals(username)||"".equals(password)||"".equals(password2)){
			this.addActionError("�������Ϊ��");
		}else{
			if(!password.equals(password2)){
				this.addActionError("�����������벻һ��");
			} 		
		} 
	}*/
	
     
	
}
