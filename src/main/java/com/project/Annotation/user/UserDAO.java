package com.project.Annotation.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.Annotation.common.EncryptUtil;
import com.project.Annotation.common.JDBCUtil;

public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String pwEncrypt;
	
	private final String USER_GET = 
			"select id, password, name from users where id=? and password=?";
	private final String USER_INSERT = 
			"insert into users values(?,?,?,?,?)";
	
	public UserDO getUser(UserDO userObj) {
		UserDO user = null;
	
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리");
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
	
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserDO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
	
	public void insertUser(UserDO userDO) {
		System.out.println("===> insertUser() 기능 처리");
		try {	
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, userDO.getId());
			pstmt.setString(2, userDO.getPassword());
			
			String plainText = userDO.getPassword();
			pwEncrypt = EncryptUtil.encryptSHA265(plainText);
			
			pstmt.setString(3, pwEncrypt);
			pstmt.setString(4, userDO.getName());
			pstmt.setString(5, userDO.getRole());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
}
