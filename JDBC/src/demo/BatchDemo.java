package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Bean.User;

public class BatchDemo {
/**
 * �������userbean��list������ȡ��user����ÿ��user��ȡ����Ϣ���µ���Ӧ��Ϣ�С�
 * ��������ʱ����ʹ�ü�ǿforѭ������Ϊ��Ҫ�õ������������ݱ�������С�ó����������ޡ�
 * @param userList
 * @throws Exception 
 */
	private void save(List <User>userList) throws Exception{
		String userid =null;
		String username = null;
		String belongorg = null;
		String sql = "update student set username=?,belongorg=? where userid=?";
		Connection conn = GConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<userList.size();i++){
			User user = userList.get(i);
			userid = user.getUserid();
			username = user.getUsername();
			belongorg = user.getBelongorg();
			pstmt.setString(1, username);
			pstmt.setString(2,belongorg);
			pstmt.setString(3,userid);
			pstmt.addBatch();
			if(i%10==0){
				pstmt.executeBatch();
				pstmt.clearBatch();
			}
			pstmt.executeBatch();
			pstmt.clearBatch();
		}
		
	}
}
