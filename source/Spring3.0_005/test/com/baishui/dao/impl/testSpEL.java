package com.baishui.dao.impl;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.baishui.model.User;

public class testSpEL {

	@Test
	public void testSpEL(){
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("new String('hello').toUpperCase()"); 
		System.out.println((String)exp.getValue());
	}
	@Test
	public void testSpEL1(){ 
		User user = new User();
		user.setUsername("zhangsan"); 
		EvaluationContext context = new StandardEvaluationContext(user);//������ 
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("username"); //����һ���µı��ʽ����,�൱�ڵ�����user.getUsername() 
		System.out.println((String)exp.getValue(context)); 
		System.out.println((String)exp.getValue(user)); 
	}
}
