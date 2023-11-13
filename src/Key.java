
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
					+ "the chest and find a hammer inside!");
				Item hammer = new Hammer();
				hammer.setDesc("Large hammer that could be used to break things");
				Game.getCurrentRoom().addItem(hammer);
				setUsed(true);
				Game.getCurrentRoom().setRoomID("DOCK_SUBMARINE_C");
			}
		}else{
			System.out.println("The key cannont be used here.");
		}
	}
	
}
