package test;

import java.util.Map;

import com.thoughtworks.xstream.XStream;

import Tuil.SelectUsermaData;
import entity.Create_QR_Card;
import entity.UpdateUserQrUrl;
import entity.createEvent;
import entity.createopenidouterstr;
import entity.selectOpenid;
import entity.sysDate;
import entity.totextxml;
import entity.updateCustomer_info;
import service.wxservice;
import xml.articles;
import xml.Item;
import xml.news;

public class test {
	public static void main(String[] args) {
		news n=new news("ToUserName", "FromUserName", "CreateTime", "MsgType", "ArticleCount", new articles(new Item("Title", "Description", "PicUrl", "Url")));
		XStream xstream=new XStream();
		xstream.alias("xml", n.getClass());
		
		System.out.println(xstream.toXML(n));
	}
	
}
