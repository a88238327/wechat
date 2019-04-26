package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONObject;

public class updateCustomer_info {

	public static boolean updateinfo(String customerinfo) {
		//遍历并存储info
        //User user = (User) JSON.parse(str);
    	String getname;
    	String setname;
    	getname="openid,nickname,menbership_number,bonus,sex";
        JSONObject jsnj=JSONObject.fromObject(customerinfo);
    	setname="nickname=\'"+jsnj.getString("nickname")+"\',menbership_number=\'"+jsnj.getString("membership_number")+"\',bonus=\'"+jsnj.getString("bonus")+"\',sex=\'"+jsnj.getString("sex")+"\'";
        User user1 = JSON.parseObject(customerinfo,User.class);
        System.out.println(user1.getUser_info());
        Field field  = JSON.parseObject(user1.getUser_info(),Field.class);
        System.out.println(field.getCommon_field_list().toString());
        List<Info> list =new ArrayList<Info>();
        List<Info> list2=new ArrayList<Info>();
        list = JSON.parseArray(field.getCommon_field_list(),Info.class);
        list2 = JSON.parseArray(field.getCustom_field_list(),Info.class);
        if(updateinfo(jsnj.getString("openid"),list,list2,setname))
        {
        	System.out.println("更新用户成功");
        	return true;
        }
        else {
        	System.out.println("更新用户失败");
			return false;
		}
        /**List<Info> list2=new ArrayList<Info>();
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
        }**/

        /**if(updateinfo(getname, getvalue))
        {
        	System.out.println("用户更新成功");
        	return true;
        }
        else {
			System.out.println("用户更新成功失败");
			return false;
		}**/
    }
    private static boolean updateinfo(String openid,List<Info> list,List<Info> list2,String setname) {
    	Connection conn=null;
		Statement stmt=null;
		String name="";
		String key="";
		PreparedStatement pstmt	= null ;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动类
		String username=new DataUser().getUsername();//数据库用户名
		String password=new DataUser().getPassword();//数据库密码
		//String sql="update customer set "+setname+" where openid=\'"+openid+"\'" ;//查询语句
		for(int i=0;i<list.size();i++){
        	if(!setname.equals(""))
        	{
        		setname+=",";
        	}
            Info info=list.get(i);
            name+=info.getName();
            key+="=\'"+info.getValue()+"\'";
            setname=setname+name+key;
            System.out.println(setname);
        }
		for(int i=0;i<list2.size();i++){
        	if(!setname.equals(""))
        	{
        		setname+=",";
        	}
        	name="";
        	key="";
            Info info=list2.get(i);
            name+=info.getName();
            key+="=\'"+info.getValue()+"\'";
            setname=setname+name+key;
            System.out.println(setname);
        }
		String sql="update customer set "+setname+" where openid=\'"+openid+"\'" ;//查询语句
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
			System.out.println("更新成功");
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
