package auction.model;

public final class Administration {
	private static Administration instance;
	
	private Catalogue catalogue;
	
	private Administration() { // Privater contructor für singelton pattern. nur ein Opjekt von dieser Klasse. 
		catalogue = new Catalogue();
		
	}
	
	public static Administration getInstance() { //erzeugt ein Objekt von sich selber. Test dass nur 1
		if (instance == null) { 	//Wenn objekt schon existiert wird das zurück geben
			instance = new Administration();
			return instance;
		}
		return instance; 
	}
	
	public void startAuction(Item item) {
		
	}
	
	public User login(User user) {
		return user;
	}
	
	public void showCatalogue() {
		
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}
	
	
}
