
public class Chain extends Item {

	public Chain() {
		super("chain");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("ship")) {
			System.out.println("You pull the chain and goo falls from the ceiling covering "
					+ "your clothes!");
			Game.getCurrentRoom().removeItem("chain");
			Item goo = new Item("goo");
			goo.setDesc("green and slimy goo");
			Game.addItem(goo);
			setUsed(true);
		}else{
			System.out.println("The chain cannot be used here.");
		}
	}
}
