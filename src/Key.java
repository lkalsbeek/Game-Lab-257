
public class Key extends Item {

	public Key() {
		super("key");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("submarine")) {
			if (isUsed())
				System.out.println("The chest is already open.");
			else {
				System.out.println("The key fits into the chest! You use the key to unlock "
					+ "the chest and find a diamond inside!");
				Item diamond = new Item("diamond");
				diamond.setDesc("Sparkly!");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			}
		}else{
			System.out.println("The key cannont be used here.");
		}
	}
	
}
