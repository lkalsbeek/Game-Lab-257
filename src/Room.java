import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {

	private String roomID;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private boolean locked; // Is the room locked?
	private String name;
	
	private HashMap<String, Item> roomItems;
	
	public Room(String n, String r) {
		name = n;
		roomID = r;
		locked = false;
		roomItems = new HashMap<String, Item>();
		World.rooms.put(name, this);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public Item getItem(String name) {
		return roomItems.get(name);
	}
	
	public Item removeItem(String name) {
		Item it = roomItems.get(name);
		roomItems.remove(name);
		return it;
		
		//return roomItems.remove(name);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public void setRoomID(String id) {
		roomID = id;
	}
	
	public String getDescription() {
		String desc = Game.roomDesc.get(roomID);
		return desc;
	}
	
	public Room getExit(char direction) {
		if (direction == 'e') {
			return east;
		}else if (direction == 'w') {
			return west;
		}else if (direction == 'n') {
			return north;
		}else if (direction == 's') {
			return south;
		}else if (direction == 'u') {
			return up;
		}else if (direction == 'd') {
			return down;
		}else {
			return null;
		}
	}
	
	public void addExit(Room r, char direction) {
		if (direction == 'e') {
			east = r;
		}else if (direction == 'w') {
			west = r;
		}else if (direction == 'n') {
			north = r;
		}else if (direction == 's') {
			south = r;
		}else if (direction == 'u') {
			up = r;
		}else{
			down = r;
		}
	}
	
	public String toString() {
		String desc = Game.roomDesc.get(roomID);
		return desc;
	}
	
	
}
