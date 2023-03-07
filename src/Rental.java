package src;

public class Rental {
    private String name;
    private String address;
    private int zipCode;
    private String city;
    private String fromDate;
    private String toDate;
    private int driverLicenseNumber;
    private int maxKm;
    private int km;
    private int customerDriverLicenseNumber;
    private int carRegistrationNumber;

    public Rental(String name, String address, int zipCode, String city, String fromDate, String toDate,
                  int driverLicenseNumber, int maxKm, int km, int customerDriverLicenseNumber, int carRegistrationNumber) {

    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public int getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getKm() {
        return km;
    }

    public int getCustomerDriverLicenseNumber() {
        return customerDriverLicenseNumber;
    }


    public int getCarRegistrationNumber() {
        return carRegistrationNumber;
    }


    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setDriverLicenseNumber(int driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setCustomerDriverLicenseNumber(int customerDriverLicenseNumber) {
        this.customerDriverLicenseNumber = customerDriverLicenseNumber;
    }

    public void setCarRegistrationNumber(int carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }
}