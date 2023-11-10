package gui;

import java.util.ArrayList;
import java.util.List;

import core.City;
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

public class CitySceneCreator extends SceneCreator implements EventHandler<MouseEvent>{

	//Array list gia city
	public static ArrayList<City> cityList;
	
	//Array list gia to search
	ArrayList<City> searchList;
	
	//rootPane gia thn skhnh city
	GridPane rootGridPane;
	
	//flowPane gia ta koumpia ths city
	FlowPane cityButtonFlowPane;
	
	// gridPane gia ta pedia pou ekxwrei o xrhsths
	GridPane cityInputFieldsGridPane;
	
	//koumpia ths city
	Button searchBtn, newCityBtn, updateCityNameBtn, deleteCityBtn, goBackBtn, emptyBtn, viewAllBtn;
	
	//labels ths city
	Label cityNameLbl,searchLbl;
	
	//text fields ths city
	TextField cityNameField, searchField;
	
	//table view ths city
	TableView<City> cityTableView;
	
	//constructor ths city
	public CitySceneCreator(double width, double height) {
		super(width, height);
		//arxikopoihsh arralist
		cityList = new ArrayList<>();
		searchList = new ArrayList<>();
		
		//arxikopoihsh label
		cityNameLbl = new Label("City: ");
		searchLbl = new Label("City");
		
		//arxikopoihsh pane
		rootGridPane = new GridPane();
		cityButtonFlowPane = new FlowPane(searchLbl);
		cityInputFieldsGridPane = new GridPane();
		
		//arxikopoihsh koumpiwn
		searchBtn = new Button("🔎");
		newCityBtn = new Button("New City");
		updateCityNameBtn = new Button("Update");
		deleteCityBtn = new Button("Delete");
		goBackBtn = new Button("Back");		
		emptyBtn = new Button("");  //ftiaxnw ena keno (invisible) koumpi katw apo to flowPane gia na exei keno to layout mou
		viewAllBtn = new Button("View All");		
		
		//arxikopoihsh textfield
		cityNameField = new TextField();
		searchField = new TextField();
		
		//arxikopoihsh tableview
		cityTableView = new TableView<>();
		
		//setarisma flowPane
		cityButtonFlowPane.setHgap(4); 
		cityButtonFlowPane.getChildren().add(searchField);
		cityButtonFlowPane.getChildren().add(searchBtn);
		cityButtonFlowPane.getChildren().add(newCityBtn);
		cityButtonFlowPane.getChildren().add(updateCityNameBtn);
		cityButtonFlowPane.getChildren().add(deleteCityBtn);
		cityButtonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
		//setarisma gridPane
		cityInputFieldsGridPane.setAlignment(Pos.TOP_RIGHT);
		cityInputFieldsGridPane.setHgap(10);
		cityInputFieldsGridPane.setVgap(15);
		cityInputFieldsGridPane.add(cityNameLbl, 0, 1);
		cityInputFieldsGridPane.add(cityNameField, 1, 1);
		
		//setarisma rootGridPane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(cityInputFieldsGridPane,1,0);
		rootGridPane.add(cityTableView,0,0);
		rootGridPane.add(cityButtonFlowPane,0,1);
		rootGridPane.add(goBackBtn,3,1);
		rootGridPane.add(viewAllBtn, 2, 1);
		
	    //bazw keno koumpi gia na emfanizei me apostasi to flowpane apo to table view
		rootGridPane.add(emptyBtn, 0, 2);
		emptyBtn.setVisible(false);
		
		
		//setarisma Table View
		TableColumn<City,String> uniqueCodeColumn = new TableColumn<>("City Code");
		uniqueCodeColumn.setCellValueFactory(new PropertyValueFactory<>("uniqueCode"));
		cityTableView.getColumns().add(uniqueCodeColumn);
		
		TableColumn<City,String> nameColumn = new TableColumn<>("City");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		cityTableView.getColumns().add(nameColumn);
		
		
		
		//sygxronismos twn energiwn me ta koumpia kai to tableView
		searchBtn.setOnMouseClicked(this);
		newCityBtn.setOnMouseClicked(this);
		updateCityNameBtn.setOnMouseClicked(this);
		deleteCityBtn.setOnMouseClicked(this);
	    goBackBtn.setOnMouseClicked(this);
		cityTableView.setOnMouseClicked(this);
		viewAllBtn.setOnMouseClicked(this);
		
	}

	//xeirismos twn gegonotwn 
	public void handle(MouseEvent event) {

		//an paththei to koumpi back	
		if(event.getSource() == goBackBtn) {
			MainFX.mainStage.setTitle("Car Rental Service"); //alazw ton titlo ths skhnhs
			MainFX.mainStage.setScene(MainFX.mainScene); //phgainw sthn main skhnh
		}
		
		//an paththei to koumpi newCity
		if(event.getSource() == newCityBtn) {
			String name = cityNameField.getText();  //pairnw to text apo to cityNameField
			
			int flag=0;
			if(name.trim().isEmpty() != true) { //an den einai keno to text field
				for(int i=0; i < cityList.size(); i++) { //prospelaynoume thn lista me tis poleis
					if(cityList.get(i).getCityName().equals(name)) { //elegxoume an h polh pou edwse o xrhtshs yparxei sthn lista
				        flag = 1;
						break;
					}
				}
				if(flag != 1) {
				    City cityObject = new City(name); 
                    cityList.add(cityObject); //prosthetoyme to antikeimeno sthn lista 
                    tableSync();
                    clearTextFields();
				}
            }
		}
		
		//an paththei to koumpi update
		if(event.getSource() == updateCityNameBtn) {
			String name = cityNameField.getText(); //pairnw to text apo to cityNameField
			int flag=0;
			
			  if(name.trim().isEmpty() != true) {//elegxw ama den einai keno
				  for(int i=0; i < cityList.size(); i++) {//prospelaynoume thn lista me tis poleis
						if(cityList.get(i).getCityName().equals(name)) {//elegxoume an h polh pou edwse o xrhtshs yparxei sthn lista
					        flag = 1;
							break;
						}
					}	
				  
				if(flag != 1) { 
				  City selectedCity = cityTableView.getSelectionModel().getSelectedItem();  //bazw se mia metabliti(selectedCity) typou City , auto pou epileksame apo ton pinaka tableView
				  if (selectedCity != null) {
				  //bazw tin epilogh tou xrhsth sthn antistoixh thesh tou tableView pou epelekse			
				  selectedCity.setCityName(name);  //tote enhmerwnoume to pedio tou epilegmenou antikeimenou me to name
			       tableSync();	
	               clearTextFields();
			  }
				}
		  }	
		}
		
		//an paththei to koumpi delete
		if(event.getSource() == deleteCityBtn) {
			String name = cityNameField.getText(); //pernw to text pou grafei
			for(int i=0; i < cityList.size(); i++) {
				if(cityList.get(i).getCityName().equals(name)) {//elegxoume an h polh pou edwse o xrhtshs yparxei sthn lista
					cityList.remove(i);//aferoume apo thn lista ayth thn polh
					tableSync();
					clearTextFields();
					break;
				}
			}
			
			
		}
		
		//an paththei to table view
		if(event.getSource() == cityTableView) {
			City selectedCity = cityTableView.getSelectionModel().getSelectedItem();  //pernw tin epilogi tou xrhsth
			if (selectedCity != null) {//elegxw ama exei epilexthei kapoio antikeimeno
				cityNameField.setText(selectedCity.getCityName());   //bazw to onoma tou stoixeiou pou epeleksa sto textfield gia na to kanw pio grhgora update/delete ktl
			}
		}
		
		//an paththei to search
		if(event.getSource() == searchBtn) {
            String name = searchField.getText();  //pernw to text apo to search
           List<City> items = cityTableView.getItems();  //ftiaxnw mia lista kai ekxwrw ta antikeimena pou vriskontai sto tableview
            if(name.trim().isEmpty() != true) {
                items.clear(); //thn adeiazw
            for(City cityObject : cityList) {//prospelaynw thn citylist me ena antikeimeno
                if(cityObject.getCityName().equals(name)){
                   items.add(cityObject);          //prosthetw ayto to antikeimeno        
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
		//katharizw ta pedia gia epomenh kataxwrhsh
		cityNameField.setText("");
		searchField.setText("");
	}

	private void tableSync() {          //ousiastika me tin tableSync ta emfanizw sto TableView
		List<City> items = cityTableView.getItems();
		items.clear();
		for(City cityObject : cityList) {
			if(cityObject instanceof City) {
				items.add((City) cityObject);   //prosthetei stin adeia lista items ta object kai ta emfanizei ena ena
			}
		}
	}

	
	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths city
	Scene createScene() { return new Scene(rootGridPane,width,height); }

}