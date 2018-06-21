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
		    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml")); //构造文档对象
		    Element root=doc.getRootElement(); //获取根元素
		    List list=root.getChildren("bean");//取名字为bean的所有元素 
		    for(int i=0;i<list.size();i++){ 
		       Element element=(Element)list.get(i); 
		       String id=element.getAttributeValue("id"); //取bean子元素class的内容
		       String clazz=element.getAttributeValue("class");//取bean子元素class的内容  
		       System.out.println("id:"+id); 
		       System.out.println("class:"+clazz);    
		       Object o = Class.forName(clazz).newInstance(); //反射 创建对应类型的 对象
		       beans.put(id, o);  
		       for(Element propertyElement : (List<Element>)element.getChildren("property")) {
		    	   String name = propertyElement.getAttributeValue("name"); //userDAO
		    	   String bean = propertyElement.getAttributeValue("bean"); //userdfo
		    	   Object beanObject = beans.get(bean);//UserDAOImpl instance 
		    	   String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);//拼出方法名
		    	   System.out.println("method name = " + methodName); 
		    	   Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);//控制反转 将service的userDao 属性赋值
		    	   m.invoke(o, beanObject);//执行setUserDao方法
		       }
		    }   
	}



	public Object getBean(String id) { 
		return this.beans.get(id); //根据ID 得到对应类型的对象
	}

	 
	
}
