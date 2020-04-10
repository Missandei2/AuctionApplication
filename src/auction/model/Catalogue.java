package auction.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Catalogue {
	
	private List<Item> items = new ArrayList<>();
	
	public Catalogue() {
		items.add(new Item("Item 1", 30.00));
	}
	
	public void selectItem(Item item) {
		
	}
	public List<Item> getItem(){
	return Collections.unmodifiableList(items);
	}
}
