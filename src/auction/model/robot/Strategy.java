package auction.model.robot;

import auction.model.Bid;
import auction.model.User;

public abstract class Strategy {

	abstract Bid createBid(User user, double amount);
}
