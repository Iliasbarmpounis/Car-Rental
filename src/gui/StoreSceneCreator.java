package gui;

import java.util.ArrayList;
import java.util.List;

import core.Store;
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

public class StoreSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	    //Array list gia store
		static ArrayList<Store> storeList;
		
		//Array list gia to search
		ArrayList<Store> searchList;
		
		//rootPane gia thn skhnh store
		GridPane rootGridPane;
		
		//flowPane gia ta koumpia ths store
		FlowPane storeButtonFlowPane;
		
		//gridPane gia ta pedia pou ekxwrei o xrhsths
		GridPane storeInputFieldsGridPane;
		
		//koumpia ths store
		Button searchBtn, newStoreBtn, updateStoreNameBtn, deleteStoreBtn, goBackBtn, emptyBtn, viewAllBtn;
		
		//labels ths store
		Label storeNameLbl, cityNameLbl, searchLbl;
		
		//text fields ths store
		TextField storeNameField, cityNameField, searchField;
		
		//table view ths store
		TableView<Store> storeTableView;
	
	//constructor ths store
	public StoreSceneCreator(double width, double height) {
		super(width, height);
		// TODO Auto-generated constructor stub
		//arxikopoihsh arralist
        storeList = new ArrayList<>();		
		searchList = new ArrayList<>();
		
		//arxikopoihsh label
		searchLbl = new Label("City");
		storeNameLbl = new Label("Store: ");
		cityNameLbl = new Label("City: ");
		
		//arxikopoihsh pane
		rootGridPane = new GridPane();
		storeButtonFlowPane = new FlowPane(searchLbl);
		storeInputFieldsGridPane = new GridPane();
		
		//arxikopoihsh koumpiwn
		searchBtn = new Button("🔎");
		newStoreBtn = new Button("New Store");
		updateStoreNameBtn = new Button("Update");
		deleteStoreBtn = new Button("Delete");
		goBackBtn = new Button("Back");		
		emptyBtn = new Button("");  //ftiaxnw ena keno (invisible) koumpi katw apo to flowPane gia na exei keno to layout mou
		viewAllBtn = new Button("View All");
				
		//arxikopoihsh textfield
		storeNameField = new TextField();
		cityNameField = new TextField();
		searchField = new TextField();
		
		//arxikopoihsh tableview
		storeTableView = new TableView<>();
		
		//setarisma flowPane
		storeButtonFlowPane.setHgap(4);
		storeButtonFlowPane.getChildren().add(searchField);
		storeButtonFlowPane.getChildren().add(searchBtn);
		storeButtonFlowPane.getChildren().add(newStoreBtn);
		storeButtonFlowPane.getChildren().add(updateStoreNameBtn);
		storeButtonFlowPane.getChildren().add(deleteStoreBtn);
		storeButtonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
				
		//setarisma gridPane
		storeInputFieldsGridPane.setAlignment(Pos.TOP_RIGHT);
		storeInputFieldsGridPane.setHgap(10);
		storeInputFieldsGridPane.setVgap(15);
		storeInputFieldsGridPane.add(storeNameLbl, 0, 1);
		storeInputFieldsGridPane.add(storeNameField, 1, 1);	
		storeInputFieldsGridPane.add(cityNameLbl, 0, 2);
		storeInputFieldsGridPane.add(cityNameField, 1, 2);	
		
		//setarisma rootGridPane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(storeInputFieldsGridPane,1,0);
		rootGridPane.add(storeTableView,0,0);
		rootGridPane.add(storeButtonFlowPane,0,1);
		rootGridPane.add(goBackBtn,3,1);
		rootGridPane.add(viewAllBtn, 2, 1);
				
	    //bazw keno koumpi gia na emfanizei me apostasi to flowpane apo to table view
		rootGridPane.add(emptyBtn, 0, 2);
		emptyBtn.setVisible(false);
				
				
		//setarisma Table View
		TableColumn<Store,String> uniqueCodeColumn = new TableColumn<>("Store Code");
		uniqueCodeColumn.setCellValueFactory(new PropertyValueFactory<>("uniqueCode"));
		storeTableView.getColumns().add(uniqueCodeColumn);
		
		TableColumn<Store,String> storeColumn = new TableColumn<>("Store");
		storeColumn.setCellValueFactory(new PropertyValueFactory<>("storeName"));
		storeTableView.getColumns().add(storeColumn);
				
		TableColumn<Store,String> cityColumn = new TableColumn<>("City");
		cityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		storeTableView.getColumns().add(cityColumn);
			
		//sygxronismos twn energiwn me ta koumpia kai to tableView
	    searchBtn.setOnMouseClicked(this);
		newStoreBtn.setOnMouseClicked(this);
		updateStoreNameBtn.setOnMouseClicked(this);
		deleteStoreBtn.setOnMouseClicked(this);
	    goBackBtn.setOnMouseClicked(this);
		storeTableView.setOnMouseClicked(this);
		viewAllBtn.setOnMouseClicked(this);
		
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
		
		//an paththei to koumpi newStore
		if(event.getSource() == newStoreBtn) {
			String cityName = cityNameField.getText();  //pairnw to text apo ta textFields
			String storeName = storeNameField.getText(); // >>
			
			int flag=0;
			if(cityName.trim().isEmpty() != true && storeName.trim().isEmpty() != true) { //an den einai keno to text field
				for(int j=0; j <  CitySceneCreator.cityList.size(); j++) { //prospelaynoume thn lista me tis poleis
				   //elegxoi gia na min bazei idia polh
				   if(CitySceneCreator.cityList.get(j).getCityName().equals(cityName))		{			
				   for(int i=0; i < storeList.size(); i++) {
					   
					   if(storeList.get(i).getStoreName().equals(storeName) && storeList.get(i).getCityName().equals(cityName)) {
				          flag = 1;
						  break;
					   }
				    }
				 				
     			 if(flag != 1) {
				    Store storeObject = new Store(storeName,cityName);
                    storeList.add(storeObject); //prosthetoyme to antikeimeno sthn lista
                    tableSync();
                    clearTextFields();
     			 }
			  }
			}
           }
		}
		
		//an paththei to koumpi update
		if(event.getSource() == updateStoreNameBtn) {
			String storeName = storeNameField.getText();  //pairnw to text apo to textField
			int flag=0;
			
			  if(storeName.trim().isEmpty() != true) {
				  for(int i=0; i < storeList.size(); i++) { //prospelaynoume thn lista me ta magazia
						if(storeList.get(i).getStoreName().equals(storeName)) { //elegxoume an to sugkekrimeno magazi pou edwse o xrhtshs yparxei sthn lista
					        flag = 1;
							break;
						}
					}	
				  
				if(flag != 1) { 
				  Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();  //bazw se mia metabliti(selectedStore) typou Store , auto pou epileksame apo ton pinaka tableView
				
				  if (selectedStore != null) {
				  //bazw tin epilogh tou xrhsth sthn antistoixh thesh tou tableView pou epelekse			
				  selectedStore.setStoreName(storeName);  //tote enhmerwnoume to pedio tou epilegmenou antikeimenou 
			      tableSync();	
	              clearTextFields();
				  }
			  }
		  }	
		}
		
		//an paththei to koumpi delete
		if(event.getSource() == deleteStoreBtn) {
			String storeName = storeNameField.getText(); //pernw to text pou grafei
			
			for(int i=0; i < storeList.size(); i++) {
				if(storeList.get(i).getStoreName().equals(storeName)) {  //elegxoume an to magazi pou edwse o xrhtshs yparxei sthn lista
					storeList.remove(i); //afairoume apo thn lista ayto to magazi
					tableSync();
					clearTextFields();
					break;
				}
			}

		}
		
		//an paththei to table view
		if(event.getSource() == storeTableView) {
			Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();  //pernw tin epilogi tou xrhsth
			if (selectedStore != null) { //elegxw ama exei epilexthei kapoio antikeimeno
				storeNameField.setText(selectedStore.getStoreName());   //bazw to onoma tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
			}
			Store selectedCity = storeTableView.getSelectionModel().getSelectedItem();  //pernw tin epilogi tou xrhsth
	        if (selectedCity != null) { //elegxw ama exei epilexthei kapoio antikeimeno
	            cityNameField.setText(selectedCity.getCityName());   //bazw to onoma tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
	        }
		}
		
		//an paththei to search
		if(event.getSource() == searchBtn) {
            String cityName = searchField.getText();  //pernw to text apo to search
           List<Store> items = storeTableView.getItems();  //ftiaxnw mia lista kai ekxwrw ta antikeimena pou vriskontai sto tableview
            if(cityName.trim().isEmpty() != true) {
                items.clear();  //thn adeiazw
            for(Store storeObject : storeList) { //prospelaynw thn storelist me ena antikeimeno
                if(storeObject.getCityName().equals(cityName)){
                   items.add(storeObject);     //prosthetw ayto to antikeimeno               
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
		storeNameField.setText("");
		searchField.setText("");
		cityNameField.setText("");
		
	}



	private void tableSync() { //ousiastika me tin tableSync ta emfanizw sto TableView
		// TODO Auto-generated method stub
		List<Store> items = storeTableView.getItems();
		items.clear();
		for(Store storeObject : storeList) {
			if(storeObject instanceof Store) {
				items.add((Store) storeObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
			}
		}
	}
	



	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths store
	Scene createScene()  { return new Scene(rootGridPane,width,height); }
	

}
