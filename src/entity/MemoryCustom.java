package entity;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import net.sf.json.JSONObject;
import com.alibaba.fastjson.JSON;





public class MemoryCustom {

    public static boolean LookingandRecord(String str) {
    	//遍历并存储info
        //User user = (User) JSON.parse(str);
    	String getname;
    	String getvalue;
    	getname="createtime,openid,nickname,menbership_number,bonus,sex";
        JSONObject jsnj=JSONObject.fromObject(str);
    	getvalue="\'"+sysDate.getsysDate()+"\'"+','+"\'"+jsnj.getString("openid")+"\'"+","+"\'"+jsnj.getString("nickname")+"\'"+","+"\'"+jsnj.getString("membership_number")+"\'"+","+"\'"+jsnj.getString("bonus")+"\'"+","+"\'"+jsnj.getString("sex")+"\'";
        User user1 = JSON.parseObject(str,User.class);
        System.out.println(user1.getUser_info());
        Field field  = JSON.parseObject(user1.getUser_info(),Field.class);
        System.out.println(field.getCommon_field_list().toString());
        List<Info> list =new ArrayList<Info>();
        list = JSON.parseArray(field.getCommon_field_list(),Info.class);
        for(int i=0;i<list.size();i++){
        	if(!getname.equals(""))
        	{
        		getname+=",";
        		getvalue+=",";
        	}
            Info info=list.get(i);
            getname+=info.getName();
            getvalue+="\'"+info.getValue()+"\'";
            System.out.println(info.getName());
            System.out.println(info.getValue());
        }
        List<Info> list2=new ArrayList<Info>();
        list2 = JSON.parseArray(field.getCustom_field_list(),Info.class);
        for(int i=0;i<list.size();i++){
        	if(!getname.equals(""))
        	{
        		getname+=",";
        		getvalue+=",";
        	}
            Info info=list2.get(i);
            getname+=info.getName();
            getvalue+="\'"+info.getValue()+"\'";
            System.out.println(info.getName());
            System.out.println(info.getValue());
        }
        System.out.println(getname);
        System.out.println(getvalue);
        if(memoryinfo(getname, getvalue))
        {
        	System.out.println("新用户存储成功");
        }
        else {
			System.out.println("新用户存储失败");
			return false;
		}
        return true;
    }
    private static boolean memoryinfo(String name,String value) {
    	Connection conn=null;
		Statement stmt=null;
		ResultSet rs= null ;
		boolean flag;
	
		PreparedStatement pstmt	= null ;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动类
		String username=new DataUser().getUsername();//数据库用户名
		String password=new DataUser().getPassword();//数据库密码
		String sql="insert into  customer ("+name+") values("+value+")" ;//查询语句
		System.out.println(sql);
		String url=new DataUrl().getUrl();//连接数据库的地址
		try{
			Class.forName(driver);//加载驱动器类
			conn=DriverManager.getConnection(url,username,password);//建立连接
			//建立处理的SQL语句
			pstmt = conn.prepareStatement(sql) ;
			//pstmt.setString(1,name) ;
			//pstmt.setString(2,value) ;
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();//插入数据库
			System.out.println("插入成功");
			pstmt.close();//关闭SQL语句集
			conn.close();//关闭连接
		}
		//捕获异常
			catch(ClassNotFoundException e){
				System.out.print(e);
				return false;
		}
		//捕获异常
			catch(SQLException ee){
				System.out.print(ee);
				return false;
		} 
		return true;
    }
}
