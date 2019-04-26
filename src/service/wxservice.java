package service;
import entity.cardidcode;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.thoughtworks.xstream.XStream;
import Tuil.Util;
import entity.Article;
import entity.cardidcode;
import entity.postUserInfo;
import net.sf.json.JSONObject;
import entity.AccessToken;


public class wxservice {
	//验证签名
	private static final String TOKEN="Hola";
	private static final String GET_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//微信公众号
	private static final String APPID="wxafe6999b4d77754a";
	private static final String APPSECRET="85642ddb58fc2fc7b1c52720e298485e";	
	private static AccessToken at;
	//获取token
	private static void getToken() {
		String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		String tokenStr = Util.get(url);
		System.out.println(tokenStr);
		JSONObject jsonObject = JSONObject.fromObject(tokenStr);
		System.out.println(jsonObject.getString("access_token"));
		String token = jsonObject.getString("access_token");
		String expireIn = jsonObject.getString("expires_in");
		//创建token对象,并存起来。
		System.out.println(jsonObject.getString("access_token"));
		at = new AccessToken(token, "3600");
	}
	public static boolean check(String signature,String timestamp,String nonce)
	{
		//1）将token、timestamp、nonce三个参数进行字典序排序
		String[] strs=new String[] {TOKEN,timestamp,nonce};
		Arrays.sort(strs);
		//2）将三个参数字符串拼接成一个字符串进行sha1加密 
		String str=strs[0]+strs[1]+strs[2];
		String mysig=sha1(str);
		//System.out.println(mysig);
		//System.out.println(signature);
		//3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return mysig.equalsIgnoreCase(signature);
	}
	public static String sha1(String src) {
		try {
			//获取一个加密对象
			MessageDigest md=MessageDigest.getInstance("sha1");
			//加密
			byte[] digest=md.digest(src.getBytes());
			char[] chars= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			StringBuilder sb=new StringBuilder();
			//处理加密结果
			for(byte b:digest) {
				sb.append(chars[(b>>4)&15]);
				sb.append(chars[b&15]);
			}
			return sb.toString();
		}catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public static Map<String, String> parseRequest(InputStream is) {
		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		try {
			//读取输入流，获取文档对象
			Document document = reader.read(is);
			//根据文档对象获取根节点
			Element root = document.getRootElement();
			//获取根节点的所有的子节点
			List<Element> elements = root.elements();
			for(Element e:elements) {
				map.put(e.getName(), e.getStringValue());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	public static String getAccessToken() {
		if(at==null||at.isExpired()) {
			getToken();
		}
		return at.getAccessToken();
	}
	//获取用户的信息
	public void getUserInfo(cardidcode cc) {
		
		//转为json
		cardidcode ao=new cardidcode(cc.getcard_id(),cc.getcode());
		JSONObject jsonObject = JSONObject.fromObject(ao);
		//准备url
		String url = "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=TOKEN";
		url = url.replace("TOKEN", wxservice.getAccessToken());
		//System.out.println(wxservice.getAccessToken());
		//发送请求
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);
		//return result;
		
		
	}
	

}
