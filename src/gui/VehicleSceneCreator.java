package gui;

import java.util.ArrayList;
import java.util.List;

import core.Car;
import core.TwoWheeled;
import core.Vehicle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class VehicleSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	//Array list gia vehicle
	static ArrayList<Vehicle> vehicleList;
	
	
	//rootPane gia thn skhnh vehicle
	GridPane rootGridPane;
	
	//flowPane gia ta koumpia ths vehicle
	FlowPane vehicleButtonFlowPane;
	
	//gridPane gia ta pedia pou ekxwrei o xrhsths
	GridPane vehicleInputFieldsGridPane, carGridPane, twoWheeledGridPane;
	
	//koumpia ths vehicle
	Button newVehicleBtn, updateVehicleNameBtn, deleteVehicleBtn, goBackBtn, emptyBtn, viewAllBtn; //,searchBtn;
	
	//labels ths vehicle
	Label registrationNumberLbl, vehicleModelLbl, fuelTypeLbl, vehicleTypeLbl, cubismLbl, costOfRentalPerDayLbl, seatNumberLbl, doorNumberLbl, seatHeightLbl, baggageTypeLbl;
	
	//text fields ths vehicle
	TextField registrationNumberField, vehicleModelField, fuelTypeField, vehicleTypeField, cubismField, costOfRentalPerDayField, seatNumberField, doorNumberField, seatHeightField, baggageTypeField;
	
	//table view ths vehicle
	TableView<Vehicle> vehicleTableView;
	
	//radio buttons
	RadioButton carRb, twoWheeledRb;
	
	//combo box
	ComboBox<?> searchBox;
	
	//constructor ths vehicle
	public VehicleSceneCreator(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		    //arxikopoihsh arralist
		    vehicleList = new ArrayList<>();		
			
		    //arxikopoihsh pane
		    rootGridPane = new GridPane();
			vehicleButtonFlowPane = new FlowPane();
			vehicleInputFieldsGridPane = new GridPane();
			carGridPane = new GridPane();
			twoWheeledGridPane = new GridPane();
			
			//arxikopoihsh koumpiwn
			newVehicleBtn = new Button("New Vehicle");
			updateVehicleNameBtn = new Button("Update");
			deleteVehicleBtn = new Button("Delete");
			goBackBtn = new Button("Back");		
			emptyBtn = new Button("");  //ftiaxnw ena keno (invisible) koumpi katw apo to flowPane gia na exei keno to layout mou
			viewAllBtn = new Button("View All");

			//arxikopoihsh label
			registrationNumberLbl = new Label("Registration Number: ");
			vehicleModelLbl = new Label("Model: ");
			fuelTypeLbl = new Label("Fuel: ");
			vehicleTypeLbl = new Label("Type: ");
			cubismLbl = new Label("Cubism: ");
			costOfRentalPerDayLbl = new Label("Cost Per Day: ");
			seatNumberLbl = new Label("Seat Number: ");
			doorNumberLbl = new Label("Door Number: ");
			seatHeightLbl = new Label("Seat Height: ");
			baggageTypeLbl = new Label("Baggage Type: ");
			
			//arxikopoihsh textfield
			registrationNumberField = new TextField();
			vehicleModelField = new TextField();
			fuelTypeField = new TextField();
			vehicleTypeField = new TextField();
			cubismField = new TextField();
			costOfRentalPerDayField = new TextField();
			seatNumberField = new TextField();
			doorNumberField = new TextField();
			seatHeightField = new TextField();
		    baggageTypeField = new TextField();
			
		    //arxikopoihsh tableview
			vehicleTableView = new TableView<>();
			
			//setarisma radio buttons
			carRb = new RadioButton();
			carRb.setText("Car");
			twoWheeledRb = new RadioButton();
			twoWheeledRb.setText("Two-Wheeled");
						
			//ftiaxnw group gia ta radio buttons
			final ToggleGroup group = new ToggleGroup();
			
			//bazw to radio button sto group
			carRb.setToggleGroup(group);
			//thetw proepilegmeno to car radio button
			carRb.setSelected(true);
			
			//bazw to radio button sto group
			twoWheeledRb.setToggleGroup(group);
			
			
			//setarisma comboBox
		    ComboBox<String> searchBox = new ComboBox<String>();
			searchBox.getItems().addAll("Car","Two-Wheeled");
		
			//thetw text sto combobox gia na fainetai to Search
			searchBox.setPromptText("Search");
			
			
			//setarisma flowpane
			vehicleButtonFlowPane.setHgap(10);
			vehicleButtonFlowPane.getChildren().add(searchBox);
			vehicleButtonFlowPane.getChildren().add(newVehicleBtn);
			vehicleButtonFlowPane.getChildren().add(updateVehicleNameBtn);
			vehicleButtonFlowPane.getChildren().add(deleteVehicleBtn);
			vehicleButtonFlowPane.getChildren().add(viewAllBtn);
			vehicleButtonFlowPane.getChildren().add(goBackBtn);			
			vehicleButtonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
					
			//setarisma gridPane
			vehicleInputFieldsGridPane.setAlignment(Pos.TOP_RIGHT);
			vehicleInputFieldsGridPane.setHgap(10);
			vehicleInputFieldsGridPane.setVgap(15);
			vehicleInputFieldsGridPane.add(registrationNumberLbl, 0, 1);
			vehicleInputFieldsGridPane.add(registrationNumberField, 1, 1);
			vehicleInputFieldsGridPane.add(vehicleModelLbl, 0, 2);
			vehicleInputFieldsGridPane.add(vehicleModelField, 1, 2);	
			vehicleInputFieldsGridPane.add(fuelTypeLbl, 0, 3);
			vehicleInputFieldsGridPane.add(fuelTypeField, 1, 3);
			vehicleInputFieldsGridPane.add(vehicleTypeLbl, 0, 4);
			vehicleInputFieldsGridPane.add(vehicleTypeField, 1, 4);
			vehicleInputFieldsGridPane.add(cubismLbl, 0, 5);
			vehicleInputFieldsGridPane.add(cubismField, 1, 5);
			vehicleInputFieldsGridPane.add(costOfRentalPerDayLbl, 0, 6);
			vehicleInputFieldsGridPane.add(costOfRentalPerDayField, 1, 6);			
			vehicleInputFieldsGridPane.add(carRb, 0, 7);
			vehicleInputFieldsGridPane.add(twoWheeledRb, 1, 7);
			
			
			//setarisma car Grid Pane
			carGridPane.setVgap(10);
			carGridPane.add(seatNumberLbl, 0, 1);
			carGridPane.add(seatNumberField, 1, 1);
			carGridPane.add(doorNumberLbl, 0, 2);
			carGridPane.add(doorNumberField, 1, 2);
			
			//setarisma two Wheeled Grid Pane
			twoWheeledGridPane.setVgap(10);
		    twoWheeledGridPane.add(seatHeightLbl, 0, 1);
		    twoWheeledGridPane.add(seatHeightField, 1, 1);
		    twoWheeledGridPane.add(baggageTypeLbl, 0, 2);
		    twoWheeledGridPane.add(baggageTypeField, 1, 2);
			
		    //kanw to two wheeled aorato giati exw san default sto radio button to car
			twoWheeledGridPane.setVisible(false);
			
		
			//setarisma rootGridPane
			rootGridPane.setVgap(10);
			rootGridPane.setHgap(10);
			rootGridPane.add(vehicleInputFieldsGridPane,1,0);
			rootGridPane.add(vehicleTableView,0,0);
			rootGridPane.add(vehicleButtonFlowPane,0,1);		
			rootGridPane.add(carGridPane, 1, 1);
			rootGridPane.add(twoWheeledGridPane, 1, 1);
			
					
		    //bazw keno text field gia na emfanizei me apostasi to flowpane apo to table view
			rootGridPane.add(emptyBtn, 0, 2);
			emptyBtn.setVisible(false);
			
			//setarisma Table View
			TableColumn<Vehicle,String> registrationNumberColumn = new TableColumn<>("Registration Number");
			registrationNumberColumn.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
			vehicleTableView.getColumns().add(registrationNumberColumn);
			
			
			TableColumn<Vehicle,String> vehicleModelColumn = new TableColumn<>("Model");
			vehicleModelColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
			vehicleTableView.getColumns().add(vehicleModelColumn);
			
					
			TableColumn<Vehicle,String> fuelTypeColumn = new TableColumn<>("Fuel Type");
			fuelTypeColumn.setCellValueFactory(new PropertyValueFactory<>("fuelType"));
			vehicleTableView.getColumns().add(fuelTypeColumn);
			
			
			TableColumn<Vehicle,String> vehicleTypeColumn = new TableColumn<>("Vehicle Type");
			vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
			vehicleTableView.getColumns().add(vehicleTypeColumn);
			
			
			TableColumn<Vehicle,String> cubismColumn = new TableColumn<>("Cubism");
			cubismColumn.setCellValueFactory(new PropertyValueFactory<>("cubism"));
			vehicleTableView.getColumns().add(cubismColumn);
			
			
			TableColumn<Vehicle,String> costOfRentalPerDayColumn = new TableColumn<>("Cost Per Day");
			costOfRentalPerDayColumn.setCellValueFactory(new PropertyValueFactory<>("costOfRentalPerDay"));
			vehicleTableView.getColumns().add(costOfRentalPerDayColumn);
		
			
			
			//kolones gia car
			TableColumn<Vehicle,String> seatNumberColumn = new TableColumn<>("Seat Number");
			seatNumberColumn.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));
			vehicleTableView.getColumns().add(seatNumberColumn);
			
			
			TableColumn<Vehicle,String> doorNumberColumn = new TableColumn<>("Door Number");
			doorNumberColumn.setCellValueFactory(new PropertyValueFactory<>("doorNumber"));
			vehicleTableView.getColumns().add(doorNumberColumn);
			
			

			//kolones gia twoWheeled
			TableColumn<Vehicle,String> seatHeightColumn = new TableColumn<>("Seat Height");
			seatHeightColumn.setCellValueFactory(new PropertyValueFactory<>("seatHeight"));
			vehicleTableView.getColumns().add(seatHeightColumn);
			
			
			TableColumn<Vehicle,String> baggageTypeColumn = new TableColumn<>("Baggage Type");
			baggageTypeColumn.setCellValueFactory(new PropertyValueFactory<>("baggageType"));
			vehicleTableView.getColumns().add(baggageTypeColumn);
			
			
			
			//sygxronismos twn energiwn me ta koumpia kai to tableView		
			newVehicleBtn.setOnMouseClicked(this);
			updateVehicleNameBtn.setOnMouseClicked(this);
			deleteVehicleBtn.setOnMouseClicked(this);
		    goBackBtn.setOnMouseClicked(this);
			vehicleTableView.setOnMouseClicked(this);
			viewAllBtn.setOnMouseClicked(this);
			carRb.setOnMouseClicked(this);
			twoWheeledRb.setOnMouseClicked(this);
			searchBox.setOnMouseClicked(this);
			
			
			
			//gia to combobox inner class gia na xeiristw analoga ti epilegei sto comboBox			
			searchBox.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					if(searchBox.getValue() != null) {
						String value = (String) searchBox.getValue();
						//tropopoihmenh tableSync gia otan epilegei Car
						if(value == "Car") {
							List<Vehicle> items = vehicleTableView.getItems();
							items.clear();
							for(Vehicle vehicleObject : vehicleList) {
								if(vehicleObject instanceof Car) {
									items.add((Vehicle) vehicleObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
									clearTextFields();
									searchBox.setValue(null);
								}
							}
						}
						//tropopoihmenh tableSync gia otan epilegei Two-Wheeled
						if(value == "Two-Wheeled") {
							List<Vehicle> items = vehicleTableView.getItems();
							items.clear();
							for(Vehicle vehicleObject : vehicleList) {
								if(vehicleObject instanceof TwoWheeled) {
									items.add((Vehicle) vehicleObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
									clearTextFields();
									searchBox.setValue(null);
								}
							}
						}
					}
				}
				
			});
		
	}


	@Override
	//xeirismos twn gegonotwn
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub		
		
		//an paththei to koumpi back
		if(event.getSource() == goBackBtn) {
			MainFX.mainStage.setTitle("Car Rental Service");
			MainFX.mainStage.setScene(MainFX.mainScene);
		}
		
		//an paththei to radio button car
		if(carRb.isSelected() == true) {				
			 carGridPane.setVisible(true);
			 twoWheeledGridPane.setVisible(false);
		}
		
		//an paththei to radio button twoWheeled
		if(twoWheeledRb.isSelected() == true) {
			 twoWheeledGridPane.setVisible(true);
			carGridPane.setVisible(false);
		}
		
		//an paththei to koumpi newVehicle
		if(event.getSource() == newVehicleBtn) {									
			//pairnw to text apo ta fields
			String registrationNumber = registrationNumberField.getText();
			String vehicleModel = vehicleModelField.getText();  
			String fuelType = fuelTypeField.getText(); 
			String vehicleType = vehicleTypeField.getText();
			String cubism = cubismField.getText();
			String costOfRentalPerDay = costOfRentalPerDayField.getText();
			String seatNumber = seatNumberField.getText();
			String doorNumber = doorNumberField.getText();
			String seatHeight = seatHeightField.getText();
			String baggageType = baggageTypeField.getText();
			
			
			if(registrationNumber.trim().isEmpty() != true && vehicleModel.trim().isEmpty() != true && fuelType.trim().isEmpty() != true 
				&& vehicleType.trim().isEmpty() != true && cubism.trim().isEmpty() != true
				&& costOfRentalPerDay.trim().isEmpty() != true) { //an den einai kena ta text fields
				
				int flag = 0;
				for(int i=0; i < vehicleList.size(); i++) {
					//elegxw ton arithmo kukloforias ama yparxei
                    if(vehicleList.get(i).getRegistrationNumber().equals(registrationNumber) == true) {
                    	flag = 1;
                    }
                 }
				       //elegxw ton typo kausimou
				       if((fuelType.equals("diesel") || fuelType.equals("petrol") ) && flag != 1 ) {   
						  //an einai to radio button car epilegmeno tote ftiaxnei ena antikeimeno typou Car								
                          if(carRb.isSelected() == true && seatNumber.trim().isEmpty() != true && doorNumber.trim().isEmpty() != true) {                    	
                    	    Car carObject = new Car(registrationNumber,vehicleModel,fuelType,vehicleType,cubism,costOfRentalPerDay,seatNumber,doorNumber);
                    	    vehicleList.add(carObject); //prosthetoyme to antikeimeno sthn lista
                            tableSync();
                            clearTextFields();
                           }
                        //an einai to radio button twoWheeled epilegmeno tote ftiaxnei ena antikeimeno typou TwoWheeled	
                          if(twoWheeledRb.isSelected() == true && seatHeight.trim().isEmpty() != true && baggageType.trim().isEmpty() != true) {
                    	    TwoWheeled twoWheeledObject = new TwoWheeled(registrationNumber,vehicleModel,fuelType,vehicleType,cubism,costOfRentalPerDay,seatHeight,baggageType);
                    	    vehicleList.add(twoWheeledObject); //prosthetoyme to antikeimeno sthn lista
                    	    tableSync();
                            clearTextFields();
                          }
				            
                     }       
				
			}
            
		}
		
		//an paththei to koumpi update
		if(event.getSource() == updateVehicleNameBtn) {
			//pairnw to text apo ta fields
			String registrationNumber = registrationNumberField.getText();
			String vehicleModel = vehicleModelField.getText();  
			String fuelType = fuelTypeField.getText();  
			String vehicleType = vehicleTypeField.getText();
			String cubism = cubismField.getText();
			String costOfRentalPerDay = costOfRentalPerDayField.getText();
			String seatNumber = seatNumberField.getText();
			String doorNumber = doorNumberField.getText();
			String seatHeight = seatHeightField.getText();
			String baggageType = baggageTypeField.getText();
			
			
			  
			  if(registrationNumber.trim().isEmpty() != true && vehicleModel.trim().isEmpty() != true && fuelType.trim().isEmpty() != true 
						&& vehicleType.trim().isEmpty() != true && cubism.trim().isEmpty() != true
						&& costOfRentalPerDay.trim().isEmpty() != true) { //elegxw ama den einai keno
				  
				    int flag = 0;
					for(int i=0; i < vehicleList.size(); i++) { //prospelaynoume thn lista vehicle
	                   //elegxei to registrationNumber kai kanw to flag = 1 an uparxei
						if(vehicleList.get(i).getRegistrationNumber().equals(registrationNumber) == true ) {
	                    	flag = 1;
	                    }
	                  
	                 }
				  
				  //an exei epilexthei to car radio button kai to registrationNumber uparxei(flag == 1)
				  if(carRb.isSelected() == true && seatNumber.trim().isEmpty() != true && doorNumber.trim().isEmpty() != true && flag == 1) { 				  
					  if(fuelType.equals("diesel") || fuelType.equals("petrol")) { 
						  Car selectedCar = (Car) vehicleTableView.getSelectionModel().getSelectedItem();  //bazw se mia metabliti(selectedCar) typou Car , auto pou epileksame apo ton pinaka tableView
							
						  if (selectedCar != null) {
						  //bazw tin epilogh tou xrhsth sthn antistoixh thesh tou tableView pou epelekse			
						  selectedCar.setVehicleModel(vehicleModel); 
						  selectedCar.setFuelType(fuelType);
						  selectedCar.setVehicleType(vehicleType);
						  selectedCar.setCubism(cubism);
	                      selectedCar.setCostOfRentalPerDay(costOfRentalPerDay);
	                      selectedCar.setSeatNumber(seatNumber);
	                      selectedCar.setDoorNumber(doorNumber);						  
						  tableSync();						      					 
			              clearTextFields(); 
						  }
				      }				  			 
				  }	
				  //an exei epilexthei to twoWheeled radio button kai to registrationNumber uparxei(flag == 1)
				  if(twoWheeledRb.isSelected() == true && seatHeight.trim().isEmpty() != true && baggageType.trim().isEmpty() != true && flag == 1) { 
					  if(fuelType.equals("diesel") || fuelType.equals("petrol")) { 
						  TwoWheeled selectedTwoWheeled = (TwoWheeled) vehicleTableView.getSelectionModel().getSelectedItem();  //bazw se mia metabliti(selectedCar) typou Car , auto pou epileksame apo ton pinaka tableView
							
						  if (selectedTwoWheeled != null) {
						  //bazw tin epilogh tou xrhsth sthn antistoixh thesh tou tableView pou epelekse			
						  selectedTwoWheeled.setVehicleModel(vehicleModel); 
						  selectedTwoWheeled.setFuelType(fuelType);
						  selectedTwoWheeled.setVehicleType(vehicleType);
						  selectedTwoWheeled.setCubism(cubism);
	                      selectedTwoWheeled.setCostOfRentalPerDay(costOfRentalPerDay);
	                      selectedTwoWheeled.setSeatHeight(seatHeight);
	                      selectedTwoWheeled.setBaggageType(baggageType);						  
						  tableSync();					      					 
			              clearTextFields(); 	
						  }
				      }				  			 
				  }	
		      }	
			
		  }
		
		//an paththei to table view
		if(event.getSource() == vehicleTableView) {
			 clearTextFields();
			 Vehicle selectedVehicle =   vehicleTableView.getSelectionModel().getSelectedItem(); //pernw tin epilogi tou xrhsth
			 if (selectedVehicle != null) { //elegxw ama exei epilexthei kapoio antikeimeno
			    //elegxei ton tupo tou antikeimenou kai epilegetai to antistoixo radio button
				if(selectedVehicle instanceof Car) {
				   carRb.setSelected(true);
			    }
			 
			    if(selectedVehicle instanceof TwoWheeled) {
				   twoWheeledRb.setSelected(true);
			    }
			 }
			
		     if(carRb.isSelected() == true) 	{
			    if (selectedVehicle != null) { //elegxw ama exei epilexthei kapoio antikeimeno
			      //bazw to periexomeno tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
			      registrationNumberField.setText(selectedVehicle.getRegistrationNumber()); 
				  vehicleModelField.setText(selectedVehicle.getVehicleModel());   
	              fuelTypeField.setText(selectedVehicle.getFuelType());   
	              vehicleTypeField.setText(selectedVehicle.getVehicleType());   
	              cubismField.setText(selectedVehicle.getCubism());   
	        	  costOfRentalPerDayField.setText(selectedVehicle.getCostOfRentalPerDay());  
	        	  seatNumberField.setText(((Car) selectedVehicle).getSeatNumber());  
                  doorNumberField.setText(((Car) selectedVehicle).getDoorNumber());
			     }			
		     }
		     if(twoWheeledRb.isSelected() == true) {
			    if(selectedVehicle != null) {
			      //bazw to periexomeno tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
			      registrationNumberField.setText(selectedVehicle.getRegistrationNumber());
				  vehicleModelField.setText(selectedVehicle.getVehicleModel());  
	              fuelTypeField.setText(selectedVehicle.getFuelType());   
	              vehicleTypeField.setText(selectedVehicle.getVehicleType());   
	              cubismField.setText(selectedVehicle.getCubism());   
	        	  costOfRentalPerDayField.setText(selectedVehicle.getCostOfRentalPerDay());
	        	  seatHeightField.setText(((TwoWheeled) selectedVehicle).getSeatHeight());
	        	  baggageTypeField.setText(((TwoWheeled) selectedVehicle).getBaggageType());
			     }
		     }
		     
		     if(carRb.isSelected() == true){       
	                carGridPane.setVisible(true);
	                twoWheeledGridPane.setVisible(false);
	            }
	         if(twoWheeledRb.isSelected() == true){
	                carGridPane.setVisible(false);
	                twoWheeledGridPane.setVisible(true);
	            }
		     
		
	}
		//an paththei to koumpi delete
		if(event.getSource() == deleteVehicleBtn) { 
			//pairnw to text apo ta fields
			String registrationNumber = registrationNumberField.getText();
			String vehicleModel = vehicleModelField.getText();  
            String fuelType = fuelTypeField.getText(); 
            String vehicleType = vehicleTypeField.getText();
            String cubism = cubismField.getText();
            String costOfRentalPerDay = costOfRentalPerDayField.getText();
            String seatNumber = seatNumberField.getText();
            String doorNumber = doorNumberField.getText();
            String seatHeight = seatHeightField.getText();
            String baggageType = baggageTypeField.getText(); 
                for(int i=0; i < vehicleList.size(); i++) {
                   //elegxw an ola ta fields pou pairnei apo ton xrhsth einai isa me ta pedia kapoiou antikeimenou wste na diagrafei to antikeimeno
                	if(vehicleList.get(i).getRegistrationNumber().equals(registrationNumber) && vehicleList.get(i).getVehicleModel().equals(vehicleModel) && vehicleList.get(i).getFuelType().equals(fuelType)
                            && vehicleList.get(i).getVehicleType().equals(vehicleType)&& vehicleList.get(i).getCubism().equals(cubism)
                            && vehicleList.get(i).getCostOfRentalPerDay().equals(costOfRentalPerDay)) {
                        if(carRb.isSelected() && ((Car) vehicleList.get(i)).getSeatNumber().equals(seatNumber) && ((Car) vehicleList.get(i)).getDoorNumber().equals(doorNumber)) {
                            vehicleList.remove(i);
                            tableSync();
                            clearTextFields();
                            break;
                         }
                        if(twoWheeledRb.isSelected() && ((TwoWheeled) vehicleList.get(i)).getSeatHeight().equals(seatHeight) && ((TwoWheeled) vehicleList.get(i)).getBaggageType().equals(baggageType)){
                            vehicleList.remove(i);
                            tableSync();
                            clearTextFields();
                            break;
                        }

                    }
                }
            }	

		//an paththei to view all
		if(event.getSource() == viewAllBtn) {
			tableSync();
			clearTextFields();
		}
		
	}
	
	
	private void clearTextFields() {
		// TODO Auto-generated method stub
		
		//katharizw ta pedia gia epomenh kataxwrhsh
		registrationNumberField.setText("");
		vehicleModelField.setText("");
		fuelTypeField.setText("");
		vehicleTypeField.setText("");
		cubismField.setText("");
		costOfRentalPerDayField.setText("");
		seatNumberField.setText("");
		doorNumberField.setText("");
		seatHeightField.setText("");
		baggageTypeField.setText("");
	}
	
	private void tableSync() {   //ousiastika me tin tableSync ta emfanizw sto TableView
		// TODO Auto-generated method stub
		List<Vehicle> items = vehicleTableView.getItems();
		items.clear();
		for(Vehicle vehicleObject : vehicleList) {
			if(vehicleObject instanceof Vehicle) {
				items.add((Vehicle) vehicleObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
			}
		}
	}

	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths vehicle
	Scene createScene() { return new Scene(rootGridPane,width,height);	}

	
}
