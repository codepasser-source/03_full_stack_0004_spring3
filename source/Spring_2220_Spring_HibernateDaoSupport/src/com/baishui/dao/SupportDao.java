package com.baishui.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

 
@Component
public class SupportDao extends HibernateDaoSupport{ 
	 
	//通过继承，并且实现注入一次其他子类 Dao不用重复配置注入
	
	/*第一种写法，将beans.xml中的 hibernateTemplate 注入给参数
	 * @Resource(name="hibernateTemplate")
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}*/ 
	
    //第二中写法（推荐），直接将sessionfactory注入给参数，此时就不用在beans.xml 配置事物管理器 HibernateTemplate	
    @Resource(name="sessionFactory")
	public void setSupperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	} 
}
