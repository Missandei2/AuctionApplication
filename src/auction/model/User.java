package auction.model;

public class User {
	private String username = "";
	private String password = "";

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public boolean isValid(String username, String password) {
		return this.username == username && this.password == password;
	}

	public String getUsername() {
		return username;
	}
	// public void bid(double amount) {
	// }
	// public void joinAuction(Auction auction) {
	// }
}
