import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, String> roomDesc = new HashMap<String, String>();
	public static Scanner scan = new Scanner(System.in);
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public static void saveGame() {
		try {
			File saveFile = new File("save");
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
		} catch (IOException e) {
			print("ERROR: Cannot save file.");
			e.printStackTrace();
		}
	}
	
	public static void loadGame() {
		ObjectInputStream stream;
		try {
			stream = new ObjectInputStream(new FileInputStream(new File("save")));
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList<Item>) stream.readObject();
			World.rooms = (HashMap<String, Room>) stream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void populateMap() {
		try {
			Scanner scan = new Scanner(new File("rooms.txt"));
			while(scan.hasNextLine()) {
				String roomID = scan.nextLine();
				String desc = "";
				String line = scan.nextLine();
				while(!line.equals("#")) {
					desc = desc + line;
					line = scan.nextLine();
				}
				roomDesc.put(roomID, desc);
			}
		}catch(FileNotFoundException ex){
			System.out.println("File not found.");
		}
	}
	
	public static void move(String playerCommand) {
		Room nextRoom = currentRoom.getExit(playerCommand.charAt(0)); 
		if (nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked!");
			}else {
				currentRoom = nextRoom;
				System.out.println(currentRoom);
			}
		}else {
			System.out.println("You can't go that way!");
		}
	}
	
	public static Item getItem(String name) {
		for(Item i : inventory) {
			if(i.getName().equals(name)) {
				return i;
			}
		} return null;
	}
	
	public static Item removeItem(String name) {
		Item it = getItem(name);
		inventory.remove(it);
		return it;
	}
	
	public static void addItem(Item name) {
		inventory.add(name);
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
		}
	
	public static void main(String[] args) { 
		Game.populateMap();
		String playerCommand = "a";
		String[] words;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		
		while(!playerCommand.equals("x")) {
			System.out.print("What do you want to do?");
			playerCommand = scan.nextLine();
			words = playerCommand.split(" ");
			if (playerCommand.equals("i")) {
				if(inventory.isEmpty()) {
				System.out.println("You are carrying nothing.");
				}else {
					for(Item i : inventory) {
						System.out.println(i);
					}
				}
			}else if (words[0].equals("talk")) {
				NPC npc = currentRoom.getNPC(words[1]);
				npc.talk();
			}else if (words[0].equals("take")) {
				if (currentRoom.hasItem(words[1])) {
					Item item = currentRoom.getItem(words[1]);
					item.take();
				}else {
					System.out.println("There is no "+words[1]+"!");
				}
			}else if (words[0].equals("look")) {
				Item a = getItem(words[1]);
				if (a != null) {
					a.look();
				}else { 
					a = currentRoom.getItem(words[1]);
					NPC b = currentRoom.getNPC(words[1]);
					if (a != null) {
						a.look();
					}else if (b!=null){
						b.look();
					}else {
						System.out.println("You have no "+words[1]+"!");
					}
				}
			}else if (words[0].equals("use")) {
				Item b = getItem(words[1]);
				if (b != null) {
					b.use();
				}else { 
					b = currentRoom.getItem(words[1]);
					if (b != null) {
						b.use();
					}else {
						System.out.println("You have no "+words[1]+"!");
					}
				}
			}else if (playerCommand.equals("e")) {
				move(playerCommand);
			}else if (playerCommand.equals("w")) {
				move(playerCommand);
			}else if (playerCommand.equals("n")) {
				move(playerCommand);
			}else if (playerCommand.equals("s")) {
				move(playerCommand);
			}else if (playerCommand.equals("u")) {
				move(playerCommand);
			}else if (playerCommand.equals("d")) {
				move(playerCommand);
			}else if (playerCommand.equals("x")) {
				System.out.println("Okay. Bye!");
			}else if(playerCommand.equals("save")){
				saveGame();
			}else if(playerCommand.equals("load")){
				loadGame();
				System.out.println(currentRoom);
			}else {
				System.out.println("Invalid command.");
			}
		} 
		scan.close();
	}

}


//else if(itemName[1].equals("goo")){
//	Item b = getItem(itemName[1]);
//	b.look();
