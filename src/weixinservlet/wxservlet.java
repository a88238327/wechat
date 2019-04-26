package weixinservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import Tuil.SelectUsermaData;
import entity.MemoryCustom;
import entity.createEvent;
import entity.createopenidouterstr;
import entity.selectOpenid;
import entity.totextxml;
import entity.updateCustomer_info;
import service.wxservice;
import test.createcustomerservlet;
import xml.Item;
import xml.articles;
import xml.news;

/**
 * Servlet implementation class wxservlet
 */
@WebServlet("/wxservlet")
public class wxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public String CardId;
     public String UserCardCode;
		
	
    /**验证签名
     * @see HttpServlet#HttpServlet()
     */
    public wxservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		//timestamp	时间戳
		//nonce	随机数
		//echostr	随机字符串
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		//校验
		if(wxservice.check(signature,timestamp,nonce)) {
			System.out.println("接入成功");
			PrintWriter out=response.getWriter();
			//返回echostr
			out.print(echostr);
			out.flush();
			out.close();
		}
		else {
			System.out.println("接入失败");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//接收消息和事件推送
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		//System.out.println(wxservice.getAccessToken());
		//处理消息和事件推送
		Map<String, String> requestMap = wxservice.parseRequest(request.getInputStream());
		//System.out.println(requestMap);
		String msgType = requestMap.get("MsgType");
		System.out.println(wxservice.getAccessToken());
		System.out.println(requestMap);
		String str="";
		
		//如果是event执行下列
//		if(msgType.equals("event"))
//		{
//			//Event=user_get_card事件处理
//			if(requestMap.get("Event").equals("user_get_card"))
//			{
//				//查询数据库是否存在该openid
//				if(!selectOpenid.selectopenid(requestMap.get("FromUserName")))
//				{
//					if(createopenidouterstr.createopenidouterstr(requestMap.get("FromUserName"), requestMap.get("OuterStr")))
//					{
//						System.out.println("创建会员成功");
//					}
//				}
//			}
//			
//			//Event=submit_membercard_user_info事件处理
//			if(requestMap.get("Event").equals("submit_membercard_user_info"))
//			{
//				//获取客户信息
//				String customerinfo=SelectUsermaData.getUserInfo(requestMap.get("CardId"), requestMap.get("UserCardCode"));
//				if(updateCustomer_info.updateinfo(customerinfo))
//				{
//					System.out.println("用户资料更新成功");
//				}
//				
//				
//			}
			//关注自动回复
//			if(requestMap.get("Event").equals("subscribe"))
//			{
//				String CreateTime=String.valueOf(System.currentTimeMillis()/1000);
//				Item a=new Item("欢迎关注車家网", "详细了解車家网点击下方菜单\n1.发送落牌了解落牌所需手续\n2.发送过户了解落牌所需手续\n2.发送年检了解落牌所需手续\n", "http://cloud.hnjtbf.com/img/chejiawang1.png", "");
//				articles b=new articles(a);
//				news n=new news(requestMap.get("FromUserName"), requestMap.get("ToUserName"), CreateTime, "news", "1", b);
//				XStream xstream=new XStream();
//				xstream.alias("xml", n.getClass());			
//				System.out.println(xstream.toXML(n));
//				str=xstream.toXML(n);
//			}
			
			//记录用户事件
			if(createEvent.createEvent(requestMap.get("FromUserName"), requestMap.get("Event")))
			{
				System.out.println("创建事件成功");
			}
			
			
		}
		//自动回复
//		if(msgType.equals("text"))
//		{
//			str=totextxml.text(requestMap.get("Content"), requestMap.get("ToUserName"), requestMap.get("FromUserName"));
//			System.out.println(str);
//			
//		}
//		if(str==null)
//		{
//			PrintWriter out = response.getWriter();
//			System.out.println("返回数据");
//			System.out.println(str);
//			out.print(str);
//			out.flush();
//			out.close();
//		}
		
		
//	}

}
