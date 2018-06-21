package com.baishui.dao.impl;

import javax.annotation.Resource;
 
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.baishui.dao.LogDao;
 
import com.baishui.model.Log;

@Component(value="logDaoForMySql")
public class LogDaoForMySqlImpl implements LogDao {

	private HibernateTemplate hibernateTemplate;  
	 
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void list() {
		// TODO Auto-generated method stub 
	}

	public void saveLog(Log msg) {
		System.out.println("LogDaoForMySqlImpl saveLog ..."); 
		hibernateTemplate.save(msg); 
		throw new RuntimeException("error");//模拟一个运行时异常
	} 
}
