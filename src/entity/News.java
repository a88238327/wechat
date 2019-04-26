package entity;

public class News {
	private String type="news";
	private String offset;
	private String count;
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}
	public String getCount() {
		return count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public News(String offset,String count)
	{
		this.offset=offset;
		this.count=count;
	}
	
		
	

}
