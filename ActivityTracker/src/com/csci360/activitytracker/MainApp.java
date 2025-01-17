package com.csci360.activitytracker;

import com.csci360.activitytracker.controller.MainViewController;
import com.csci360.activitytracker.simulator.HumanSimulationThread;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private static HumanSimulationThread dailyActivities;
	// Default Constructor
	public MainApp() {
  }

	@Override
  public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Activity Tracker");

		initMainViewLayout();
		
		

	}

	public void initMainViewLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
			rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the MainView layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

			// Give MainViewController access to MainApp
			MainViewController controller = loader.getController();
//			 controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HumanSimulationThread dailyActivities = new HumanSimulationThread();
		dailyActivities.startSimulation();
	    System.out.println(Thread.currentThread().getName() + "returned");

		launch(args);


	}
}
