package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

	//arxikopoihsh mainstage
	static Stage mainStage;
	
	//arxikopoihsh skhnwn
	static Scene mainScene, cityScene, storeScene, clientScene, vehicleSc`ene, vehicleRentalScene;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ekinhsh efarmoghs
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		
		//kataskeyh mainscene
		SceneCreator mainSceneCreator = new MainSceneCreator(750,400);
		mainScene = mainSceneCreator.createScene();
		
		//kataskeyh cityscene
		SceneCreator citySceneCreator = new CitySceneCreator(750,400);
		cityScene = citySceneCreator.createScene();
		
		//kataskeyh storescene
		SceneCreator storeSceneCreator = new StoreSceneCreator(750,400);
		storeScene = storeSceneCreator.createScene();
		
		//kataskeyh vehiclescene
		SceneCreator VehicleSceneCreator = new VehicleSceneCreator(1100,400);
		vehicleScene = VehicleSceneCreator.createScene();
		
		//kataskeyh Clientscene
		SceneCreator ClientSceneCreator = new ClientSceneCreator(930,400);
		clientScene = ClientSceneCreator.createScene();
		
		//kataskeyh VehicleRentalscene
		SceneCreator VehicleRentalSceneCreator = new VehicleRentalSceneCreator(1100,400);
		vehicleRentalScene = VehicleRentalSceneCreator.createScene();
				
		
		primaryStage.setTitle("Car Rental Service"); //orizw ton titlo ths arxikhs skhnhs
		primaryStage.setScene(mainScene);	
		primaryStage.show(); 	
	}

}
