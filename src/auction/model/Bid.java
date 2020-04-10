package auction.model;

public class Bid {
	private final double amount;
	private final User user;

	public Bid(double amount, User user) {
		this.amount = amount;
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return amount + " by " + user.getUsername();
	}

	public User getUser() {
		return user;
	}
//	public boolean isAfter(Bid other) {
//		return false;
//	}
//	public boolean isHigher(Bid other) {
//		return false;
//	}
}
