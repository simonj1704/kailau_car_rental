package src.entities;

public class Rental {
    private String fromDate;
    private String toDate;
    private int driverLicenseNumber;
    private int maxKm;
    private int km;
    private String carRegistrationNumber;

    public Rental(String fromDate, String toDate, int driverLicenseNumber, int maxKm, int km, String carRegistrationNumber) {
        setFromDate(fromDate);
        setToDate(toDate);
        setDriverLicenseNumber(driverLicenseNumber);
        setMaxKm(maxKm);
        setKm(km);
        setCarRegistrationNumber(carRegistrationNumber);
    }

    // GETTERS

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

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }


    // SETTERS

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

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;
    }

    @Override
    public String toString() {
        return "Rental{" +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", driverLicenseNumber=" + driverLicenseNumber +
                ", maxKm=" + maxKm +
                ", km=" + km +
                ", customerDriverLicenseNumber=" +
                ", carRegistrationNumber=" + carRegistrationNumber +
                '}';
    }
}