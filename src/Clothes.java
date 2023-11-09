
public class Clothes extends Item {

	public Clothes() {
		super("clothes");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("closet")) {
				System.out.println("You dig through the clothes and find a ring of keys");
				Item keys = new Item("keys");
				keys.setDesc("Ring of keys");
				Game.getCurrentRoom().addItem(keys);
		}else{
			System.out.println("The clothes cannont be used here.");
		}
	}

}
