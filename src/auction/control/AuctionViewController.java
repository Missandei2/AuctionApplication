package auction.control;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import auction.model.Auction;
import auction.model.AuctionObserver;
import auction.model.Bid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public final class AuctionViewController extends BaseController {
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
	
	private Auction auction;

	public void initialize(Auction auction) {
		this.auction = auction;
		this.auction.addObserver(this);
		titleLabel.setText(auction.getItem().toString());
		
	}

	// Event Listener on Button[#addBidderButton].onAction
	@FXML
	public void addBidder(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/LoginView.fxml"));
		Parent root = loader.load();
		((LoginViewController) loader.getController()).setAuction(auction);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle("Login");
		stage.show();
//			Parent root;
//			try {
//				root = FXMLLoader.load(getClass().getResource("../resource/LoginView.fxml"));
//				Scene scene = new Scene(root);
//				Stage stage = new Stage();
//				stage.setTitle("Bids");
//				stage.setScene(scene);
//				stage.show();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
	}

	// Event Listener on Button[#closeAuctionButton].onAction
	@FXML
	public void closeAuction(ActionEvent event) {
		auction.stop();
		auction.removeObserver(this);
//		((Stage)titleLabel.getScene().getWindow().close());
//		closeDialog(titleLabel.getScene());
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
		this.auction.addObserver(this);
		titleLabel.setText(auction.getItem().toString());
	}

	@Override
	void handleUpdate(Auction auction) {
		endTimeLabel.setText(auction.getEndTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
		String remainingTime = String.format("%d days, %d hours, %d minutes, %d seconds",
				auction.getRemainingTime().toDays(), auction.getRemainingTime().toHoursPart(),
				auction.getRemainingTime().toMinutesPart(), auction.getRemainingTime().toSecondsPart());
		remainingTimeLabel.setText(remainingTime);
		StatusLabel.setText(auction.getStatus().toString());
		Bid currentBid = auction.getCurrentBid();
		if (currentBid != null)
			currentBidLabel.setText(currentBid.toString());
		else
			currentBidLabel.setText("---");
	}
}
