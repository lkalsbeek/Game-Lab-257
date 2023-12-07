import java.io.Serializable;

public class NPC implements Serializable{

	private String name;
	private String desc;
	public static boolean convo = false;
	public static NPC npc;
	
	public NPC(String name) {
		this.name = name;
	}
	
	public NPC(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void look() {
		Game.print(desc);
	}
	
	
	public void say(String s) {
		Game.print(name+": "+s);
	}
	
	public void talk() {
		Game.print("You can't talk to "+name+".");
	}

	public void response(int object) {
		
	}
	
	/**
	 * Display options to player.
	 * Prompt player to select an option.
	 * Read player's choice.
	 * Call response method with player's choice as the parameter.
	 */
	public void getResponse(String[] options) {
		for(int i=0; i<options.length; i++) {
			Game.print("Option " +(i+1)+": "+options[i]);	
		}
		Game.print("Enter an option (1-"+options.length+"): ");
		npc = this;
		convo = true;
	}
}
