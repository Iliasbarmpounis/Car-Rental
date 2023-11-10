package gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;


public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	

	
	//rootflowpane
	FlowPane rootflowPane;
	
	//koumpia main skhnhs
	Button cityBtn, storeBtn, clientBtn, vehicleBtn, vehicleRentalBtn;
	
	//constructor main
	public MainSceneCreator(double width, double height) {
		super(width, height);
		
		//arxikopoihsh koumpiwn kai flowpane
		rootflowPane = new FlowPane(); 
		cityBtn = new Button("🏠 Cities");
		storeBtn = new Button("🏬 Stores");
		clientBtn = new Button("🧑‍🤝‍🧑 Clients");
		vehicleBtn = new Button("🚔 Vehicles");
		vehicleRentalBtn = new Button("💵 Vehicle Rental");
		
		//sygxronismos twn energiwn me ta koumpia
		cityBtn.setOnMouseClicked(this);
		storeBtn.setOnMouseClicked(this);
		clientBtn.setOnMouseClicked(this);
		vehicleBtn.setOnMouseClicked(this);
		vehicleRentalBtn.setOnMouseClicked(this);
		


		
		//setarisma rootflowpane
		rootflowPane.getChildren().add(cityBtn);
		rootflowPane.getChildren().add(storeBtn);
		rootflowPane.getChildren().add(clientBtn);
		rootflowPane.getChildren().add(vehicleBtn);
		rootflowPane.getChildren().add(vehicleRentalBtn);
		
		// setarisma Flow Pane
		rootflowPane.setPadding(new Insets(100, 100, 100, 100)); //allazoume to megethos tou rootflowpane 
		rootflowPane.setVgap(40);
		rootflowPane.setHgap(17);
		rootflowPane.setPrefWrapLength(200); //orizei meta apo pio simeio to epwmeno stoixeio tha allaksei seira
		rootflowPane.setAlignment(Pos.CENTER);

		//setarisma megethous koumpiwn
		cityBtn.setPrefSize(120, 80);   //(length,height)
		storeBtn.setPrefSize(120, 80);
		clientBtn.setPrefSize(120, 80);
		vehicleBtn.setPrefSize(120, 80);
		vehicleRentalBtn.setPrefSize(170, 80);
		
	}

	@Override
	public void handle(MouseEvent event) {
		
		//an paththei to city
		if(event.getSource() == cityBtn) {
			MainFX.mainStage.setTitle("City Management");
			MainFX.mainStage.setScene(MainFX.cityScene);
		}
		
		//an paththei to store
		if(event.getSource() == storeBtn) {
			MainFX.mainStage.setTitle("Store Management");
			MainFX.mainStage.setScene(MainFX.storeScene);
		}
		
		//an paththei to koumpi client
		if(event.getSource() == clientBtn) {
			MainFX.mainStage.setTitle("Client Management");
			MainFX.mainStage.setScene(MainFX.clientScene);
		}
		
		//an paththei to koumpi vehicle
		if(event.getSource() == vehicleBtn) {
			MainFX.mainStage.setTitle("Vehicle Management");
			MainFX.mainStage.setScene(MainFX.vehicleScene);
		}
		
		//an paththei to koumpi vehicleRental
		if(event.getSource() == vehicleRentalBtn) {
			MainFX.mainStage.setTitle("Vehicle Rental Management");
			MainFX.mainStage.setScene(MainFX.vehicleRentalScene);
		}
		
	}

	@Override
	//epistrefw sthn mainfx pou thn kalei thn skhnh ths main
	public Scene createScene() {return new Scene(rootflowPane,width,height);}
	

}
