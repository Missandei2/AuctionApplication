package auction.control;

import java.io.IOException;
import java.util.List;

import auction.model.Administration;
import auction.model.Auction;
import auction.model.AuctionObserver;
import auction.model.Item;
import auction.model.ItemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdministrationViewController implements AuctionObserver {
	@FXML
	private Button startAuctionButton;
	@FXML
	private Button showBidsButton;
	@FXML
	private ListView<Item> items;

	public void initialize() {
		List<Item> list = Administration.getInstance().getCatalogue().getItems();
		items.getItems().addAll(list);
		items.getSelectionModel().clearAndSelect(0);
	}
//		items.getItems().addAll(Administration.getInstance().getCatalogue().getItem());
//		items.getSelectionModel().select(0);
//	}

	@FXML
	public void startAuction() throws IOException {
		startAuctionButton.setDisable(true);
		Item item = items.getSelectionModel().getSelectedItem();
		Auction auction = new Auction(item);
		auction.addObserver(this);
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/AuctionView.fxml"));
		Parent root = loader.load();
		((AuctionViewController) loader.getController()).setAuction(auction);
		stage.setScene(new Scene(root));
		stage.setTitle("Auction");
		stage.show();
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("../resource/AuctionView.fxml"));
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//			stage.setTitle("Auction System");
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		auction.start();
	}

	@FXML
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

	@Override
	public void update(Auction auction) {
		if (auction.getStatus() == ItemState.TERMINATED) {
			startAuctionButton.setDisable(false);
			auction.removeObserver(this);
		}
	}
}
