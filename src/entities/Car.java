package src.entities;

public class Car {
        private String brand;
        private String model;
        private String fuelType;
        private String registrationYear;
        private String type;
        private boolean isRented;
        private String registrationNumber;
        private int odometer;

        //Constructor
    public Car(String brand, String model, String fuelType, String registrationNumber, String registrationYear, int odometer, String type, boolean isRented) {
        setBrand(brand);
        setModel(model);
        setFuelType(fuelType);
        setRegistrationYear(registrationYear);
        setType(type);
        setRented(isRented);
        setRegistrationNumber(registrationNumber);
        setOdometer(odometer);
    }


        //Getters
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public int getOdometer(){
        return odometer;
    }

    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public void setOdometer(int odometer){
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", fuelType='" + getFuelType() + '\'' +
                ", registrationYear='" + getRegistrationYear() + '\'' +
                ", type='" + getType() + '\'' +
                ", isRented=" + isRented() +
                '}';
    }
}
