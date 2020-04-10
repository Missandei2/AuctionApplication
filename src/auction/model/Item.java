package auction.model;

public final class Item {
	private String description = "";
	private double minimum = 0.0;

	public Item(String description, double minimum) {
		this.description = description;
		this.minimum = minimum;
	}

	@Override
	public String toString() {
		return description + " " + minimum;
	}

	public double getMinimumPrice() {
		return minimum;
	}
//	public void sold() {
//	}
}
