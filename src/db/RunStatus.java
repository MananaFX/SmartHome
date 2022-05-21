package db;

public class RunStatus {
	
	private String facilityNo;
	private Integer runNo;
	private Integer openHour;
	private Integer openMin;
	private Integer closeHour;
	private Integer closeMin;
	private String faultType;
	
	
	public RunStatus(String facilityNo, Integer runNo, Integer openHour, Integer openMin, Integer closeHour,
			Integer closeMin, String faultType) {
		super();
		this.facilityNo = facilityNo;
		this.runNo = runNo;
		this.openHour = openHour;
		this.openMin = openMin;
		this.closeHour = closeHour;
		this.closeMin = closeMin;
		this.faultType = faultType;
	}


	public RunStatus() {
		super();
	}


	public String getFacilityNo() {
		return facilityNo;
	}


	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}


	public Integer getRunNo() {
		return runNo;
	}


	public void setRunNo(Integer runNo) {
		this.runNo = runNo;
	}


	public Integer getOpenHour() {
		return openHour;
	}


	public void setOpenHour(Integer openHour) {
		this.openHour = openHour;
	}


	public Integer getOpenMin() {
		return openMin;
	}


	public void setOpenMin(Integer openMin) {
		this.openMin = openMin;
	}


	public Integer getCloseHour() {
		return closeHour;
	}


	public void setCloseHour(Integer closeHour) {
		this.closeHour = closeHour;
	}


	public Integer getCloseMin() {
		return closeMin;
	}


	public void setCloseMin(Integer closeMin) {
		this.closeMin = closeMin;
	}


	public String getFaultType() {
		return faultType;
	}


	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}


	@Override
	public String toString() {
		return "RunStatus [facilityNo=" + facilityNo + ", runNo=" + runNo + ", openHour=" + openHour + ", openMin="
				+ openMin + ", closeHour=" + closeHour + ", closeMin=" + closeMin + ", faultType=" + faultType + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
