package jdbc_App1;


import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String email;
	private String mobile;
	private String address;
	private Date birth;
	
	public Customer() {
	}

	public Customer(int id, String name, String password, String email, String mobile, String address, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.birth = birth;
	}

	public Customer(int id, String name, String email, String mobile, String address, Date birth) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", birth=" + birth + "]";
	}
}

