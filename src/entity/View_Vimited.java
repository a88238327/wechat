package entity;

import java.security.Principal;

public class View_Vimited extends AbstractButon{
	private String  type="view_limited";
	private String  media_id;
		
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getMedia_id() {
		return media_id;
	}



	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}



	public View_Vimited(String name,String media_id) {
		super(name);
		this.media_id=media_id;
		// TODO Auto-generated constructor stub
	}
	

}
