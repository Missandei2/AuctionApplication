package auction.control;

import java.io.IOException;

import auction.model.Auction;
import auction.model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdministrationViewController {
	
	private Auction auction;
	@FXML
	private Button startAuctionButton;
	@FXML
	private Button showBidsButton;
	@FXML
	private Button exit;
	@FXML
	private ListView<Item> items;
	
	public void initialize() {
		
	}

	public void startAuction() {
		//showBidsButton.setDisable(true);

		auction = new Auction(null);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../resource/auctionView.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Auction System");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void showBids() {
		
	}
}
