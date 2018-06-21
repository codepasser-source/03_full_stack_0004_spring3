package com.baishui.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInterceptor implements InvocationHandler {

	private Object target;
	
	 public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void beforeMethod(Method m){
		 
		 System.out.println("��Ҫ������ӵ�ҵ���߼����ܿ�..."+m.getName());
	 }
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable { 
		beforeMethod(method); 
		method.invoke(target, args); 
		return null;
	}

	
	
}
