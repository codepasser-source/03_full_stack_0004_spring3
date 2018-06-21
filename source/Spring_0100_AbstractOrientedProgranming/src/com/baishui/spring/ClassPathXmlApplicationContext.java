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
		    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml")); //�����ĵ�����
		    Element root=doc.getRootElement(); //��ȡ��Ԫ��
		    List list=root.getChildren("bean");//ȡ����Ϊbean������Ԫ�� 
		    for(int i=0;i<list.size();i++){ 
		       Element element=(Element)list.get(i); 
		       String id=element.getAttributeValue("id"); //ȡbean��Ԫ��class������
		       String clazz=element.getAttributeValue("class");//ȡbean��Ԫ��class������  
		       System.out.println("id:"+id); 
		       System.out.println("class:"+clazz);   
		      //
		       Object o = Class.forName(clazz).newInstance(); //����
		       beans.put(id, o); 
		    }   
	}



	public Object getBean(String id) { 
		return this.beans.get(id); //����ID �õ���Ӧ���͵Ķ���
	}

	 
	
}
