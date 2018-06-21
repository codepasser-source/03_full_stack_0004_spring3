package com.baishui.callback;

import org.hibernate.Session;


public interface MyHibernateCallback {
	public void doInHibernate(Session s);
}
