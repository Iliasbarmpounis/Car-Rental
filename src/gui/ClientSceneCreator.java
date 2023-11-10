package gui;

import java.util.ArrayList;
import java.util.List;

import core.Client;
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

public class ClientSceneCreator  extends SceneCreator implements EventHandler<MouseEvent>{
	
	        //Array list gia client
			static ArrayList<Client> clientList;
			
			//Array list gia to search
			ArrayList<Client> searchList;
			
			//rootPane gia thn skhnh client
			GridPane rootGridPane;
			
			//flowPane gia ta koumpia ths client
			FlowPane clientButtonFlowPane;
			
			// gridPane gia ta pedia pou ekxwrei o xrhsths
			GridPane clientInputFieldsGridPane;
			
			//koumpia ths client
			Button searchBtn, newClientBtn, updateClientNameBtn, deleteClientBtn, goBackBtn, emptyBtn, viewAllBtn;
			
			//labels ths client
			Label searchLbl,clientIdNumberLbl,clientDriverLicenseNumberLbl,fullClientNameLbl,clientEmailLbl,clientΑddressLbl,clientPhoneNumberLbl;
			
			//text fields ths client
			TextField searchField,clientIdNumberField,clientDriverLicenseNumberField,fullClientNameField,clientEmailField,clientΑddressField,clientPhoneNumberField;
			
			//table view ths client
			TableView<Client> clientTableView;
	
	//constructor ths city	
	public ClientSceneCreator(double width, double height) {
		super(width, height);
		//arxikopoihsh arralist
		clientList = new ArrayList<>();
        searchList = new ArrayList<>();     
        
        //arxikopoihsh label
        searchLbl = new Label("ID");
        clientIdNumberLbl = new Label("ID: ");
        clientDriverLicenseNumberLbl  = new Label("Driver License Number: ");
        fullClientNameLbl = new Label("Name: ");
        clientEmailLbl  = new Label("Email: ");
        clientΑddressLbl = new Label("Αddress: ");
        clientPhoneNumberLbl = new Label("Phone Number: ");
        
        //arxikopoihsh pane
        rootGridPane = new GridPane();
        clientButtonFlowPane = new FlowPane(searchLbl);
        clientInputFieldsGridPane = new GridPane();
        
        //arxikopoihsh koumpiwn
        searchBtn = new Button("🔎");
        newClientBtn = new Button("New Client");
        updateClientNameBtn = new Button("Update");
        deleteClientBtn = new Button("Delete");
        goBackBtn = new Button("Back");
        emptyBtn = new Button("");  //ftiaxnw ena keno (invisible) koumpi katw apo to flowPane gia na exei keno to layout mou
        viewAllBtn = new Button("View All");

        //arxikopoihsh textfield
        clientIdNumberField = new TextField();
        clientDriverLicenseNumberField = new TextField();
        fullClientNameField = new TextField();
        clientEmailField = new TextField();
        clientΑddressField  = new TextField();  
        clientPhoneNumberField = new TextField();
        searchField = new TextField();
        
        //arxikopoihsh tableview
        clientTableView = new TableView<>();
        
        //setarisma flowPane
        clientButtonFlowPane.setHgap(4);
        clientButtonFlowPane.getChildren().add(searchField);
        clientButtonFlowPane.getChildren().add(searchBtn);
        clientButtonFlowPane.getChildren().add(newClientBtn);
        clientButtonFlowPane.getChildren().add(updateClientNameBtn);
        clientButtonFlowPane.getChildren().add(deleteClientBtn);
        clientButtonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        
        //setarisma gridPane
        clientInputFieldsGridPane.setAlignment(Pos.TOP_RIGHT);
        clientInputFieldsGridPane.setHgap(10);
        clientInputFieldsGridPane.setVgap(15);
        clientInputFieldsGridPane.add(clientIdNumberLbl, 0, 1);
        clientInputFieldsGridPane.add(clientIdNumberField, 1, 1);
        clientInputFieldsGridPane.add(clientDriverLicenseNumberLbl, 0, 2);
        clientInputFieldsGridPane.add(clientDriverLicenseNumberField, 1, 2);
        clientInputFieldsGridPane.add(fullClientNameLbl, 0, 3);
        clientInputFieldsGridPane.add(fullClientNameField, 1, 3);
        clientInputFieldsGridPane.add(clientEmailLbl, 0, 4);
        clientInputFieldsGridPane.add(clientEmailField, 1, 4);
        clientInputFieldsGridPane.add(clientΑddressLbl, 0, 5);
        clientInputFieldsGridPane.add(clientΑddressField, 1, 5);
        clientInputFieldsGridPane.add(clientPhoneNumberLbl, 0, 6);
        clientInputFieldsGridPane.add(clientPhoneNumberField, 1, 6);
        
        //setarisma rootGridPane
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(clientInputFieldsGridPane,1,0);
        rootGridPane.add(clientTableView,0,0);
        rootGridPane.add(clientButtonFlowPane,0,1);
        rootGridPane.add(viewAllBtn, 2, 1);
        rootGridPane.add(goBackBtn, 3, 1);
       
        		
        //bazw keno koumpi gia na emfanizei me apostasi to flowpane apo to table view
        rootGridPane.add(emptyBtn, 0, 2);
        emptyBtn.setVisible(false);
        
        //setarisma Table View
        TableColumn<Client,String> clientIdNumberColumn = new TableColumn<>("ID");
        clientIdNumberColumn.setCellValueFactory(new PropertyValueFactory<>("clientIdNumber"));
        clientTableView.getColumns().add(clientIdNumberColumn);
        
        TableColumn<Client,String> ClientDriverLicenceNumberColumn = new TableColumn<>("Driver Licence Number");
        ClientDriverLicenceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("clientDriverLicenseNumber"));
        clientTableView.getColumns().add(ClientDriverLicenceNumberColumn);
        
        TableColumn<Client,String> fullClientNameColumn = new TableColumn<>("Name");
        fullClientNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullClientName"));
        clientTableView.getColumns().add(fullClientNameColumn);
       
        TableColumn<Client,String> clientEmailColumn = new TableColumn<>("Email");
        clientEmailColumn.setCellValueFactory(new PropertyValueFactory<>("clientEmail"));
        clientTableView.getColumns().add(clientEmailColumn);
       
        TableColumn<Client,String> clientΑddressColumn = new TableColumn<>("Address");
        clientΑddressColumn.setCellValueFactory(new PropertyValueFactory<>("clientΑddress"));
        clientTableView.getColumns().add(clientΑddressColumn);      
        
        TableColumn<Client,String> clientPhoneNumberColumn = new TableColumn<>("Phone Number");
        clientPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("clientPhoneNumber"));
        clientTableView.getColumns().add(clientPhoneNumberColumn);
        
      
        //sygxronismos twn energiwn me ta koumpia kai to tableView
        searchBtn.setOnMouseClicked(this);
  	  	newClientBtn.setOnMouseClicked(this);
  	  	updateClientNameBtn.setOnMouseClicked(this);
  	  	deleteClientBtn.setOnMouseClicked(this);
  	  	goBackBtn.setOnMouseClicked(this);
    	clientTableView.setOnMouseClicked(this);
  	  	viewAllBtn.setOnMouseClicked(this);
        
	}

	@Override
	//xeirismos twn gegonotwn 
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		
		//an paththei to koumpi back
		if(event.getSource() == goBackBtn) { 
			MainFX.mainStage.setTitle("Car Rental Service"); //alazw ton titlo ths skhnhs
			MainFX.mainStage.setScene(MainFX.mainScene); //phgainw sthn main skhnh
		}
		
		//an paththei to koumpi newClient
		if(event.getSource() == newClientBtn) {
			String clientIdNumber = clientIdNumberField.getText();   //pairnw to text apo ta textFields
			String clientDriverLicenseNumber = clientDriverLicenseNumberField.getText(); 
			String fullClientName = fullClientNameField.getText();
			String clientEmail = clientEmailField.getText();
			String clientΑddress = clientΑddressField.getText();
			String clientPhoneNumber = clientPhoneNumberField.getText();
			
					
			int flag=0;
			if(clientIdNumber.trim().isEmpty() != true && clientDriverLicenseNumber.trim().isEmpty() != true  
					&& fullClientName.trim().isEmpty() != true && clientEmail.trim().isEmpty() != true
					&& clientΑddress.trim().isEmpty() != true && clientPhoneNumber.trim().isEmpty() != true) { //an den einai keno to text field
				
							
				 			
				   for(int i=0; i < clientList.size(); i++) { //prospelaynoume thn lista me tous pelates
					   //elegxoi gia na min bazei idia: id , driver licence
					   if(clientList.get(i).getClientIdNumber().equals(clientIdNumber) || clientList.get(i).getClientDriverLicenseNumber().equals(clientDriverLicenseNumber)) {
				          flag = 1;
						  break;
					   }
				    }
				 				
     			 if(flag != 1) {
				    Client clientObject = new Client( clientIdNumber, clientDriverLicenseNumber ,fullClientName ,clientEmail, clientΑddress, clientPhoneNumber );
                    clientList.add(clientObject); //prosthetoyme to antikeimeno sthn lista
                    tableSync();
                    clearTextFields();
     			 }
			  
			
           }
		}
		
		//an paththei to koumpi update
		if(event.getSource() == updateClientNameBtn) {
			String clientIdNumber = clientIdNumberField.getText();  //pairnw to text apo ta textFields
			String clientDriverLicenseNumber = clientDriverLicenseNumberField.getText(); 
			String fullClientName = fullClientNameField.getText();
			String clientEmail = clientEmailField.getText();
			String clientΑddress = clientΑddressField.getText();
			String clientPhoneNumber = clientPhoneNumberField.getText();
			
			  if(clientIdNumber.trim().isEmpty() != true && clientDriverLicenseNumber.trim().isEmpty() != true  
						&& fullClientName.trim().isEmpty() != true && clientEmail.trim().isEmpty() != true
						&& clientΑddress.trim().isEmpty() != true && clientPhoneNumber.trim().isEmpty() != true) { //elegxw ama den einai keno

				  Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();  //bazw se mia metabliti(selectedClient) typou Client , auto pou epileksame apo ton pinaka tableView
				  if (selectedClient != null) {  
				  //bazw tin epilogh tou xrhsth sthn antistoixh thesh tou tableView pou epelekse			
				  selectedClient.setFullClientName(fullClientName); //tote enhmerwnoume to pedio tou epilegmenou antikeimenou 
				  selectedClient.setClientEmail(clientEmail);
				  selectedClient.setClientAddress(clientΑddress);
				  selectedClient.setClientPhoneNumber(clientPhoneNumber);
				  
				  tableSync();	
	              clearTextFields();
				 
			   }
		     }	
		}
		
		//an paththei to koumpi delete
		if(event.getSource() == deleteClientBtn) {
			String clientIdNumber = clientIdNumberField.getText(); //pernw to text pou grafei
			
			for(int i=0; i < clientList.size(); i++) {
				if(clientList.get(i).getClientIdNumber().equals(clientIdNumber)) { //elegxoume an to id pou edwse o xrhtshs yparxei sthn lista
					clientList.remove(i); //afairoume apo thn lista ayto to magazi
					tableSync();
					clearTextFields();
					break;
				}
			}

		}
		
	
			
		//an paththei to table view
		if(event.getSource() == clientTableView) {
			Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();  //pernw tin epilogi tou xrhsth
			if (selectedClient != null) { //elegxw ama exei epilexthei kapoio antikeimeno
				clientIdNumberField.setText(selectedClient.getClientIdNumber());   //bazw to onoma tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
				clientDriverLicenseNumberField.setText(selectedClient.getClientDriverLicenseNumber());
				fullClientNameField.setText(selectedClient.getFullClientName());
				clientEmailField.setText(selectedClient.getClientEmail());
				clientΑddressField.setText(selectedClient.getClientAddress());
				clientPhoneNumberField.setText(selectedClient.getClientPhoneNumber());
			
			}
		}
		
		//an paththei to search
		if(event.getSource() == searchBtn) {
            String clientIdNumber = searchField.getText();  //pernw to text apo to search
           List<Client> items = clientTableView.getItems();  //ftiaxnw mia lista kai ekxwrw ta antikeimena pou vriskontai sto tableview
            if(clientIdNumber.trim().isEmpty() != true) {
                items.clear(); //thn adeiazw
            for(Client clientObject : clientList) { //prospelaynw thn clientlist me ena antikeimeno
                if(clientObject.getClientIdNumber().equals(clientIdNumber)){
                   items.add(clientObject);       //prosthetw ayto to antikeimeno             
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
		clientIdNumberField.setText("");
		clientDriverLicenseNumberField.setText("");
		fullClientNameField.setText("");
		clientEmailField.setText("");
		clientΑddressField.setText("");
		clientPhoneNumberField.setText("");
		searchField.setText("");		
	}
	
	private void tableSync() {   //ousiastika me tin tableSync ta emfanizw sto TableView
		// TODO Auto-generated method stub
		List<Client> items = clientTableView.getItems();
		items.clear();
		for(Client clientObject : clientList) {
			if(clientObject instanceof Client) {
				items.add((Client) clientObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
			}
		}
	}

	
	
	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths client
	Scene createScene() {return new Scene(rootGridPane,width,height);}

}
