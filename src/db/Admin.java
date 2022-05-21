package db;

import java.lang.invoke.StringConcatFactory;

public class Admin {

	private String account;
	private String password;
	private String staffNo;
	
	public Admin(String account, String password, String staffNo) {
		super();
		this.account = account;
		this.password = password;
		this.staffNo = staffNo;
	}

	public Admin() {
		super();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	@Override
	public String toString() {
		return "Admin [account=" + account + ", password=" + password + ", staffNo=" + staffNo + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
