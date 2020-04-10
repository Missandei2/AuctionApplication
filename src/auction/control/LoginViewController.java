package auction.control;

import java.io.IOException;

import auction.model.Administration;
import auction.model.Auction;
import auction.model.ItemState;
import auction.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public final class LoginViewController extends BaseController {
//	@FXML
//	private BorderPane root;
	@FXML
	private TextField usernameInput;
	@FXML
	private PasswordField passwordInput;
	
//	@FXML
//	private Button login;
//	
//	@FXML
//	private Button cancel;
	
	private Auction auction;

	// Event Listener on Button.onAction
	@FXML
	public void login() throws IOException {
		if (auction.getStatus() == ItemState.RUNNING) {
			String username = usernameInput.getText();
			String password = passwordInput.getText();
			if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
				User user = Administration.getInstance().login(username, password);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/BidderView.fxml"));
				Parent root = loader.load();
				((BidderViewController) loader.getController()).setAuction(auction);
				((BidderViewController) loader.getController()).setBidder(user);
				Stage stage = new Stage();
				stage.setScene(new Scene(root));
				stage.setTitle(user.getUsername());
				stage.show();
				cancel();
			}
		} else {
			cancel();
		}
//	
//		Parent root;
//		try {
//			root = FXMLLoader.load(getClass().getResource("../resource/BidderView.fxml"));
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//			stage.setTitle("Bidder");
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void cancel() {
		auction.removeObserver(this);
		((Stage) usernameInput.getScene().getWindow()).close();
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
		auction.addObserver(this);
	}

	@Override
	void handleUpdate(Auction auction) {
		if (auction.getStatus() == ItemState.TERMINATED) {
			cancel();
		}
	}
}
