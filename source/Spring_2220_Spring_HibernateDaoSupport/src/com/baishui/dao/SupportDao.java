package com.baishui.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

 
@Component
public class SupportDao extends HibernateDaoSupport{ 
	 
	//ͨ���̳У�����ʵ��ע��һ���������� Dao�����ظ�����ע��
	
	/*��һ��д������beans.xml�е� hibernateTemplate ע�������
	 * @Resource(name="hibernateTemplate")
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}*/ 
	
    //�ڶ���д�����Ƽ�����ֱ�ӽ�sessionfactoryע�����������ʱ�Ͳ�����beans.xml ������������� HibernateTemplate	
    @Resource(name="sessionFactory")
	public void setSupperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	} 
}
