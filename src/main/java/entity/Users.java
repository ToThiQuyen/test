package entity;

public class Users {
	private String username; 
	private String password;
	private String isAd;
	private String fullname;
	private String phone;
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", isAd=" + isAd + ", fullname=" + fullname
				+ ", phone=" + phone + "]";
	}
	public Users() {
		
	}
	public Users(String username, String password, String isAd, String fullname, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.isAd = isAd;
		this.fullname = fullname;
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsAd() {
		return isAd;
	}
	public void setIsAd(String isAd) {
		this.isAd = isAd;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
