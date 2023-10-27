
public class World {

	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
	Room dock = new Room("dock","You are on a dock.There is a ship to the east, a submarine to the "
			+ "north, the ocean to the west, and a gate to the south. The dock is empty besides "
			+ "a few crates.");
	Room ship = new Room("ship","You are on the ship.The dock is to the west, there is a storage room "
			+ "to the north and a chain hanging from the cieling above the door to the storage room."
			+ " There is a door to the south leading to a bedroom.");
	Room storage = new Room("storage","You have entered the storage room. There is a box "
			+ "that taped shut. The rest of the room is musty and there is a key on the floor! "
			+ "To return to the ship head south.");
	Room submarine = new Room("submarine", "You are in the submarine. The dock is to the south. "
			+ "There is a wand on the floor. There is a large locked chest and a bathroom to "
			+ "the east");
	Room gate = new Room("gate","You are at the gate. The dock is to the north.");
	Room ocean = new Room("ocean","You fell off the dock and are in the ocean! Beware of sharks!");
	Room bathroom = new Room("bathroom","Bathroom with shower and toilet, shower looks like it works!"
			+ " Submarine is to the west.");
	Room bedroom = new Room("bedroom","The ship is to the north, there is a bed and dresser "
			+ "in the room.");
	
	Item crates = new Item("crates");
	crates.setDesc("Crate with knife inside");
	Item wand = new Wand();
	wand.setDesc("Fancy wand that has magical powers");
	Item box = new Item("box");
	box.setDesc("Large taped box with unknown contents");
	Item key = new Key();
	key.setDesc("small key");
	Item chest = new Item ("chest");
	chest.setDesc("Large and heavy locked chest");
	Item chain = new Chain();
	chain.setDesc("Chain that is hanging from the ceiling");
	Item shower = new Shower();
	shower.setDesc("Shower that is able to run, if in need of a shower.");
	Item knife = new Knife();
	knife.setDesc("Sharp knife that could be used to open something");
	Item dresser = new Dresser();
	dresser.setDesc("Dresser with three drawers, it looks to be unlocked.");
	
	dock.addExit(ship, 'e');
	dock.addItem(crates);
	dock.addItem(knife);
	dock.addExit(submarine, 'n');
	dock.addExit(gate, 's');
	dock.addExit(ocean, 'w');
	
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
	dresser.setHeavy(true);
	
	submarine.addExit(dock, 's');
	submarine.addItem(wand);
	submarine.addItem(chest);
	submarine.addExit(bathroom, 'e');
	chest.setHeavy(true);
	
	bathroom.addExit(submarine, 'w');
	bathroom.addItem(shower);
	shower.setHeavy(true);
	
	gate.addExit(dock, 'n');
	gate.setLocked(true);

	ocean.addExit(dock, 'e');
	
	return dock;
	}
	
}
