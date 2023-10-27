
public class Knife extends Item{

	public Knife() {
		super("knife");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("storage")) {
			if (isUsed())
				System.out.println("The box is already open.");
			else {
				System.out.println("The knife cuts open the box! You find a bottle inside!");
				Item bottle = new Item("bottle");
				bottle.setDesc("!");
				Game.getCurrentRoom().addItem(bottle);
				setUsed(true);
			}
		}else{
			System.out.println("The knife cannont be used here.");
		}
	}
	
}
