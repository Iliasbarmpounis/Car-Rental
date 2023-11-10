package core;



public class Rental {
	
	//pedia ths rental
	private int UniqueCode = 0;
	private String rentalVehicle;
	private String rentingClient;
	private String retrieveStore;
	private String retrieveDate;
	private String retrieveHour;
	private String returnStore;
	private String returnDate;
	private String returnHour;
	private String totalCost;
	private static int MAX_CODE = 0;
	
	
	//Constructor ths rental
	public Rental(String rentalVehicle, String rentingClient, String retrieveStore, String retrieveDate,
			String retrieveHour,String returnStore, String returnDate, String returnHour, String totalCost) {
		
		this.rentalVehicle = rentalVehicle;
		this.rentingClient = rentingClient;
		this.retrieveStore = retrieveStore;
		this.retrieveDate = retrieveDate;
		this.retrieveHour = retrieveHour;
		this.returnStore = returnStore;
		this.returnDate = returnDate;
		this.returnHour = returnHour;
		this.totalCost = totalCost;
		
		//Metablhth pou krataei ton kwdiko tou antikeimenou ths klashs pou dhmiourghthike teleutaio 
		Rental.MAX_CODE = MAX_CODE + 1;
		
		//Monadikos kwdikos
		this.UniqueCode = MAX_CODE;
	}
	
	//Setters kai getters
	public String getRentalVehicle() {
		return rentalVehicle;
	}

	public void setRentalVehicle(String rentalVehicle) {
		this.rentalVehicle = rentalVehicle;
	}

	public String getRentingClient() {
		return rentingClient;
	}

	public void setRentingClient(String rentingClient) {
		this.rentingClient = rentingClient;
	}

	public String getRetrieveStore() {
		return retrieveStore;
	}

	public void setRetrieveStore(String retrieveStore) {
		this.retrieveStore = retrieveStore;
	}

	public String getRetrieveDate() {
		return retrieveDate;
	}

	public void setRetrieveDate(String retrieveDate) {
		this.retrieveDate = retrieveDate;
	}

	public String getReturnStore() {
		return returnStore;
	}

	public void setReturnStore(String returnStore) {
		this.returnStore = returnStore;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public int getUniqueCode() {
		return UniqueCode;
	}

	public static int getMAX_CODE() {
		return MAX_CODE;
	}

	public String getRetrieveHour() {
		return retrieveHour;
	}

	public void setRetrieveHour(String retrieveHour) {
		this.retrieveHour = retrieveHour;
	}

	public String getReturnHour() {
		return returnHour;
	}

	public void setReturnHour(String returnHour) {
		this.returnHour = returnHour;
	}
	
	
	
	
}
