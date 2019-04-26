package entity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

public class User_Info {

	private String phone_number;//用户手机号（识别码，邀请码）
	private String lv;//用户等级数字越大权限越小
	private String qr_url;//会员卡二维码地址
	private String leader;//用户上级
	private String Enable;//用户账号状态：1表示启用，0表示禁用
	public User_Info(String phone_number) {
		this.phone_number=phone_number;
		
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	public String getQr_url() {
		return qr_url;
	}
	public void setQr_url(String qr_url) {
		this.qr_url = qr_url;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getEnable() {
		return Enable;
	}
	public void setEnable(String enable) {
		Enable = enable;
	}
}
