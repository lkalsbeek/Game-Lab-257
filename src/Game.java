import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private static Room currentRoom;
	private static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static Room getCurrentRoom() {
		return currentRoom;
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
		Scanner scan = new Scanner(System.in);
		String playerCommand = "a";
		String[] itemName;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		
		while(!playerCommand.equals("x")) {
			System.out.print("What do you want to do?");
			playerCommand = scan.nextLine();
			itemName = playerCommand.split(" ");
			if (playerCommand.equals("i")) {
				if(inventory.isEmpty()) {
				System.out.println("You are carrying nothing.");
				}else {
					for(Item i : inventory) {
						System.out.println(i);
					}
				}
			}else if (itemName[0].equals("take")) {
				if (currentRoom.hasItem(itemName[1])) {
					Item item = currentRoom.getItem(itemName[1]);
					if (item.isHeavy()) {
						System.out.println("That's too heavy to carry around!");
					}else if (item.getName().equals("goo")) {
						System.out.println("You can't carry goo!");
					}else {
						inventory.add(currentRoom.removeItem(itemName[1]));
						System.out.println("You pick up the "+itemName[1]);
					}
				}else {
					System.out.println("There is no "+itemName[1]+"!");
				}
			}else if (itemName[0].equals("look")) {
				Item a = getItem(itemName[1]);
				if (a != null) {
					a.look();
				}else { 
					a = currentRoom.getItem(itemName[1]);
					if (a != null) {
						a.look();
					}else {
						System.out.println("You have no "+itemName[1]+"!");
					}
				}
			}else if (itemName[0].equals("use")) {
				Item b = getItem(itemName[1]);
				if (b != null) {
					b.use();
				}else { 
					b = currentRoom.getItem(itemName[1]);
					if (b != null) {
						b.use();
					}else {
						System.out.println("You have no "+itemName[1]+"!");
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
