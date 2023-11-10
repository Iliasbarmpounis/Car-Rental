package core;

public class Car extends Vehicle{

    //pedia ths Car
    private String seatNumber;
    private String doorNumber;

    //Constructor ths Car
    public Car(String registrationNumber, String vehicleModel, String fuelType, String vehicleType, String cubism, String costOfRentalPerDay,
            String seatNumber, String doorNumber) {
        super(registrationNumber, vehicleModel, fuelType, vehicleType, cubism, costOfRentalPerDay);
        this.seatNumber = seatNumber;
        this.doorNumber = doorNumber;
    }

    //Setters kai Getters ths Car
    public String getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getDoorNumber() {
        return doorNumber;
    }
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }



}