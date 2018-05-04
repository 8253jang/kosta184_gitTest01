package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;



public class InsertElecAction implements Action {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����÷�ζ����� multipartRequst�ʿ�.
		 String saveDir = request.getSession().getServletContext().getRealPath("/save/");
				  
	    int maxSize=1024*1024*100;//100m
	     String encoding="UTF-8";
		ModelAndView mv = new ModelAndView();
		try {
			MultipartRequest m =
					  new MultipartRequest(request, saveDir, 
						  maxSize, encoding, new DefaultFileRenamePolicy());
			  
			  String modelNum =  m.getParameter("model_num");
			  String modelName =  m.getParameter("model_name");
			  String price =  m.getParameter("price");
			  String description =  m.getParameter("description");
			  String password =  m.getParameter("password");  
			 
			  //�Է����� ��ȿ�� üũ
			  if(modelNum==null || modelName==null || price==null
					  || description==null ||password==null ){
				
				  throw new SQLException("�Է°��� ������� �ʽ��ϴ�.");
			  }
			  
			  System.out.println("��ȯ �� : " + description);
				 //description�ȿ� �±׸� ���ڷ� ��ȯ!!!
				 description = description.replaceAll("<", "&lt;");
				 
			System.out.println("��ȯ �� : " + description);
				 
			  
			  Electronics elec =
				new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
			  
			 if(m.getFilesystemName("file")!= null){//����÷�εǾ��ٸ�
				 elec.setfName(m.getFilesystemName("file"));
	             elec.setfSize((int)m.getFile("file").length());			 
			 }
			 
			 
			 
			 int re = ElectronicsService.insert(elec);
			  if(re>0) {//����� �Ϸ�Ǿ���.
				  mv.setPath("elec?command=list"); 
				  mv.setRedirect(true);//redirect������� �̵�.
			  }

		}catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			mv.setPath("errorView/error.jsp");
		}
		
		return mv;
	}

}



