package models;

public class User {

	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String address;
	private String state;
	private String city;
	private String zipCode;
	private String mobileNumber;

	public User(String username, String firstName, String lastName, String password, String email, String address,
			String state, String city, String zipCode, String mobileNumber) {
		setUsername(username);
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setEmail(email);
		setAddress(address);
		setState(state);
		setCity(city);
		setZipCode(zipCode);
		setMobileNumber(mobileNumber);
	}


	public String getUsername() {
		return username;
	}

	public User setUsername(String userName) {
		this.username = userName;
		return this;
	}


	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}


	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}


	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getAddress1() {
		return password;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getState() {
		return state;
	}

	public User setState(String state) {
		this.state = state;
		return this;
	}

	public String getCity() {
		return city;
	}

	public User setCity(String city) {
		this.city = city;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public User setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public User setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}
	@Override
	public String toString() {

		return "I am a user.";
	}

}
