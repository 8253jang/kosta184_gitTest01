package kosta.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {
	  private static  ElectronicsDAO eletronicsDAO = new ElectronicsDAOImpl();
	  /**
		 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
		 * */
		public static List<Electronics> selectAll() throws SQLException{
			List<Electronics> list = eletronicsDAO.selectAll();
			  return list;
		  }
		  
		  /**
		   * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
		   * */
		  public static int insert(Electronics electronics) throws SQLException{
			  int re = eletronicsDAO.insert(electronics);
			  if(re==0)throw new SQLException("등록되지 않았습니다.");
			  return re;
		  }
		  
		  /**
		   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
		   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
		   * */
		  public static Electronics selectByModelNum(String modelNum , boolean state) throws SQLException{
			   //조회수를 증가
			   if(state) {//조회수증가
				  if( eletronicsDAO.updateByreadNum(modelNum)==0 )
					  throw new SQLException("조회수 증가 시키는데 문제가 생겼습니다.");
			   }
			   
			   //상세보기 게시물 가져오기
			   Electronics electronics = eletronicsDAO.selectByModelNum(modelNum);
			   if(electronics==null)throw new SQLException(modelNum+"에 해당하는 상품정보는 없습니다.");
			   
			   return electronics;
		   }
		  
		  /**
		   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
		   * */
		  public static int delete(String model_num, String password) throws SQLException{
			  int re = eletronicsDAO.delete(model_num,password);
			  if(re==0)throw new SQLException("삭제되지 않았습니다.");
			  return re;
		  }
		  
		  
		  /**
		   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
		   * */
		  public static int update(Electronics electronics) throws SQLException{
			  int re = eletronicsDAO.update(electronics);
			  if(re==0)throw new SQLException("수정되지 않았습니다.");
			  return re;
		  }
		  
	
}












