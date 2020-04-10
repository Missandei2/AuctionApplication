package auction.control;

import auction.model.Auction;
import auction.model.AuctionObserver;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseController implements AuctionObserver {
//	
//	public BaseController(Auction auction) {
//		this.auction = auction;
//		// TODO Auto-generated constructor stub
//	}

	
	
//	public void closeDialog(Scene scene) {
//		((Stage)scene.getWindow()).close();
//		auction = null;
//	}

	@Override
	public void update(Auction auction) {
		Platform.runLater(() -> handleUpdate(auction));
		
	}
	abstract void handleUpdate(Auction auction);
	
	
	
}
