package kosta.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dao.ElectronicsDAO;
import kosta.model.dao.ElectronicsDAOImpl;
import kosta.model.dto.Electronics;

public class ElectronicsService {
	  private static  ElectronicsDAO eletronicsDAO = new ElectronicsDAOImpl();
	  /**
		 * ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
		 * */
		public static List<Electronics> selectAll() throws SQLException{
			List<Electronics> list = eletronicsDAO.selectAll();
			  return list;
		  }
		  
		  /**
		   * ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
		   * */
		  public static int insert(Electronics electronics) throws SQLException{
			  int re = eletronicsDAO.insert(electronics);
			  if(re==0)throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
			  return re;
		  }
		  
		  /**
		   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
		   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
		   * */
		  public static Electronics selectByModelNum(String modelNum , boolean state) throws SQLException{
			   //��ȸ���� ����
			   if(state) {//��ȸ������
				  if( eletronicsDAO.updateByreadNum(modelNum)==0 )
					  throw new SQLException("��ȸ�� ���� ��Ű�µ� ������ ������ϴ�.");
			   }
			   
			   //�󼼺��� �Խù� ��������
			   Electronics electronics = eletronicsDAO.selectByModelNum(modelNum);
			   if(electronics==null)throw new SQLException(modelNum+"�� �ش��ϴ� ��ǰ������ �����ϴ�.");
			   
			   return electronics;
		   }
		  
		  /**
		   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
		   * */
		  public static int delete(String model_num, String password) throws SQLException{
			  int re = eletronicsDAO.delete(model_num,password);
			  if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
			  return re;
		  }
		  
		  
		  /**
		   * ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
		   * */
		  public static int update(Electronics electronics) throws SQLException{
			  int re = eletronicsDAO.update(electronics);
			  if(re==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
			  return re;
		  }
		  
	
}












