package entity;

import com.thoughtworks.xstream.XStream;

public class totextxml {
	static XStream xStream = new XStream();
    //调用toXML 将对象转成字符串
	//zidonghuifuxml zidongxml=new zidonghuifuxml(ToUserName, FromUserName, CreateTime, MsgType, Content)
    //String s = xStream.toXML(user);
	public static String text(String key,String ToUserName,String FromUserName) {
		String CreateTime=String.valueOf(System.currentTimeMillis()/1000);
		String to="![CDATA["+ToUserName+"]";
		String from="![CDATA["+FromUserName+"]";
		String MsgType="![CDATA[text]]";
		String s="";
		if(key.equals("落牌"))
		{
			String Content="![CDATA[新车落牌所需证件 :交强险 、车辆购置税、合格证、车辆45度角照片、车主身份证、指标]]";
			textxml text=new textxml(from, to, CreateTime, MsgType, Content);
			xStream.alias("xml", text.getClass());
			s = xStream.toXML(text);
		}
		if(key.equals("过户"))
		{
			String Content="![CDATA[车辆过户所需证件：行驶证、交强险、身份证(原车主，新车住)]]";
			textxml text=new textxml(from, to, CreateTime, MsgType, Content);
			xStream.alias("xml", text.getClass());
			s = xStream.toXML(text);
		}
		if(key.equals("年检"))
		{
			String Content="![CDATA[年检所需证件：办理人身份证、交强险、行驶证、(六年以内两年一检 免上线)]]";
			textxml text=new textxml(from, to, CreateTime, MsgType, Content);
			xStream.alias("xml", text.getClass());
			s = xStream.toXML(text);
		}
		return s;
	}
}
