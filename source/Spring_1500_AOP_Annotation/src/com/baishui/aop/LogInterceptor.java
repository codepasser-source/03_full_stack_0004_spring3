package com.baishui.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component //���ڶ���ķ���ǰִ�У�ע���������Ǳ�spring������������
public class LogInterceptor { 
	
	 /*
	  * ��һ��д��
	  * before ��ֲ����﷨,ָ������ִ���ĸ�����ĸ�������*/
	/*@Before("execution(public void com.baishui.dao.impl.UserDaoForOracleImpl.saveUser(com.baishui.model.User))")
	public void before(){ 
		System.out.println("method start...");
	}  
	@AfterReturning("execution(public void com.baishui.dao.impl.UserDaoForOracleImpl.saveUser(com.baishui.model.User))")
	public void afterReturning(){ 
		System.out.println("method after...");
	} */

	/*	�ڶ���д��
	 * �������﷨  * ���壺�κε�   .���壺�ļ�·��*/
    /*@Before("execution(public * com.baishui.dao..*.*(..))")
		public void before(){ 
			System.out.println("method start...");
		} */
	
	/* 
	 * ������д��
	      �������*/
	//����һ�� ��Щ����Ҫִ�еķ���
	/*@Pointcut("execution(public * com.baishui.dao..*.*(..))")
	public void myMethod(){ 
	}*/
	
	//����service�������ʱ,��Ϊ�����û��ʵ���κνӿڣ���UserDaoForOracleImpl��ʵ���� UserDao�ӿ����Բ������cglib��
	//��Ҫ���  \spring-framework-2.5.6-with-dependencies\spring-framework-2.5.6\lib\cglib\cglib-nodep-2.1_3.jar
	@Pointcut("execution(public * com.baishui.service..*.addUser(..))")
	public void myMethod(){ 
	}
	
	//ʹ�ö�������ķ���
	@Before("myMethod()")
	public void before(){ 
		System.out.println("method start...");
	}  
	@AfterReturning("myMethod()")
	public void afterReturning(){ 
		System.out.println("method after...");
	} 
	
	//�����׳��쳣ʱִ�еķ���
	//ע����UserDaoForOracleImpl saveUser ���׳��쳣
	@AfterThrowing("myMethod()")
	public void afterThrowing(){ 
		System.out.println("method afterThrowing...");
	} 
	
    //ִ�з�����ǰ�󣬶�ִ�еķ���
	@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{ 
		System.out.println("method around...");
		System.out.println("method start...");
		pjp.proceed();
		System.out.println("method end...");
	} 
}
