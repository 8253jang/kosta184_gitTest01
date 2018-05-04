package kosta.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.controller.Action;


@WebListener
public class ActionMappingListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent e)  { }

	
    public void contextInitialized(ServletContextEvent e)  { 
    	//��ü���� ������ ~.properties���Ͽ� 
    	//�ֱ⶧���� properties�� ���� �о�´�.(ResourceBundle��ü)
    	
        //�̸� ��ü �����ؼ�  map���� -> application���� (�����ʱ�ȭ�۾�)
    	//contextparam��������
    	ServletContext context = e.getServletContext();
    	String fileName = context.getInitParameter("fileName");
    	
    	//���ҹ������̿��ؼ� ���� �ε�
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	
    	Map<String, Action> map = new HashMap<String, Action>();
    	
    	for(String key : rb.keySet()){
    		String value = rb.getString(key);
    		try{
	    		//System.out.println(key +" : " + value);
    			//map�� properties���Ͽ� �ִ� ��ü�� �����ؼ� �ִ´�.
	    		Action action = (Action)Class.forName(value).newInstance();
	    		map.put(key, action);
    		   System.out.println(key+" = " + action);
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}	
    	}//for��
    	
    	//map�� ServletContext������ �����Ѵ�.
    	context.setAttribute("map", map);
    	
    	
    }
	
}
