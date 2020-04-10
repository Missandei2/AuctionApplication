package auction.model;

import java.util.ArrayList;
import java.util.List;

public final class Administration {
	// Singleton Pattern
	private static Administration instance;
	private Catalogue catalogue;
	// private static final int DEFAULT_DURATION = 120;
	private List<User> users = new ArrayList<>();

	private Administration() { // Privater contructor für singelton pattern. nur ein Opjekt von dieser Klasse.
		catalogue = new Catalogue();
	}

	public static Administration getInstance() { // erzeugt ein Objekt von sich selber. Test dass nur 1
		if (instance == null) // Wenn objekt schon existiert wird das zurück geben
			instance = new Administration();
		return instance;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public User login(String username, String password) {
		for (User user : users) {
			if (user.isValid(username, password))
				return user;
		}
		User user = new User(username, password);
		users.add(user);
		return user;
	}
	// public void startAuction(Item item) {
	// Auction auction = new Auction(item, DEFAULT_DURATION);
	//
	// }
	// public void showCatalogue() {
	//
	// }
}
