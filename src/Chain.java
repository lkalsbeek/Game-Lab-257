
public class Chain extends Item {

	public Chain() {
		super("chain");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("ship")) {
			Game.print("You pull the chain and goo falls from the ceiling covering "
					+ "your clothes!");
			Game.getCurrentRoom().removeItem("chain");
			Item goo = new Item("goo");
			goo.setDesc("green and slimy goo");
			Game.addItem(goo);
			Game.getCurrentRoom().setRoomID("DOCK_SHIP_B");
			setUsed(true);
		}else{
			Game.print("The chain cannot be used here.");
		}
	}
}
