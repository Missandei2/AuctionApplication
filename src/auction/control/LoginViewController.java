package auction.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;

import auction.model.Auction;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginViewController {
	@FXML
	private BorderPane root;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	// Event Listener on Button.onAction
	
	@FXML
	public void login(ActionEvent event) {
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../resource/BidderView.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Bidder");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void cancel(ActionEvent event) {
		
		
		 
		
	}
}
