package com.sunonline.web.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate4Util {
	
	private static SessionFactory sessionFactory = null;
	
	private static final ThreadLocal<Session> THREAD_LOCAL = new ThreadLocal<>();
	
	private Hibernate4Util(){}
	
	synchronized public static SessionFactory getSessionFactoryInstance() {
		
		Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
			
		if (sessionFactory == null) {
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
	/**
	 * 返回ThreadLocal中的Session
	 * @return session
	 */
	public static Session getSession() {
		Session session = THREAD_LOCAL.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				sessionFactory = getSessionFactoryInstance();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			THREAD_LOCAL.set(session);
		}
		return session;
	}
}
