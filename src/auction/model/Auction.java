package auction.model;

import java.time.LocalTime;
import java.util.ArrayList;

public final class Auction {

	private final  Item item;
	private final ArrayList<AuctionObserver>observer = new ArrayList<>();
	
	public void addOberserver(AuctionObserver observers) {
		observer.add(observers);
	}
	
	public Auction(Item item) {
		this.item = item;
	}
	
	
	private LocalTime date;
	
}
