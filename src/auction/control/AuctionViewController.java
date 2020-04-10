package auction.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import auction.model.Auction;
import auction.model.AuctionObserver;
import auction.model.Bid;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AuctionViewController implements AuctionObserver {
	public AuctionViewController() {
	}

	@FXML
	private Button closeAuctionButton;
	@FXML
	private Button addBidderButton;
	@FXML
	private Label StatusLabel;
	@FXML
	private Label endTimeLabel;
	@FXML
	private Label remainingTimeLabel;
	@FXML
	private Label currentBidLabel;
	@FXML
	private Label titleLabel;

	public void initialize(Auction auction) {
//		this.auction = auction;
//		titleLabel.setText(auction.getItem().toString());
//		titleLabel.setText("Auction for: " + auction.getItem().toString());
	}

	// Event Listener on Button[#closeAuctionButton].onAction
	@FXML
	public void closeAuction(ActionEvent event) {
//		closeDialog(titleLabel.getScene());
	}

	// Event Listener on Button[#addBidderButton].onAction
	@FXML
	public void addBidder(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../resource/LoginView.fxml"));
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
		endTimeLabel.setText(auction.getEndTime().format(DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss")));
		Bid currentBid = auction.getCurrentBid();
		if (currentBid != null) {
			currentBidLabel.setText(currentBid.toString());
		} else {
			currentBidLabel.setText(".......");
		}

		
	}
}
