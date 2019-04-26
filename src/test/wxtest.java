package test;

import Tuil.SelectUsermaData;
import Tuil.Util;
import entity.Info;
import entity.MemoryCustom;
import entity.News;
import entity.PostHttp;
import entity.cardidcode;
import entity.sysDate;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.wxservice;

public class wxtest {

	public static void main(String[] args) {
		

			News news=new News("0","20");
			JSONObject jsonObject=JSONObject.fromObject(news);
			String url="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
			url = url.replace("ACCESS_TOKEN", "17__KPcYabo3-WWpGImS8My-Z-l9OdnvezGeZkGW7jPbN8rlDP2HZ35zxXwMpYMO9cpFbkCc9rJMJwNr5Xyze2WlD1ziE_L_OOy0CjXWLIJQHNCzIveaTDuiyEDEl90MTQ9s0ozdBXPuLWGqLyRQXKiAAAMTG");
			PostHttp.PostHttpUrl(url, jsonObject);
			String result = Util.post(url, jsonObject.toString());
			System.out.println(result);
	}
	
}
