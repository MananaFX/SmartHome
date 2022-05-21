package db;

public class Control {

	private String userAccountString;
	private String facilityNo;
	
	public Control(String userAccountString, String facilityNo) {
		super();
		this.userAccountString = userAccountString;
		this.facilityNo = facilityNo;
	}

	public Control() {
		super();
	}

	public String getUserAccountString() {
		return userAccountString;
	}

	public void setUserAccountString(String userAccountString) {
		this.userAccountString = userAccountString;
	}

	public String getFacilityNo() {
		return facilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}

	@Override
	public String toString() {
		return "Control [userAccountString=" + userAccountString + ", facilityNo=" + facilityNo + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
