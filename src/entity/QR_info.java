package entity;

public class QR_info {

	private  String card_id;
	private  boolean is_unique_code=false;
	private  String outter_str;//邀请码
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public boolean getIs_unique_code() {
		return is_unique_code;
	}
	public void setIs_unique_code(Boolean is_unique_code) {
		this.is_unique_code = is_unique_code;
	}
	public String getOuter_str() {
		return outter_str;
	}
	public void setOuter_str(String outter_str) {
		this.outter_str = outter_str;
	}
	public QR_info(String card_id,String outter_str) {
		this.card_id=card_id;
		this.outter_str=outter_str;
	}
	
			
}
