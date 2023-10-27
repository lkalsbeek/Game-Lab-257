
public class Shower extends Item {

	public Shower() {
		super("shower");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("bathroom")) {
			if(Game.getItem("goo")== null) {
				System.out.println("You can't use the shower you are clean!");
			}else {
				Game.removeItem("goo");
				System.out.println("You have showered and washed the goo off.");
			}
		}else{
			System.out.println("There is no shower here.");
		}
	}
	
}
