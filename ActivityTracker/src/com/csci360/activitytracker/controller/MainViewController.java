package com.csci360.activitytracker.controller;
//import com.csci360.activitytracker.view.TappedView.fxml;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.simulator.HumanSimulationThread;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

//import java.time.Duration;
//TODO Generate time and push to view.
public class MainViewController implements Initializable  {

  @FXML
  private AnchorPane complete;
  @FXML
  private Label hour;
  @FXML
  private Label min;
  @FXML
  private ImageView image;
  private Parent root;
  private Stage stage;
  private HumanSimulationThread dailyActivities;

  // determine the starting time.


  public void DigitalClock() {

    final Timeline digitalTime = new Timeline(
        new KeyFrame(Duration.seconds(0),
            actionEvent -> {

              Calendar calendar = new GregorianCalendar();

              String hourString = pad(2, '0',
                  calendar.get(Calendar.HOUR) == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
              String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");

              hour.setText(hourString);
              min.setText(minuteString);
            }
        ),
        new KeyFrame(Duration.seconds(1))
    );
    digitalTime.setCycleCount(Animation.INDEFINITE);
    digitalTime.play();
  }
  
  
  

  private MainApp mainApp;

  private String pad(int fieldWidth, char padChar, String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length(); i < fieldWidth; i++) {
      sb.append(padChar);
    }
    sb.append(s);
    return sb.toString();
  }

  @FXML
  private void handleAction() throws IOException {
    //switch scene
    FXMLLoader root = new FXMLLoader();
    stage = (Stage) hour.getScene().getWindow();
    root.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
    complete = root.load();
    Scene scene = new Scene(complete);
    stage.setScene(scene);
    stage.show();

  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub
    //
    DigitalClock() ;
   

  }

//}


}
