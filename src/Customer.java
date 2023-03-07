package src;

public class Customer {
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private String mobileNumber;
    private String phoneNumber;
    private String email;
    private String driversLicenseNumber;
    private String driverSinceDate;

    // Constructor
    public Customer(String name, String address, String zipCode, String city, String mobileNumber, String phoneNumber,
                    String email, String driversLicenseNumber, String driverSinceDate) {
        setName(name);
        setAddress(address);
        setZipCode(zipCode);
        setCity(city);
        setMobileNumber(mobileNumber);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setDriversLicenseNumber(driversLicenseNumber);
        setDriverSinceDate(driverSinceDate);
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDriverSinceDate(String driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //Getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDriverSinceDate() {
        return driverSinceDate;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", zipCode='" + getZipCode() + '\'' +
                ", city='" + getCity() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", driversLicenseNumber='" + getDriversLicenseNumber() + '\'' +
                ", driverSinceDate='" + getDriverSinceDate() + '\'' +
                '}';
    }
}
