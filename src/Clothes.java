
public class Clothes extends Item {

	public Clothes() {
		super("clothes");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("closet")) {
				Game.print("You dig through the clothes and find a ring of keys");
				Item keys = new Keys();
				keys.setDesc("Ring of keys");
				Game.getCurrentRoom().addItem(keys);
		}else{
			Game.print("The clothes cannont be used here.");
		}
	}

}
