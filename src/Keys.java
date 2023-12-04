
public class Keys extends Item {

	public Keys() {
		super("keys");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("dock")) {
				Game.print("You use the keys and it unlocks the gate! You can now escape!");
				Room gate = Game.getCurrentRoom().getExit('s');
				gate.setLocked(false);
				Game.getCurrentRoom().getExit('s').setRoomID("DOCK_GATE_B");
		}else{
			Game.print("The keys cannont be used here.");
		}
	}

}
