package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import core.Rental;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class VehicleRentalSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

		//Array list gia rental
		ArrayList<Rental> rentalList;
		
		//rootPane gia thn skhnh rental
		GridPane rootGridPane;
		
		//flowPane gia ta koumpia ths rental
		FlowPane rentalButtonFlowPane;
		
		//gridPane gia ta pedia pou ekxwrei o xrhsths
		GridPane rentalInputFieldsGridPane;
		
		//koumpia ths rental
		Button newRentalBtn,cancelBtn,goBackBtn,emptyBtn;
		
		//labels ths rental
		Label rentalVehicleLbl,rentingClientLbl,retrieveStoreLbl,retrieveDateLbl,retrieveHourLbl,returnStoreLbl,returnDateLbl,returnHourLbl,totalCostLbl;
		
		//text fields ths rental
		TextField rentalVehicleField,rentingClientField,retrieveStoreField,retrieveDateField,retrieveHourField,returnStoreField,returnDateField,returnHourField,totalCostField;
		
		//table view ths rental
		TableView<Rental> rentalTableView;
	
		//constructor ths rental
		public VehicleRentalSceneCreator(double width, double height) {
		super(width, height);
		//arxikopoihsh arralist
		rentalList = new ArrayList<>();
		
		//arxikopoihsh pane
		rootGridPane = new GridPane();
		rentalButtonFlowPane = new FlowPane();
		rentalInputFieldsGridPane = new GridPane();
		
		//arxikopoihsh koumpiwn
		newRentalBtn = new Button("New Rental");
		cancelBtn = new Button("Cancel Rental");
		goBackBtn = new Button("Back");		
		emptyBtn = new Button("");  //ftiaxnw ena keno (invisible) koumpi katw apo to flowPane gia na exei keno to layout mou
		
		//arxikopoihsh label
		rentalVehicleLbl = new Label("Registration Number: ");
		rentingClientLbl = new Label("Client Name: ");
		retrieveStoreLbl = new Label("Retrieve Store: ");
		retrieveDateLbl = new Label("Retrieve Date: ");
		retrieveHourLbl = new Label("Retrieve Hour: ");
		returnStoreLbl = new Label("Return Store: ");
		returnDateLbl = new Label("Return Date: ");
		returnHourLbl = new Label("Return Hour: ");
		totalCostLbl = new Label("Total Cost: ");
		
		//arxikopoihsh textfield
		rentalVehicleField = new TextField();
		rentingClientField = new TextField();
		retrieveStoreField = new TextField();
		retrieveDateField = new TextField();
		retrieveHourField = new TextField();
		returnStoreField = new TextField();
		returnDateField = new TextField();
		returnHourField = new TextField();
		totalCostField = new TextField();
		
		//arxikopoihsh tableview
		rentalTableView = new TableView<>();
		
		//setarisma flowPane
		rentalButtonFlowPane.setHgap(10);
		rentalButtonFlowPane.getChildren().add(newRentalBtn);
		rentalButtonFlowPane.getChildren().add(cancelBtn);
		rentalButtonFlowPane.getChildren().add(goBackBtn);
		rentalButtonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
				
		//setarisma gridPane
		rentalInputFieldsGridPane.setAlignment(Pos.TOP_RIGHT);
		rentalInputFieldsGridPane.setHgap(10);
		rentalInputFieldsGridPane.setVgap(12);
		rentalInputFieldsGridPane.add(rentalVehicleLbl, 0, 1);
		rentalInputFieldsGridPane.add(rentalVehicleField, 1, 1);
		rentalInputFieldsGridPane.add(rentingClientLbl, 0, 2);
		rentalInputFieldsGridPane.add(rentingClientField, 1, 2);
		rentalInputFieldsGridPane.add(retrieveStoreLbl, 0, 3);
		rentalInputFieldsGridPane.add(retrieveStoreField, 1, 3);
		rentalInputFieldsGridPane.add(retrieveDateLbl, 0, 4);
		rentalInputFieldsGridPane.add(retrieveDateField, 1, 4);
		rentalInputFieldsGridPane.add(retrieveHourLbl, 0, 5);
		rentalInputFieldsGridPane.add(retrieveHourField, 1, 5);
		rentalInputFieldsGridPane.add(returnStoreLbl, 0, 6);
		rentalInputFieldsGridPane.add(returnStoreField, 1, 6);
		rentalInputFieldsGridPane.add(returnDateLbl, 0, 7);
		rentalInputFieldsGridPane.add(returnDateField, 1, 7);
		rentalInputFieldsGridPane.add(returnHourLbl, 0, 8);
		rentalInputFieldsGridPane.add(returnHourField, 1, 8);
		rentalInputFieldsGridPane.add(totalCostLbl, 0, 9);
		rentalInputFieldsGridPane.add(totalCostField, 1, 9);
		
		//setarisma rootGridPane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(rentalInputFieldsGridPane,1,0);
		rootGridPane.add(rentalTableView,0,0);
		rootGridPane.add(rentalButtonFlowPane,0,1);
				
		//baxw keno text field gia na emfanizei me apostasi to flowpane apo to table view
		rootGridPane.add(emptyBtn, 0, 2);
		emptyBtn.setVisible(false);
		
		//setarisma Table View
		TableColumn<Rental,String> uniqueCodeColumn = new TableColumn<>("Rental Code");
        uniqueCodeColumn.setCellValueFactory(new PropertyValueFactory<>("uniqueCode"));
        rentalTableView.getColumns().add(uniqueCodeColumn);

        TableColumn<Rental,String> rentalVehicleColumn = new TableColumn<>("Registration Number");
        rentalVehicleColumn.setCellValueFactory(new PropertyValueFactory<>("rentalVehicle"));
        rentalTableView.getColumns().add(rentalVehicleColumn);

        TableColumn<Rental,String> rentingClientColumn = new TableColumn<>("Client Name");
        rentingClientColumn.setCellValueFactory(new PropertyValueFactory<>("rentingClient"));
        rentalTableView.getColumns().add(rentingClientColumn);

        TableColumn<Rental,String> retrieveStoreColumn = new TableColumn<>("Retrieve Store");
        retrieveStoreColumn.setCellValueFactory(new PropertyValueFactory<>("retrieveStore"));
        rentalTableView.getColumns().add(retrieveStoreColumn);

        TableColumn<Rental,String> retrieveDateColumn = new TableColumn<>("Retrieve Date");
        retrieveDateColumn.setCellValueFactory(new PropertyValueFactory<>("retrieveDate"));
        rentalTableView.getColumns().add(retrieveDateColumn);
		
		TableColumn<Rental,String> retrieveHourColumn = new TableColumn<>("Retrieve Hour");
		retrieveHourColumn.setCellValueFactory(new PropertyValueFactory<>("retrieveHour"));
		rentalTableView.getColumns().add(retrieveHourColumn);
		
		TableColumn<Rental,String> returnStoreColumn = new TableColumn<>("Return Store");
		returnStoreColumn.setCellValueFactory(new PropertyValueFactory<>("returnStore"));
		rentalTableView.getColumns().add(returnStoreColumn);
		
		TableColumn<Rental,String> returnDateLblColumn = new TableColumn<>("Return Date");
		returnDateLblColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
		rentalTableView.getColumns().add(returnDateLblColumn);
		
		TableColumn<Rental,String> returnHourColumn = new TableColumn<>("Return Hour");
		returnHourColumn.setCellValueFactory(new PropertyValueFactory<>("returnHour"));
		rentalTableView.getColumns().add(returnHourColumn);
		
		TableColumn<Rental,String> totalCostLblColumn = new TableColumn<>("Total Cost");
		totalCostLblColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
		rentalTableView.getColumns().add(totalCostLblColumn);
		
		
		//sygxronismos twn energiwn me ta koumpia kai to tableView
	    newRentalBtn.setOnMouseClicked(this);
		cancelBtn.setOnMouseClicked(this);
		goBackBtn.setOnMouseClicked(this);
		goBackBtn.setOnMouseClicked(this);
		rentalTableView.setOnMouseClicked(this);
		
	}

	@Override
	//xeirismos twn gegonotwn
	public void handle(MouseEvent event) {
		
		//an paththei to koumpi back
		if(event.getSource() == goBackBtn) {
			MainFX.mainStage.setTitle("Car Rental Service");
			MainFX.mainStage.setScene(MainFX.mainScene);
		}
		//arxikopoihsh hmerwminiwn 
		Date RetrieveDate = null;
        Date ReturnDate = null;
       
      //an paththei to koumpi newStore
		if(event.getSource() == newRentalBtn) {
			String rentalVehicle = rentalVehicleField.getText();  //pairnw to text apo to field
			String rentingClient = rentingClientField.getText(); 
			String retrieveStore = retrieveStoreField.getText(); 
			String retrieveDate =  retrieveDateField.getText(); 
			String retrieveHour = retrieveHourField.getText(); 
            String returnStore = returnStoreField.getText(); 
            String returnDate = returnDateField.getText();
            String returnHour = returnHourField.getText();
            String totalCost = totalCostField.getText();
			
            int flag1=1;
			int flag2=1;
			int flag3=1;
			int flag4=1;
			int flag5=1;
			if(rentalVehicle.trim().isEmpty() != true && rentingClient.trim().isEmpty() != true || retrieveStore.trim().isEmpty() != true
				|| retrieveDate.trim().isEmpty() != true || retrieveHour.trim().isEmpty() != true 
				|| returnDate.trim().isEmpty() != true || returnHour.trim().isEmpty() != true || totalCost.trim().isEmpty() ) { //an den einai keno to text field
				
				//elegxw ton arithmo kukloforias ama yparxei
				for(int i=0; i < VehicleSceneCreator.vehicleList.size(); i++) {
					if(VehicleSceneCreator.vehicleList.get(i).getRegistrationNumber().equals(rentalVehicle) == true ) {						
							 flag1 = 0;
						     break;
						 }
				}
				//elegxw gia to onoma tou pelati
				for(int i=0; i < ClientSceneCreator.clientList.size(); i++) {	
					if(ClientSceneCreator.clientList.get(i).getFullClientName().equals(rentingClient) == true) {
							 flag2 = 0;
						     break;	
						 }						 
				}
				
				//elegxw gia to katastima paralabis ama yparxei
					
					for(int i=0; i < StoreSceneCreator.storeList.size(); i++) {
					if(StoreSceneCreator.storeList.get(i).getStoreName().equals(retrieveStore) == true ) {
							 flag3 = 0;
						     break;
					}						 
				}
	 	
				//elegxw gia to katastima epistrofis ama yparxei	
					for(int i=0; i < StoreSceneCreator.storeList.size(); i++) {
					if(StoreSceneCreator.storeList.get(i).getStoreName().equals(returnStore) == true ) {
							 flag4 = 0;
						     break;
					}else if(returnStore.trim().isEmpty() == true) {
						flag4=0;
						returnStore = retrieveStore;
						break;
					}
				}
				
				//elegxw an to retrieve date einai meta to return date na min to afinei
				
				try {
					RetrieveDate = new SimpleDateFormat("dd/MM/yyyy").parse(retrieveDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			
				try {
					ReturnDate = new SimpleDateFormat("dd/MM/yyyy").parse(returnDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(ReturnDate.after(RetrieveDate)) {
					flag5 = 0;					
				}
				
				//ama ola ta flag einai 0  ote dhmiourgeitai h enoikiash
				if(flag1==0 && flag2==0 && flag3==0 && flag4==0 && flag5==0) {
				    Rental rentalObject = new Rental(rentalVehicle,rentingClient,retrieveStore,retrieveDate, retrieveHour,returnStore,returnDate,returnHour, totalCost);
                    rentalList.add(rentalObject);
                    tableSync();
                    clearTextFields();
					
				}
            }
		}
		
		//an paththei to koumpi cancel
		if(event.getSource() == cancelBtn) {			
			

			Rental selectedRental = rentalTableView.getSelectionModel().getSelectedItem();//bazw se mia metabliti(selectedRental) typou Rental , auto pou epileksame apo ton pinaka tableView
			String rentalVehicle = rentalVehicleField.getText();  //pairnw to text apo to field
			String rentingClient = rentingClientField.getText(); 
			String retrieveStore = retrieveStoreField.getText(); 
		    String retrieveDate =  retrieveDateField.getText(); 
			String retrieveHour = retrieveHourField.getText(); 
            String returnStore = returnStoreField.getText(); 
            String returnDate = returnDateField.getText();
            String returnHour = returnHourField.getText();
            String totalCost = totalCostField.getText();
			
            
            if(selectedRental != null) {   
            //pernw to now date to kanw int
            String nowDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            
            //xwrizw to now date se parts
            String [] nowDateParts = nowDate.split("/");
            int nowDateDay = Integer.parseInt(nowDateParts[0]);
            int nowDateMonth = Integer.parseInt(nowDateParts[1]);
            int nowDateYear = Integer.parseInt(nowDateParts[2]);

            
            
            //retrieve date to xwrizw kai to kanw int gia na to sigkreinw
            String [] dateParts = retrieveDate.split("/");
            int retrieveDay = Integer.parseInt(dateParts[0]);
            int retrieveMonth = Integer.parseInt(dateParts[1]);
            int retrieveYear = Integer.parseInt(dateParts[2]);

            
            int flag = 1;
            //kanw elegxous gia to an epitrepetai na ginei h akyrwsh
            if(retrieveYear > nowDateYear) {
            	flag = 0;
            }
            else if(retrieveYear < nowDateYear) {
            	flag = 1;
            }
            else if(retrieveYear == nowDateYear) {
            	if(retrieveMonth > nowDateMonth) {
            		flag = 0;
            	}
            	else if(retrieveMonth < nowDateMonth) {
            		flag = 1;
            	}
            	else if(retrieveMonth == nowDateMonth) {
            		if(retrieveDay - nowDateDay >= 2) {
            			flag = 0;
            		}
            		else if(retrieveDay - nowDateDay < 2) {
            			flag = 1;
            		}
            	}
            }
            
                              
            for(int i=0; i < rentalList.size(); i++) {
            	//elegxnei ama ta paidia pou exei valei o xrhsths antistoixoun me ayta tou epilegmenou antikeimeno wste na ginei h akyrwsh
				if(rentalList.get(i).getRentalVehicle().equals(rentalVehicle) &&  rentalList.get(i).getRentingClient().equals(rentingClient) && rentalList.get(i).getRetrieveStore().equals(retrieveStore) && rentalList.get(i).getRetrieveDate().equals(retrieveDate) &&
						rentalList.get(i).getRetrieveHour().equals(retrieveHour) && rentalList.get(i).getReturnStore().equals(returnStore) && rentalList.get(i).getReturnDate().equals(returnDate)
                        && rentalList.get(i).getReturnHour().equals(returnHour) && rentalList.get(i).getTotalCost().equals(totalCost) && rentalList.get(i).getUniqueCode() == (selectedRental.getUniqueCode()) && flag == 0) {
					rentalList.remove(i);//afairesh apo thn lista
					tableSync();
					clearTextFields();
					break;
				}
			}
             }
		    
		}
		//an paththei to table view
		if(event.getSource() == rentalTableView) {
		
			Rental selectedRental = rentalTableView.getSelectionModel().getSelectedItem();  //pernw tin epilogi tou xrhsth
			if (selectedRental != null) {
				rentalVehicleField.setText(selectedRental.getRentalVehicle());   //bazw to onoma tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
                rentingClientField.setText(selectedRental.getRentingClient());
                retrieveStoreField.setText(selectedRental.getRetrieveStore());
                retrieveDateField.setText(selectedRental.getRetrieveDate());
                retrieveHourField.setText(selectedRental.getRetrieveHour());
				returnStoreField.setText(selectedRental.getReturnStore()); 
				returnDateField.setText(selectedRental.getReturnDate()); 
				returnHourField.setText(selectedRental.getReturnHour()); 
				totalCostField.setText(selectedRental.getTotalCost()); 
			}
		}
	}


	private void clearTextFields() {
		// TODO Auto-generated method stub
		
		//katharizw ta pedia gia epomenh kataxwrhsh
		rentalVehicleField.setText("");
		rentingClientField.setText("");
		retrieveStoreField.setText("");
		retrieveDateField.setText("");
		retrieveHourField.setText("");
		returnStoreField.setText("");
		returnDateField.setText("");
		returnHourField.setText("");
		totalCostField.setText("");
	}
	
	private void tableSync() { //ousiastika me tin tableSync ta emfanizw sto TableView
		// TODO Auto-generated method stub
		List<Rental> items = rentalTableView.getItems();
		items.clear();
		for(Rental rentalObject : rentalList) {
			if(rentalObject instanceof Rental) {
				items.add((Rental) rentalObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
			}
		}
	}

	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths store
	Scene createScene() {return new Scene(rootGridPane,width,height);
	}

}
