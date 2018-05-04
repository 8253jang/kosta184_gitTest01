package kosta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.dto.Electronics;
import kosta.model.service.ElectronicsService;



public class SelectElecAction implements Action {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		try{	
		  List<Electronics> list = ElectronicsService.selectAll();
		  request.setAttribute("list", list);//viewpage에서 ${list}
		  mv.setPath("elecView/list.jsp");
		 
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
			mv.setPath("errorView/error.jsp");
		}
		
		return mv;
		
	}
}



