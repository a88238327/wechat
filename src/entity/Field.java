package entity;

public class Field {
    public String getCustom_field() {
        return custom_field;
    }

    public void setCustom_field(String custom_field) {
        this.custom_field = custom_field;
    }

    public String getCommon_field_list() {
        return common_field_list;
    }

    public void setCommon_field_list(String common_field_list) {
        this.common_field_list = common_field_list;
    }

    private String custom_field;
    private String common_field_list;
    public String getCustom_field_list() {
		return custom_field_list;
	}

	public void setCustom_field_list(String custom_field_list) {
		this.custom_field_list = custom_field_list;
	}

	private String custom_field_list; 
		
	
}
