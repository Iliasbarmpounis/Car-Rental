 package core;

public class TwoWheeled extends Vehicle{
	
		//pedia ths TwoWheeled
	    private String seatHeight;
	    private String baggageType;
	    
	    //constructor ths TwoWheeled
	    public TwoWheeled(String registrationNumber,String vehicleModel, String fuelType, String vehicleType, String cubism, String costOfRentalPerDay,String seatHeight,String baggageType) {
	        super(registrationNumber,vehicleModel, fuelType, vehicleType, cubism, costOfRentalPerDay);
	        this.seatHeight = seatHeight;
	        this.baggageType = baggageType;
	    }


	    //setters kai getters
	    public String getSeatHeight() {
	        return seatHeight;
	    }
	    public void setSeatHeight(String seatHeight) {
	        this.seatHeight = seatHeight;
	    }
	    public String getBaggageType() {
	        return baggageType;
	    }
	    public void setBaggageType(String baggageType) {
	        this.baggageType = baggageType;
	    }


	}

