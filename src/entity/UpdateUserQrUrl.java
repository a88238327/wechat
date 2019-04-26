package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateUserQrUrl {

	public static boolean updateuser(String phonenumber,String url) {
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt	= null ;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动类
		String username=new DataUser().getUsername();//数据库用户名
		String password=new DataUser().getPassword();//数据库密码
		String sql="update manager set qr_url="+"\'"+url+"\' where phone_number="+"\'"+phonenumber+"\'";//查询语句
		System.out.println(sql);
		String DBurl=new DataUrl().getUrl();//连接数据库的地址
		try{
			Class.forName(driver);//加载驱动器类
			conn=DriverManager.getConnection(DBurl,username,password);//建立连接
			//建立处理的SQL语句
			pstmt = conn.prepareStatement(sql) ;
			System.out.println(pstmt.toString());
			if(pstmt.executeUpdate()>0)
				{
				System.out.println("插入用户二维码成功");
				pstmt.close();//关闭SQL语句集
				conn.close();//关闭连接
				return true;
				}
			else {
				pstmt.close();//关闭SQL语句集
				conn.close();//关闭连接
				return false;
			}

			
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
