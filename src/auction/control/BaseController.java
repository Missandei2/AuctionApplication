package auction.control;

import auction.model.Auction;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseController {
	
	protected Auction auction;
//	
//	public BaseController(Auction auction) {
//		this.auction = auction;
//		// TODO Auto-generated constructor stub
//	}

	public Auction getAuction() {
		return auction;
	}
	
	public void closeDialog(Scene scene) {
		((Stage)scene.getWindow()).close();
		auction = null;
	}
	
	
	
}
