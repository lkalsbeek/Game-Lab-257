
public class Hammer extends Item{

	public Hammer() {
		super("hammer");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("bedroom")) {
			if (isUsed())
				System.out.println("The closet is already open.");
			else {
				System.out.println("The hammer completley shatters the lock on the door to"
						+ " the closet. The door swings open!");
				setUsed(true);
				Game.getCurrentRoom().setRoomID("DOCK_BEDROOM_B");
				Room closet = Game.getCurrentRoom().getExit('e');
				closet.setLocked(false);
			}
		}else{
			System.out.println("The hammer cannont be used here.");
		}
	}
	
}
