package com.baishui.dao; 
import com.baishui.model.User; 
public interface UserDao {  
	public void saveUser(User u); 
	public User getUser(int id);
	public void list();
}
