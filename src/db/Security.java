package db;

public class Security {
	private String staffNo;
	private Integer fingprintNo;
	private Integer irisNo;
	private Integer accountNum;
	private Boolean isHome;
	private Integer inOutNumInteger;
	
	


	public Security(String staffNo, Integer fingprintNo, Integer irisNo, Integer accountNum, Boolean isHome,
			Integer inOutNumInteger) {
		super();
		this.staffNo = staffNo;
		this.fingprintNo = fingprintNo;
		this.irisNo = irisNo;
		this.accountNum = accountNum;
		this.isHome = isHome;
		this.inOutNumInteger = inOutNumInteger;
	}




	public Security(String staffNo, Integer accountNum, Boolean isHome, Integer inOutNumInteger) {
		super();
		this.staffNo = staffNo;
		this.accountNum = accountNum;
		this.isHome = isHome;
		this.inOutNumInteger = inOutNumInteger;
	}




	public Security() {
		super();
	}




	public String getStaffNo() {
		return staffNo;
	}




	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}




	public Integer getFingprintNo() {
		return fingprintNo;
	}




	public void setFingprintNo(Integer fingprintNo) {
		this.fingprintNo = fingprintNo;
	}




	public Integer getIrisNo() {
		return irisNo;
	}




	public void setIrisNo(Integer irisNo) {
		this.irisNo = irisNo;
	}




	public Integer getAccountNum() {
		return accountNum;
	}




	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}




	public Boolean getIsHome() {
		return isHome;
	}




	public void setIsHome(Boolean isHome) {
		this.isHome = isHome;
	}




	public Integer getInOutNumInteger() {
		return inOutNumInteger;
	}




	public void setInOutNumInteger(Integer inOutNumInteger) {
		this.inOutNumInteger = inOutNumInteger;
	}




	@Override
	public String toString() {
		return "Security [staffNo=" + staffNo + ", fingprintNo=" + fingprintNo + ", irisNo=" + irisNo + ", accountNum="
				+ accountNum + ", isHome=" + isHome + ", inOutNumInteger=" + inOutNumInteger + "]";
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
