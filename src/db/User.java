package db;

public class User {
	
	private String userAccount;
	private String userPassword;
	private boolean Can_add;
	private boolean Can_Delete;
	private boolean Can_Control;
	private String staff_No;
	
	public User(String userAccount, String userPassword, boolean can_add, boolean can_Delete, boolean can_Control,
			String staff_No) {
		super();
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		Can_add = can_add;
		Can_Delete = can_Delete;
		Can_Control = can_Control;
		this.staff_No = staff_No;
	}

	
	public User(String userAccount, boolean can_add, boolean can_Delete, boolean can_Control, String staff_No) {
		super();
		this.userAccount = userAccount;
		Can_add = can_add;
		Can_Delete = can_Delete;
		Can_Control = can_Control;
		this.staff_No = staff_No;
	}


	public User() {
		super();
	}

	
	public String getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public boolean isCan_add() {
		return Can_add;
	}


	public void setCan_add(boolean can_add) {
		Can_add = can_add;
	}


	public boolean isCan_Delete() {
		return Can_Delete;
	}


	public void setCan_Delete(boolean can_Delete) {
		Can_Delete = can_Delete;
	}


	public boolean isCan_Control() {
		return Can_Control;
	}


	public void setCan_Control(boolean can_Control) {
		Can_Control = can_Control;
	}


	public String getStaff_No() {
		return staff_No;
	}


	public void setStaff_No(String staff_No) {
		this.staff_No = staff_No;
	}


	@Override
	public String toString() {
		return "User [userAccount=" + userAccount + ", userPassword=" + userPassword + ", Can_add=" + Can_add
				+ ", Can_Delete=" + Can_Delete + ", Can_Control=" + Can_Control + ", staff_No=" + staff_No + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
