package auction.model.robot;

import auction.model.Bid;
import auction.model.User;

public class Eager extends Strategy {
	@Override
	Bid createBid(User user, double amount) {
		return new Bid(amount + 1, user);
		
	}
}
