package entity;

import Tuil.Util;
import net.sf.json.JSONObject;

public class PostHttp {
	public static void PostHttpUrl(String url,JSONObject jsonObject) {
		
		String result = Util.post(url, jsonObject.toString());
		System.out.println(jsonObject.toString());
		System.out.println(result);
	}

}
