package auction.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Auction {
	private static final long DURATION = 1;
	private final Item item;
	private final ArrayList<AuctionObserver> observers = new ArrayList<>();
	private ItemState status;
	private LocalDateTime endTime;
	private long duration;
	private Bid currentBid;
	private List<Bid> bids = new ArrayList<>();

	public Auction(Item item) {
		this.item = item;
		this.duration = duration;
		this.status = ItemState.CREATED;
	}

	public void addOberserver(AuctionObserver observer) {
		observers.add(observer);
	}
	
	private void notifyObservers() {
		observers.forEach(o -> o.update(this));
	}

	public void start() {
		status = ItemState.RUNNING;
		endTime = LocalDateTime.now().plusMinutes(DURATION);
	}
	

	public void stop() {
		status = ItemState.TERMINATED;
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
		return bids.get(bids.size()-1);
	}

	public List<Bid> getBids() {
		return bids;
	}
}
