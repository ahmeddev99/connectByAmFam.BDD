package dataProvider;

public class AutoData {
	
	private String zipCode1;
	private String zipCode2;
	private String typeInsurance;
	private String firstName;
	private char middleName;
	private String lastName;
	private String dob;
	private String email;
	private String city;
	private String streetAddress;
	private String state;
	private String zipCode;
	private String atTheAddress;
	private String vYear;
	private String vMake;
	private String vModel;
	private String vTrim;
	private String vCoverage;
	private String titleHolder;
	private String airBag;
	private String antiTheft;
	private String parked;
	private String primarilyUsed;
	
	
	public AutoData(String zipCode1, String zipCode2, String typeInsurance, String firstName, char middleName,
			String lastName, String dob, String email, String city, String streetAddress, String state, String zipCode,
			String atTheAddress, String vYear, String vMake, String vModel, String vTrim, String vCoverage,
			String titleHolder, String airBag, String antiTheft, String parked, String primarilyUsed) {
		this.zipCode1 = zipCode1;
		this.zipCode2 = zipCode2;
		this.typeInsurance = typeInsurance;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.city = city;
		this.streetAddress = streetAddress;
		this.state = state;
		this.zipCode = zipCode;
		this.atTheAddress = atTheAddress;
		this.vYear = vYear;
		this.vMake = vMake;
		this.vModel = vModel;
		this.vTrim = vTrim;
		this.vCoverage = vCoverage;
		this.titleHolder = titleHolder;
		this.airBag = airBag;
		this.antiTheft = antiTheft;
		this.parked = parked;
		this.primarilyUsed = primarilyUsed;
	}

	
	public String getZipCode1() {
		return zipCode1;
	}
	public String getZipCode2() {
		return zipCode2;
	}
	public String getTypeInsurance() {
		return typeInsurance;
	}
	public String getFirstName() {
		return firstName;
	}
	public char getMiddleName() {
		return middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDob() {
		return dob;
	}
	public String getEmail() {
		return email;
	}
	public String getCity() {
		return city;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getAtTheAddress() {
		return atTheAddress;
	}
	public String getvYear() {
		return vYear;
	}
	public String getvMake() {
		return vMake;
	}
	public String getvModel() {
		return vModel;
	}
	public String getvTrim() {
		return vTrim;
	}
	public String getvCoverage() {
		return vCoverage;
	}
	public String getTitleHolder() {
		return titleHolder;
	}
	public String getAirBag() {
		return airBag;
	}
	public String getAntiTheft() {
		return antiTheft;
	}
	public String getParked() {
		return parked;
	}
	public String getPrimarilyUsed() {
		return primarilyUsed;
	}
	
}
