package Tuil;

import entity.Button;
import entity.ClickButton;
import entity.MiniProgram;
import entity.PhotoOrAlbumButton;
import entity.SubButton;
import entity.ViewButton;
import entity.View_Vimited;
import net.sf.json.JSONObject;
import service.wxservice;
import service.wxservice;

public class CreateMenu {

	public static void main(String[] args) {
		//菜单对象
		//System.out.println(wxservice.getAccessToken());
		Button btn = new Button();
		//第一个一级菜单
		//btn.getButton().add(new ClickButton("一级点击", "1"));
		//第二个一级菜单
		//btn.getButton().add(new ViewButton("一级跳转", "http://www.baidu.com"));
		//创建第三个一级菜单
		
		SubButton sb = new SubButton("加盟&合作");
		sb.getSub_button().add(new ViewButton("我要加盟", "http://www.hnjtbf.com/join/form/home/100168.html"));
		sb.getSub_button().add(new MiniProgram("一停有位","wx2f36b10b00353569","/pages/index/index?utm_source=wxsn_23&utm_media=traffic_swap","/pages/index/index?utm_source=wxsn_23&utm_media=traffic_swap"));
		btn.getButton().add(sb);
		
		//Button btn = new Button();
		//第一个一级菜单
		btn.getButton().add(new ViewButton("会员福利", "http://www.hnjtbf.com"));
		//SubButton sc = new SubButton("会员福利");
		//sc.getSub_button().add(new ViewButton("网易新闻", "http://www.hnjtbf.com"))
		//btn.getButton().add(sc);
		
		SubButton sd = new SubButton("会员菜单");
		sd.getSub_button().add(new ViewButton("会员登录", "http://www.youxinuk.com/carFamilywx.php?mod=login"));
		sd.getSub_button().add(new ViewButton("平台信息", "http://cloud.hnjtbf.com/managerLogin/userLogin"));
		sd.getSub_button().add(new ViewButton("商户端", "http://cloud.hnjtbf.com/Sellers/loginservlet"));
		sd.getSub_button().add(new View_Vimited("如何充值加油卡", "4g6UpGBq_8sWlDXZ7fC2C03_N7rXBqwnEoHd5QVTXzo"));
		sd.getSub_button().add(new ViewButton("白条办理流程", "http://www.youxinuk.com/ques/index2_item1.html"));
		btn.getButton().add(sd);
		
		//转为json
		JSONObject jsonObject = JSONObject.fromObject(btn);
		System.out.println(jsonObject.toString());
		//准备url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", wxservice.getAccessToken());
		//发送请求
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);
		
	}
	
}
