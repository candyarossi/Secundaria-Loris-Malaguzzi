public class User {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	
	
	public User() {
		super();
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password = "";
	}

	
	public User(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "Usuario -> { Nombre: " + name + ", Apellido: " + surname + ", Email: " + email + ", Password: " + password + " }";
	}

}
