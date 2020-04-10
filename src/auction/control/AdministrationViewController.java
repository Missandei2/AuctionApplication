package auction.control;

import java.io.IOException;

import auction.model.Auction;
import auction.model.Administration;
import auction.model.Catalogue;
import auction.model.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdministrationViewController  {
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
		items.getItems().addAll(Administration.getInstance().getCatalogue().getItem());
	}

	public void startAuction() throws IOException {
		Item item = items.getSelectionModel().getSelectedItem();
		Auction auction = new Auction(item);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../resource/AuctionView.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Auction System");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		auction.start();
	}

	public void showBids() {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../resource/BidListView.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setTitle("Bids");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
