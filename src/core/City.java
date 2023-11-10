package core;


public class City {

    //Pedia ths City
    private  int   uniqueCode = 0;
    private String cityName;
    private static int MAX_CODE = 0;


    //Constructor ths City
    public City(String cityName) {
        //Metablhth pou krataei ton kwdiko tou antikeimenou ths klashs pou dhmiourghthike teleutaio 
        City.MAX_CODE = City.MAX_CODE + 1;

        this.cityName = cityName;
        //Monadikos kwdikos
        this.uniqueCode = MAX_CODE;
    }
 
    //Setters kai Getters 
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