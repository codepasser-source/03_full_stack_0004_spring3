package com.baishui.dao.impl;

 
import org.springframework.stereotype.Component;

import com.baishui.dao.LogDao;
import com.baishui.dao.SupportDao;
 
import com.baishui.model.Log;

@Component(value="logDaoForMySql")
public class LogDaoForMySqlImpl extends SupportDao implements LogDao { 
	public void list() {
		// TODO Auto-generated method stub 
	} 
	public void saveLog(Log msg) {
		System.out.println("LogDaoForMySqlImpl saveLog ..."); 
		this.getHibernateTemplate().save(msg); 
		//throw new RuntimeException("error");//模拟一个运行时异常
	} 
}
