package auction.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Catalogue {
	private List<Item> items = new ArrayList<>();

	public Catalogue() {
		items.add(new Item("Bike", 30.00));
		items.add(new Item("Book", 50.00));
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
//	public void selectItem(Item item) {
//	}
}
