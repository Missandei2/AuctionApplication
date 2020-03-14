package auction.model;

import java.time.LocalTime;

public class Bid {
	
	private double amount = 0.0;
	private LocalTime timestamp; 
	
	public boolean isAfter(Bid other) {
		return false;
	}
	
	public boolean isHigher(Bid other) {
		return false;
	}
	
	
}
