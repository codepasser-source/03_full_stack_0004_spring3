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
@Component //用在对象的方法前执行，注意对象必须是被spring管理起来的类
public class LogInterceptor { 
	
	 /*
	  * 第一种写法
	  * before 的植入点语法,指定加入执行哪个类的哪个方法上*/
	/*@Before("execution(public void com.baishui.dao.impl.UserDaoForOracleImpl.saveUser(com.baishui.model.User))")
	public void before(){ 
		System.out.println("method start...");
	}  
	@AfterReturning("execution(public void com.baishui.dao.impl.UserDaoForOracleImpl.saveUser(com.baishui.model.User))")
	public void afterReturning(){ 
		System.out.println("method after...");
	} */

	/*	第二种写法
	 * 其他的语法  * 含义：任何的   .含义：文件路径*/
    /*@Before("execution(public * com.baishui.dao..*.*(..))")
		public void before(){ 
			System.out.println("method start...");
		} */
	
	/* 
	 * 第三种写法
	      切入点编程*/
	//定义一个 那些类需要执行的方法
	/*@Pointcut("execution(public * com.baishui.dao..*.*(..))")
	public void myMethod(){ 
	}*/
	
	//用在service层的切面时,因为这个类没有实现任何接口，（UserDaoForOracleImpl中实现了 UserDao接口所以不用添加cglib）
	//需要添加  \spring-framework-2.5.6-with-dependencies\spring-framework-2.5.6\lib\cglib\cglib-nodep-2.1_3.jar
	@Pointcut("execution(public * com.baishui.service..*.addUser(..))")
	public void myMethod(){ 
	}
	
	//使用定义切入的方法
	@Before("myMethod()")
	public void before(){ 
		System.out.println("method start...");
	}  
	@AfterReturning("myMethod()")
	public void afterReturning(){ 
		System.out.println("method after...");
	} 
	
	//声明抛出异常时执行的方法
	//注意在UserDaoForOracleImpl saveUser 中抛出异常
	@AfterThrowing("myMethod()")
	public void afterThrowing(){ 
		System.out.println("method afterThrowing...");
	} 
	
    //执行方法的前后，都执行的方法
	@Around("myMethod()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{ 
		System.out.println("method around...");
		System.out.println("method start...");
		pjp.proceed();
		System.out.println("method end...");
	} 
}
