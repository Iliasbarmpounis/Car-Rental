package core;


public class Vehicle {
	
	//pedia ths vehicle
    private String registrationNumber;
    private String vehicleModel;
    private String fuelType;
    private String vehicleType;
    private String cubism;
    private String costOfRentalPerDay;
    
    //constructor ths vehicle
    public Vehicle(String registrationNumber ,String vehicleModel, String fuelType, String vehicleType, String cubism, String costOfRentalPerDay) {
    	this.registrationNumber = registrationNumber;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.cubism = cubism;
        this.costOfRentalPerDay = costOfRentalPerDay;
    }

    
    //setters kai getters
    public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
    		this.fuelType = fuelType;
    }
    public String getCubism() {
        return cubism;
    }
    public void setCubism(String cubism) {
        this.cubism = cubism;
    }
    public String getCostOfRentalPerDay() {
        return costOfRentalPerDay;
    }
    public void setCostOfRentalPerDay(String costOfRentalPerDay) {
        this.costOfRentalPerDay = costOfRentalPerDay;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
