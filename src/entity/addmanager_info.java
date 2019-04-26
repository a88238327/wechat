package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class addmanager_info {

	public static boolean addmanager(String managerphone,String managername,String leader,String lv) {
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt	= null ;
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
		String createtime="\'"+df.format(new Date())+"\'";
		String outter_str=managerphone;
		String password=",\'"+managerphone+"\'";
		managerphone=",\'"+managerphone+"\'";
		managername=",\'"+managername+"\'";
		leader=",\'"+leader+"\'";
		lv=",\'"+lv+"\'";
		
		String Enable=",\'1\'";
		String cardid=card_id.getCard_id();
		System.out.println(password);
		String qr_url=",\'"+Create_QR_Card.create_qr_card(cardid,outter_str)+"\'";
		String str=createtime+managername+managerphone+password+lv+qr_url+leader+Enable;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动类
		String username=new DataUser().getUsername();//数据库用户名
		String DBpassword=new DataUser().getPassword();//数据库密码
		String sql="insert into manager (createtime,username,phone_number,password,lv,qr_url,leader,Enable) values ("+str+")";//查询语句
		System.out.println(sql);
		String DBurl=new DataUrl().getUrl();//连接数据库的地址
		try{
			Class.forName(driver);//加载驱动器类
			conn=DriverManager.getConnection(DBurl,username,DBpassword);//建立连接
			//建立处理的SQL语句
			pstmt = conn.prepareStatement(sql) ;
			System.out.println(pstmt.toString());
			int resultString=pstmt.executeUpdate();
			pstmt.close();//关闭SQL语句集
			conn.close();//关闭连接
			return true;
	
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	
	}
}
