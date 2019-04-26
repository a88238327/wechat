package entity;

public class MiniProgram extends AbstractButon{
	private String type ="miniprogram";
	private String url;
	private String appid;
	private String pagepath;

	
		
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	public MiniProgram(String name,String appid,String pagepath,String url) {
		super(name);
		this.appid=appid;
		this.pagepath=pagepath;
		this.url=url;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
