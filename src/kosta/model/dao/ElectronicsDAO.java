package kosta.model.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.model.dto.Electronics;

public interface ElectronicsDAO {
	 /**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<Electronics> selectAll() throws SQLException;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * */
	  Electronics selectByModelNum(String modelNum) throws SQLException;
	  
	  /**
	   * �󼼺��⸦ Ŭ�������� ��ȸ�� ����
	   *   update electronics set readnum = readnum+1 where model_Num=?
	   * */
	  int updateByreadNum(String modelNum)throws SQLException;
	  
	/**
	 * ���ڵ� ����
	 * @return : 1-���Լ��� , 0 - ���Խ���
	 * */
	  int insert(Electronics electronics) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1-�������� , 0 - ��������
	   * 
	   *  DELETE FROM ELECTRONICS WHERE MODEL_NUM=? AND PASSWOARD=?
	   * */
	  int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����(���̸�, ����, ����)
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(Electronics electronics) throws SQLException;
}




