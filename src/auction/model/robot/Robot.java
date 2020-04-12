package auction.model.robot;

import java.util.Random;

import auction.model.Auction;
import auction.model.Bid;
import auction.model.InvalidBidException;
import auction.model.ItemState;
import auction.model.User;

public final class Robot implements Runnable {
	private final Random random = new Random();
	private final User user;
	private final Auction auction;
	private final Strategy strategy;

	public Robot(User user, Auction auction, Strategy strategy) {
		this.user = user;
		this.auction = auction;
		this.strategy = strategy;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted() && !auction.getStatus().equals(ItemState.TERMINATED)) {
		}
		int sleepTime = (5 + random.nextInt(10)) * 1000;
		try {
			Thread.sleep(sleepTime);
			Bid currentBid = auction.getCurrentBid();
			if (!currentBid.getUser().equals(user)) {
				double lastAmount = currentBid.getAmount();
				Bid bid = strategy.createBid(user, lastAmount);
				auction.placeBid(bid);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (InvalidBidException e) {
			e.printStackTrace();
		}
	}
}
