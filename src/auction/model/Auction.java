package auction.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Auction {
	private class Ticker extends Thread {
		@Override
		public void run() {
			while (!Auction.this.getRemainingTime().isNegative() && !isInterrupted()) {
				try {
					Thread.sleep(1000);
					notifyObservers();
				} catch (InterruptedException e) {
					interrupt();
				}
			}
			status = ItemState.TERMINATED;
			notifyObservers();
		}
	}

	private static final long DURATION = 1;
	private final Item item;
	private ItemState status;
	private LocalDateTime endTime;
	private long duration;
	private Bid currentBid;
	private List<Bid> bids = new ArrayList<>();
	private final ArrayList<AuctionObserver> observers = new ArrayList<>();
	private final Ticker ticker = new Ticker();

	public Auction(Item item) {
		this.item = item;
		this.duration = duration;
		this.status = ItemState.CREATED;
	}

	public void addObserver(AuctionObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(AuctionObserver observer) {
		observers.remove(observer);
	}

	private void notifyObservers() {
		List<AuctionObserver> copy = new ArrayList<>(observers);
		copy.forEach(o -> o.update(this));
	}

	public void start() {
		status = ItemState.RUNNING;
		endTime = LocalDateTime.now().plusMinutes(DURATION);
		ticker.start();
		notifyObservers();
	}

	public void stop() {
		ticker.interrupt();
		status = ItemState.TERMINATED;
		notifyObservers();
	}

	public Item getItem() {
		return item;
	}

	public Duration getRemainingTime() {
		return Duration.between(LocalDateTime.now(), endTime);
	}

	public ItemState getStatus() {
		return status;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public long getDuration() {
		return duration;
	}

	public Bid getCurrentBid() {
		if (bids.size() > 0)
			return bids.get(bids.size() - 1);
		else
			return null;
	}

	public void placeBid(Bid bid) throws InvalidBidException {
		Bid current = getCurrentBid();
		if (currentBid == null) {
			if (bid.getAmount() < item.getMinimumPrice()) {
				throw new InvalidBidException("Amount must be equal or higher than minimum price.");
			}
		} else {
			if (bid.getAmount() <= current.getAmount()) {
				throw new InvalidBidException("Amount must be higher than current bid.");
			}
		}
		bids.add(bid);
		notifyObservers();
	}
}
