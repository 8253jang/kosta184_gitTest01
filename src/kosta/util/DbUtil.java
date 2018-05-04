package kosta.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DB관련 로드, 연결, 닫기를 위한 클래스
 * */
public class DbUtil {
	static DataSource ds;
  /**
   * 로드
   * */
	static {
		try {
		  Context  context = new InitialContext();
		  ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
		 
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
  /**
   * 연결
   * */
	public static Connection getConnection()throws SQLException{
		return  ds.getConnection();
		 
	}
	
  /**
   * 닫기
   * insert, update, delete인경우
   * */
	public static void dbClose(Connection con , Statement st){
		try {
		 if(st!=null) st.close();
		 if(con!=null)con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * select인경우 닫기
	 * */
	public static void dbClose(Connection con , Statement st , ResultSet rs) {
		try {
		 if(rs!=null)rs.close();
		 dbClose(con, st);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}











