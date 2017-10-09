package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class PreparedDemo {
	/**
	 * ������һ�����ʣ���select�������ֶ�ʹ��set��ֵʱ��rs.get��������ʾ������Ч��
	 * @throws Exception
	 */
	@Test 
	public void test1() throws Exception{
		String sql = "select   ?,?  belongorg from user_info where userid=? ";
		Connection conn = GConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "username");
		pstmt.setString(2,"belongorg");
		pstmt.setString(3, "903001");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			String username = rs.getString("username");
			String belongorg = rs.getString("belongorg");
			if(username==null|username=="")username="";
			if(belongorg==null|belongorg=="")belongorg="";
			System.out.println("�û�����"+username+"��+����������"+belongorg);
		}
	rs.close();
	pstmt.close();
	conn.close();
	}

}
