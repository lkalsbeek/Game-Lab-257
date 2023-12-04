
public class Key extends Item {

	public Key() {
		super("key");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("submarine")) {
			if (isUsed())
				Game.print("The chest is already open.");
			else {
				Game.print("The key fits into the chest! You use the key to unlock "
					+ "the chest and find a hammer inside!");
				Item hammer = new Hammer();
				hammer.setDesc("Large hammer that could be used to break things");
				Game.getCurrentRoom().addItem(hammer);
				setUsed(true);
				Game.getCurrentRoom().setRoomID("DOCK_SUBMARINE_C");
			}
		}else{
			Game.print("The key cannont be used here.");
		}
	}
	
}
