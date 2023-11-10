package gui;

import javafx.scene.Scene;

public abstract class SceneCreator {
	
	//pedia pou kathwrizoun to megethos twn skhnwn
	double width;
	double height;
	
	//constructor ths SceneCreator
	public SceneCreator(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	//abstract klash pou ylopieitai ksexwrista se kathe klash
	abstract Scene createScene();

}
