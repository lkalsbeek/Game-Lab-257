import java.util.HashMap;

public class World {
	
	public static HashMap<String, Room> rooms = new HashMap<String, Room>();

	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
	Room dock = new Room("dock","DOCK_DOCK");
	Room ship = new Room("ship","DOCK_SHIP");
	Room storage = new Room("storage","SHIP_STORAGE");
	Room submarine = new Room("submarine","DOCK_SUBMARINE");
	Room gate = new Room("gate","DOCK_GATE");
	Room ocean = new Room("ocean","DOCK_OCEAN");
	Room bathroom = new Room("bathroom","SUBMARINE_BATHROOM");
	Room bedroom = new Room("bedroom","SHIP_BEDROOM");
	Room closet = new Room("closet", "SHIP_CLOSET");
	Room lounge = new Room("lounge","SUBMARINE_LOUNGE");
	
	Item crates = new Item("crates");
	crates.setDesc("Large broken crates with pieces of wood scattered about, you spot part of what"
			+ " looks like a knife.");
	Item wand = new Wand();
	wand.setDesc("Fancy wand that has magical powers, might be able to transport you from room to room");
	Item box = new Item("box");
	box.setDesc("Large taped box, seems slightly heavy can't tell if there is anything inside.");
	Item key = new Key();
	key.setDesc("small key");
	Item chest = new Item ("chest");
	chest.setDesc("Large and heavy locked chest need key to unlock.");
	Item chain = new Chain();
	chain.setDesc("Chain that is hanging from the ceiling");
	Item shower = new Shower();
	shower.setDesc("Shower that is able to run, if in need of a shower.");
	Item knife = new Knife();
	knife.setDesc("Sharp knife that could be used to open something");
	Item dresser = new Dresser();
	dresser.setDesc("Dresser with three drawers, it looks to be unlocked.");
	Item clothes = new Clothes();
	clothes.setDesc("Pile of clothing thrown about the floor.");
	
	NPC puppy = new Puppy();
	NPC captain = new Captain();
	
	//DOCK
	dock.addExit(ship, 'e');
	dock.addItem(crates);
	dock.addItem(knife);
	dock.addExit(submarine, 'n');
	dock.addExit(gate, 's');
	dock.addExit(ocean, 'w');
	crates.setHeavy(true);
	dock.addNPC(puppy);
	
	ocean.addExit(dock, 'e');
	
	//SHIP
	ship.addExit(dock, 'w');
	ship.addItem(chain);
	ship.addExit(storage, 'n');
	ship.addExit(bedroom, 's');
	
	storage.addExit(ship, 's');
	storage.addItem(box);
	storage.addItem(key);
	storage.setLocked(true);
	
	bedroom.addExit(ship, 'n');
	bedroom.addItem(dresser);
	bedroom.addExit(closet, 'e');
	dresser.setHeavy(true);
	
	closet.setLocked(true);
	closet.addExit(bedroom,'w');
	closet.addItem(clothes);
	
	//SUBMARINE
	submarine.addExit(dock, 's');
	submarine.addItem(wand);
	submarine.addItem(chest);
	submarine.addExit(bathroom, 'e');
	submarine.addExit(lounge, 'n');
	chest.setHeavy(true);
	
	lounge.addExit(submarine, 's');
	lounge.addNPC(captain);
	
	bathroom.addExit(submarine, 'w');
	bathroom.addItem(shower);
	shower.setHeavy(true);
	
	//GATE
	gate.addExit(dock, 'n');
	gate.setLocked(true);
	
	return dock;
	}
	
}
