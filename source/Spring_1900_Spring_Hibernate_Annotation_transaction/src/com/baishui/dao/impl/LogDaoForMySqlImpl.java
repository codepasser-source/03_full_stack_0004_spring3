package com.baishui.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.baishui.dao.LogDao;
 
import com.baishui.model.Log;

@Component(value="logDaoForMySql")
public class LogDaoForMySqlImpl implements LogDao {

	private SessionFactory sessionFactory;  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 

	public void list() {
		// TODO Auto-generated method stub 
	}

	public void saveLog(Log msg) {
		System.out.println("LogDaoForMySqlImpl saveLog ...");
		Session session = sessionFactory.getCurrentSession(); 
		session.save(msg); 
		throw new RuntimeException("error");//模拟一个运行时异常
	}

}
