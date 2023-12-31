
public class Wand extends Item {

	public Wand() {
		super("wand");
	}
	
	@Override
	public void take() {
		super.take(); //Calls item's take() method
		Game.getCurrentRoom().setRoomID("DOCK_SUBMARINE_B");
	}
	
	public void use() {
		if (Game.getCurrentRoom().getName().equals("ship")) {
			Game.print("You wave the wand around and the storage "
					+ "room magically unlocks!");
			Room storage = Game.getCurrentRoom().getExit('n');
			storage.setLocked(false);
			//Game.getCurrentRoom().setRoomID("DOCK_SUBMARINE_B"); to change desc after using item
		}else if (Game.getCurrentRoom().getName().equals("dock")){
			Game.print("You wave the wand around and nothing happens");
		}else{
			Game.print("You wave the wand around and are magically transported back to the dock.");
			Room dock = World.rooms.get("dock");
			Game.setCurrentRoom(dock);
			Game.print(dock.getDescription());
		}
	}
	
}
