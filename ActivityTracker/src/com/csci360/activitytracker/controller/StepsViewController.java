package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.csci360.activitytracker.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//TODO Generate steps and push to view. Program arc to show goals.
public class StepsViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private ImageView image;
    private Parent root;
    private Stage stage;

	@FXML
	private void handleAction() throws IOException {
	    System.out.println("You clicked me!");
	  //switch scene
	    
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) image.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/CaloriesView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    stage.show();
	    
	   
	    
	    
		/*
		 * stage = (Stage) image.getScene().getWindow(); root =
		 * FXMLLoader.load(getClass().getResource("CaloriesView.fxml"));
		 * 
		 * Scene scene = new Scene(root); stage.setScene(scene); stage.show();
		 */
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
