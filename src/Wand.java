
public class Wand extends Item {

	public Wand() {
		super("wand");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("ship")) {
			System.out.println("You wave the wand around and the storage "
					+ "room magically unlocks!");
			Room storage = Game.getCurrentRoom().getExit('n');
			storage.setLocked(false);
		}else{
			System.out.println("You wave the wand around.");
		}
	}
	
}
