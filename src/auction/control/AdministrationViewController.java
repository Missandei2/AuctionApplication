package auction.control;

import auction.model.Auction;
import auction.model.Item;
import auction.model.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

	public void startAuction() {
		auction = new Auction(null);
		auctionViewController auctionController = new auctionViewController(auction);
		Main.showDialog("auctionView.fxml", "Auction for " + items.toString(), auctionController);
	}

	public void showBids() {
	}
}
