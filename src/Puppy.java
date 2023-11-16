
public class Puppy extends NPC{

	public Puppy() {
		super("puppy","A hideous puppy wags his tail at you.");
	}
	
	private int i=1;
	
	public void talk() {
		if(i==1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
				"Yes you are! Who's a good boy?",
				"Uh, no. You are hideous."
			};
			getResponse(options);
			i=2;
		}else if(i==2) {
			say("Hey! Wanna play fetch?");
			String[] options = {
					"Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
			i=3;
		}else if(i==3) {
			say("Yip!");
			Game.print("The puppy wags his tail");
			i=1;
		}
		
	}
	
	public void response(int choice) {
		if(i==1) {
			switch(choice) {
			case 1: 
				say("I am!");
				break;
			case 2:
				say("Why are you so mean?");
				Game.print("The puppy bites your foot. You deserve it.");
				break;
			}
			i=i++;
		}else if(i==2) {
			switch(choice) {
			case 1: 
				say("Yay! Fetch!");
				Item ball = new Item("ball");
				ball.setDesc("Ball to play fetch with puppy.");
				Game.inventory.add(ball);
				i=1;
				break;
			case 2:
				say("You'e a bad person! I don't like you!");
				Game.print("The puppy runs away under the gate. Leaving you alone to suffer.");
				Game.getCurrentRoom().removeNPC("puppy");
				Game.getCurrentRoom().setRoomID("DOCK_DOCK_B");
				i=0;
				break;
			}
		}
	}
	
}
