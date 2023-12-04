
public class Dresser extends Item {

	public Dresser() {
		super("dresser");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("bedroom")) {
			if (isUsed())
				Game.print("The dresser is already open.");
			else {
				Game.print("You open the three drawers of the dresser and find "
						+ "a flashlight!");
				Item flashlight = new Item("flashlight");
				flashlight.setDesc("Flashlight that can be used in dark rooms!");
				Game.getCurrentRoom().addItem(flashlight);
				setUsed(true);
			}
		}else{
			Game.print("The dresser cannont be used here.");
		}
	}
	
}
