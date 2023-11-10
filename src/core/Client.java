package core;

public class Client {
		
		//pedia ths Client
	    private String clientIdNumber;
	    private String clientDriverLicenseNumber;
	    private String fullClientName;
	    private String clientEmail;
	    private String clientAddress;
	    private String clientPhoneNumber;
	    
	    //Constructor ths client
	    public Client(String clientIdNumber, String clientDriverLicenseNumber, String fullClientName, String clientEmail,
	            String clientAddress, String clientPhoneNumber) {
	        this.clientIdNumber = clientIdNumber;
	        this.clientDriverLicenseNumber = clientDriverLicenseNumber;
	        this.fullClientName = fullClientName;
	        this.clientEmail = clientEmail;
	        this.clientAddress = clientAddress;
	        this.clientPhoneNumber = clientPhoneNumber;
	    }
	    
	    //Setters kai getters
	    public String getClientIdNumber() {
	        return clientIdNumber;
	    }
	    public void setClientIdNumber(String clientIdNumber) {
	        this.clientIdNumber = clientIdNumber;
	    }
	    public String getClientDriverLicenseNumber() {
	        return clientDriverLicenseNumber;
	    }
	    public void setClientDriverLicenseNumber(String clientDriverLicenseNumber) {
	        this.clientDriverLicenseNumber = clientDriverLicenseNumber;
	    }
	    public String getFullClientName() {
	        return fullClientName;
	    }
	    public void setFullClientName(String fullClientName) {
	        this.fullClientName = fullClientName;
	    }
	    public String getClientEmail() {
	        return clientEmail;
	    }
	    public void setClientEmail(String clientEmail) {
	        this.clientEmail = clientEmail;
	    }
	    public String getClientAddress() {
	        return clientAddress;
	    }
	    public void setClientAddress(String clientAddress) {
	        this.clientAddress = clientAddress;
	    }
	    public String getClientPhoneNumber() {
	        return clientPhoneNumber;
	    }
	    public void setClientPhoneNumber(String clientPhoneNumber) {
	        this.clientPhoneNumber = clientPhoneNumber;
	    }


}

