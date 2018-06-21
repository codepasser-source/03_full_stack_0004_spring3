package com.baishui.spring; 


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
 

public class ClassPathXmlApplicationContext implements BeanFactory{

	private Map<String, Object> beans = new HashMap<String, Object>();
	
	public ClassPathXmlApplicationContext() throws Exception{
		    SAXBuilder sb=new SAXBuilder(); 
		    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml")); //�����ĵ�����
		    Element root=doc.getRootElement(); //��ȡ��Ԫ��
		    List list=root.getChildren("bean");//ȡ����Ϊbean������Ԫ�� 
		    for(int i=0;i<list.size();i++){ 
		       Element element=(Element)list.get(i); 
		       String id=element.getAttributeValue("id"); //ȡbean��Ԫ��class������
		       String clazz=element.getAttributeValue("class");//ȡbean��Ԫ��class������  
		       System.out.println("id:"+id); 
		       System.out.println("class:"+clazz);    
		       Object o = Class.forName(clazz).newInstance(); //���� ������Ӧ���͵� ����
		       beans.put(id, o);  
		       for(Element propertyElement : (List<Element>)element.getChildren("property")) {
		    	   String name = propertyElement.getAttributeValue("name"); //userDAO
		    	   String bean = propertyElement.getAttributeValue("bean"); //userdfo
		    	   Object beanObject = beans.get(bean);//UserDAOImpl instance 
		    	   String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);//ƴ��������
		    	   System.out.println("method name = " + methodName); 
		    	   Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);//���Ʒ�ת ��service��userDao ���Ը�ֵ
		    	   m.invoke(o, beanObject);//ִ��setUserDao����
		       }
		    }   
	}



	public Object getBean(String id) { 
		return this.beans.get(id); //����ID �õ���Ӧ���͵Ķ���
	}

	 
	
}