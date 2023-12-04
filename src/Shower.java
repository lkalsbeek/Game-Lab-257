
public class Shower extends Item {

	public Shower() {
		super("shower");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("bathroom")) {
			if(Game.getItem("goo")== null) {
				Game.print("You can't use the shower you are clean!");
			}else {
				Game.removeItem("goo");
				Game.print("You have showered and washed the goo off.");
			}
		}else{
			Game.print("There is no shower here.");
		}
	}
	
}
