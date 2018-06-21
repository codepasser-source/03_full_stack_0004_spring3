package com.baishui.spring; 


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
		      //
		       Object o = Class.forName(clazz).newInstance(); //反射
		       beans.put(id, o); 
		    }   
	}



	public Object getBean(String id) { 
		return this.beans.get(id); //根据ID 得到对应类型的对象
	}

	 
	
}
