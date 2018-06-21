package com.baishui.dao; 
import com.baishui.model.Log; 
public interface LogDao {

	public void saveLog(Log msg) ;
	
	public void list();
}
