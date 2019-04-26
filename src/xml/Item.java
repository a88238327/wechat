package xml;

public class Item {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	public Item(String Title,String Description,String PicUrl,String Url) {
		this.Title="![CDATA["+Title+"]]";
		this.Description="![CDATA["+Description+"]]";
		this.PicUrl="![CDATA["+PicUrl+"]]";
		this.Url="![CDATA["+Url+"]]";
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
