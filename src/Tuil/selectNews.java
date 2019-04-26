package Tuil;

import entity.News;
import entity.PostHttp;
import net.sf.json.JSONObject;
import service.wxservice;

public class selectNews {

	public static void main(String[] args) {

		News news=new News("0","20");
		JSONObject jsonObject=JSONObject.fromObject(news);
		String url="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN",wxservice.getAccessToken());
		String result = Util.post(url, jsonObject.toString());
		System.out.println(result);
		

	}
}
