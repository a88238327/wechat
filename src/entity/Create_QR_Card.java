package entity;

import Tuil.Util;
import net.sf.json.JSONObject;
import service.wxservice;

public class Create_QR_Card {

	
	public static String create_qr_card(String card_id,String outter_str) {
		QR_info qr_info=new QR_info(card_id, outter_str);
		JSONObject jsonObject = JSONObject.fromObject(qr_info);
		System.out.println(jsonObject);
		String jsonStr="{\"action_name\": \"QR_CARD\",\"action_info\": {\"card\": "+jsonObject.toString()+"}}";
		System.out.println(jsonStr);
		String url = "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN";
		url = url.replace("TOKEN", wxservice.getAccessToken());
		//发送请求
		String result = Util.post(url, jsonStr);
		JSONObject json=JSONObject.fromObject(result);
		result=json.getString("show_qrcode_url");
		result=result.replace("\\", "");
		System.out.println(result);
		return result;
		
		
	}
}
