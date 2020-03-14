package auction.model;

import java.util.ArrayList;


public final class Catalogue {
	
	private ArrayList<Item> items;
	
	public Catalogue() {
		items = new ArrayList<Item>();
		items.add(new Item("ahljsdl", 30.00));
	}
	
	public void selectItem(Item item) {
		
	}
	public ArrayList<Item> getItem(){
		return items;
	}
}
