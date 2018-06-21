package com.baishui.dao;
 
 
import org.hibernate.SessionFactory;

import com.baishui.util.HibernateUtil;

public abstract class SuperDao {
	public  SessionFactory sessionFactory= HibernateUtil.getSessionFactory();  

}
