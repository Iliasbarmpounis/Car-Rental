package core;

public class Store {
	
	//pedia ths store
	private int uniqueCode = 0;
	private String storeName;
	private String cityName;
	private static int MAX_CODE = 0;
	
	//constructor ths store
	public Store(String storeName, String cityName) {
		this.storeName = storeName;
		this.cityName = cityName;
		
		//Metablhth pou krataei ton kwdiko tou antikeimenou ths klashs pou dhmiourghthike teleutaio 
		Store.MAX_CODE = MAX_CODE + 1;
		
		//Monadikos kwdikos
		this.uniqueCode = MAX_CODE;
	}
	
	//Setters kai getters
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getUniqueCode() {
		return uniqueCode;
	}
	

	public static int getMAX_CODE() {
		return MAX_CODE;
	}
	
	
}
