package com.baishui.dao;

 
import java.util.List;
 
import com.baishui.model.User;

public interface UserDao { 
	public  abstract Object  select(Object model); 
	public  abstract List<User>  list();
	public  abstract User load(int id);
	public  abstract void  insert(Object model) ; 
	public  abstract void  update(Object model) ;
	public abstract boolean exists(User u);
	public abstract void addUser(User u); 
	
}
