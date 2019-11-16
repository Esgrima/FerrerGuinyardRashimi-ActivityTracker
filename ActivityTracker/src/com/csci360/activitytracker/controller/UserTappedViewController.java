package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.settings;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UserTappedViewController implements Initializable {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private Label hour;
	@FXML 
	private Label min;
	@FXML
	private Label date;
	@FXML
	private ImageView settings;
    private Parent root;
    private Stage stage;
    int mill;
    int sec= 0;
	int t;
	
	
    /**
     * Produces the time in the format: Hours and minutes
     * @throws IOException 
     */
    public void DigitalClock(int hr,int mi) throws IOException {
   
    	final Timeline da = new Timeline(
    			
		  	      new KeyFrame(Duration.seconds(0),
		  	        new EventHandler<ActionEvent>() {
		  	    	int minn=mi;
		  	    	 int hourr=hr;
		  	          @Override public void handle(ActionEvent actionEvent) {
		  	        
		  	      					if(mill<1000) {
		  	      					mill=0;
  	      							sec++;
  	      							      								  	      							
  	      						}
		  	      						if(sec>59) {
		  	      							mill=0;
		  	      							sec=0;
		  	      							minn++;
		  	      								  	      							
		  	      						}
		  	      						if(minn>59) {
		  	      							mill=0;
		  	      							sec=0;
		  	      							minn=0;
		  	      							hourr++;
		  	      						
		  	      						}
		  	      					if(hourr>12) {
	  	      							sec=0;
	  	      							mill=0;
	  	      							minn=0;
	  	      							hourr=1;
	  	      							t++;
	  	      								  	      							
	  	      						}
		  	      						mill++;
		  	      						String m=pad(2, '0', minn + "");
		  	      						String h=pad(2, '0',hourr + "");
		  	      						min.setText(m);
		  	      						hour.setText(h);	
		  	      				
		  	          }}
		  	        
		  	      ),
		  	      new KeyFrame(Duration.seconds(1))
		  	    );
		    da.setCycleCount(Animation.INDEFINITE);
			da.play();
		}
    
    /**
     * Produces the date in the following format
     * week ,month, date, year
     */  	      
    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy ");
            date.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
	
	  /**
	  * Formats the time 
	  * @param fieldWidth
	  * @param padChar
	  * @param s
	  * @return
	  */
		private String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
          sb.append(padChar);
        }
        sb.append(s);
        return sb.toString();
      }
	 /**
     * When the user clicks either the feet or somewhere close to the hour in time, a 
     * new interface will open up
     * @throws IOException
     */
	@FXML
	private void handleAction(MouseEvent event) throws IOException {
		     //switch scene
	    stage = (Stage) hour.getScene().getWindow();
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) hour.getScene().getWindow();
        root.setLocation(MainApp.class.getResource("view/StepsView.fxml"));    
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);    
	    stage.setScene(scene);   
	    stage.show();
	}

	
	/**
	 * When the user clicks the settings image a new interface opens
	 * @throws IOException
	 */
	@FXML
	private void handleSettings(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader();
	    stage = (Stage) settings.getScene().getWindow(); 
        root.setLocation(MainApp.class.getResource("view/DataInputView.fxml"));     
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);	    
	    stage.setScene(scene);       	      
	    stage.show();
	 	         
	}
	@FXML
	private void handlecal(MouseEvent event) throws IOException {
	     //switch scene
		
	    stage = (Stage) hour.getScene().getWindow();
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) hour.getScene().getWindow();
        root.setLocation(MainApp.class.getResource("view/CaloriesView.fxml"));    
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);    
	    stage.setScene(scene);   
	    stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
				try {
					DigitalClock(0,0) ;
					initClock() ;
					//Date();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
