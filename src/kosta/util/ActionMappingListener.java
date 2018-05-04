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
    	//객체들의 정보는 ~.properties파일에 
    	//있기때문에 properties을 먼저 읽어온다.(ResourceBundle객체)
    	
        //미리 객체 생성해서  map저장 -> application저장 (사전초기화작업)
    	//contextparam가져오기
    	ServletContext context = e.getServletContext();
    	String fileName = context.getInitParameter("fileName");
    	
    	//리소번들을이용해서 파일 로딩
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	
    	Map<String, Action> map = new HashMap<String, Action>();
    	
    	for(String key : rb.keySet()){
    		String value = rb.getString(key);
    		try{
	    		//System.out.println(key +" : " + value);
    			//map에 properties파일에 있는 객체들 생성해서 넣는다.
	    		Action action = (Action)Class.forName(value).newInstance();
	    		map.put(key, action);
    		   System.out.println(key+" = " + action);
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}	
    	}//for끝
    	
    	//map을 ServletContext영역에 저장한다.
    	context.setAttribute("map", map);
    	
    	
    }
	
}
