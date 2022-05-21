package db;

public class facility {
		private Integer no;
		private String category;
		private Integer accumuRunTime;
		private Integer remainWarPer;
		private String roomName;
		private Boolean isFault;
		
		
	public facility(Integer no, String category, Integer accumuRunTime, Integer remainWarPer, String roomName,
				Boolean isFault) {
			super();
			this.no = no;
			this.category = category;
			this.accumuRunTime = accumuRunTime;
			this.remainWarPer = remainWarPer;
			this.roomName = roomName;
			this.isFault = isFault;
			
		}


	public facility() {
		super();
	}


	public Integer getNo() {
		return no;
	}


	public void setNo(Integer no) {
		this.no = no;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getAccumuRunTime() {
		return accumuRunTime;
	}


	public void setAccumuRunTime(Integer accumuRunTime) {
		this.accumuRunTime = accumuRunTime;
	}


	public Integer getRemainWarPer() {
		return remainWarPer;
	}


	public void setRemainWarPer(Integer remainWarPer) {
		this.remainWarPer = remainWarPer;
	}


	public String getRoomName() {
		return roomName;
	}


	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public Boolean getIsFault() {
		return isFault;
	}


	public void setIsFault(Boolean isFault) {
		this.isFault = isFault;
	}


	@Override
	public String toString() {
		return "facility [no=" + no + ", category=" + category + ", accumuRunTime=" + accumuRunTime + ", remainWarPer="
				+ remainWarPer + ", roomName=" + roomName + ", isFault=" + isFault 
				+ "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
