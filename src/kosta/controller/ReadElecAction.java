package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;



public class ReadElecAction implements Action {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		
		String flag = request.getParameter("flag");//������ �Ϸ���� ���޵ȴ�.
		boolean state=false;
		
		if(flag==null)state=true;//list���� ������ Ŭ�������� ��Ȳ�̴�.
		
		//�𵨹�ȣ �ޱ�
		String modelNum = request.getParameter("modelNum");
	   try {
		  Electronics elec = ElectronicsService.selectByModelNum(modelNum, state);//��ȸ�� ����.
		  request.setAttribute("elec", elec);//�信�� ����ϴ� �̸�??
		  mv.setPath("elecView/read.jsp");
		
	   }catch (SQLException e) {
		e.printStackTrace();
		request.setAttribute("errorMsg", e.getMessage());
		mv.setPath("errorView/error.jsp");
	  }
		return mv;
	}

}


