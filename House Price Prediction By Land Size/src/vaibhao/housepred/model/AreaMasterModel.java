package vaibhao.housepred.model;

public class AreaMasterModel extends CityMasterModel {
	private int Cityid;
	private String areaName;
	private String pincode;


	public int getCityid() {
		return Cityid;
	}

	public void setCityid(int cityid) {
		Cityid = cityid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
