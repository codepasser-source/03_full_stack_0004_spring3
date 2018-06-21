package com.baishui.dao;
 
 
import javax.annotation.Resource;
 
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
 

//@Component("superDao")
public  class SuperDao {
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	//@Resource 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	} 

	
}
