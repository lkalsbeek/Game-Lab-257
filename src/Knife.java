
public class Knife extends Item{

	public Knife() {
		super("knife");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("storage")) {
			if (isUsed())
				Game.print("The box is already open.");
			else {
				Game.print("The knife cuts open the box! You find a bottle inside!");
				Item bottle = new Item("bottle");
				bottle.setDesc("There looks to be a note inside. Need to investigate more.");
				Game.getCurrentRoom().addItem(bottle);
				setUsed(true);
			}
		}else{
			Game.print("The knife cannont be used here.");
		}
	}
	
}
