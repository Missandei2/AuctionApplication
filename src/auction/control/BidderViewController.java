package auction.control;

import auction.model.Auction;
import auction.model.Bid;
import auction.model.InvalidBidException;
import auction.model.ItemState;
import auction.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public final class BidderViewController extends BaseController {
	private Auction auction;
	private User user;
	@FXML
	private Label auctionItemLabel;
	@FXML
	private Button placeBidButton;
	@FXML
	private Label messageLabel;
	@FXML
	private Button logoutButton;
	@FXML
	private TextField amountfield;

	// Event Listener on Button[#placeBidButton].onAction
	@FXML
	public void placeBid(ActionEvent event) {
		messageLabel.setText("");
		String amountStr = amountfield.getText();
		if (!amountStr.matches("\\d+(\\.\\d+)?")) {
			messageLabel.setText("Amount must be a positive number.");
			return;
		}
		double amount = Double.parseDouble(amountStr);
		Bid bid = new Bid(amount, user);
		try {
			auction.placeBid(bid);
		} catch (InvalidBidException e) {
			messageLabel.setText(e.getMessage());
			;
		}
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
		auction.addObserver(this);
		auctionItemLabel.setText(auction.getItem().toString());
		updateCurrentBidLabel();
	}

	public void setBidder(User user) {
		this.user = user;
	}

	@Override
	void handleUpdate(Auction auction) {
		if (auction.getStatus() == ItemState.RUNNING) {
			updateCurrentBidLabel();
		} else if (auction.getStatus() == ItemState.TERMINATED) {
			placeBidButton.setDisable(true);
		}
	}

	private void updateCurrentBidLabel() {
		Bid currentBid = auction.getCurrentBid();
		if (currentBid != null)
			auctionItemLabel.setText(auction.getCurrentBid().toString());
		else
			auctionItemLabel.setText("---");
	}

	// Event Listener on Button[#logoutButton].onAction
	@FXML
	public void logout(ActionEvent event) {
	}
}
