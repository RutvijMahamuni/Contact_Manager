package entities;

public class Contacts {
	
	//Mapping the columns from the table 
	int id;
	String name;
	String phone;
	String email;
	
	public Contacts() {
		super();
	}
	
	public Contacts(int id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	

}
