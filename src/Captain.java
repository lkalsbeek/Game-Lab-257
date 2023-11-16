
public class Captain extends NPC{
	
		public Captain() {
			super("captain","A older looking man, with a long beard. Looks to have been living on "
					+ "the submarine for a long time. He looks to be half asleep drinking some coffee");
		}
		
		private int i=1;
		
		public void talk() {
			if(i==1) {
				say("Hey! Why are you on my ship?");
				String[] options = {
					"What do you mean your ship?",
					"I'm just trying to escape this dock, you haven't seen any keys, have you?"
				};
				getResponse(options);
				i=2;
			}else if(i==2) {
				say("Why are you still here?");
				String[] options = {
						"Do you know if anyone else is around?",
						"Can I have some coffee?"
				};
				getResponse(options);
				i=1;
			}
			
		}
		
		public void response(int choice) {
			if(i==1) {
				switch(choice) {
				case 1: 
					say("It is my ship! You need to leave now, I do not like vistors.");
					break;
				case 2:
					say("There are no keys here, please leavve and stop bothering me.");
					Game.print("The captain turns around and resumes drinking his coffee.");
					break;
				}
				i=i++;
			}else if(i==2) {
				switch(choice) {
				case 1: 
					say("I have no idea, get off my boat!");
					Game.print("The captain turns around and ignores you.");
					i=1;
					break;
				case 2:
					say("You can grab some yourself, but then you need to leave.");
					Item coffee = new Item("coffee");
					coffee.setDesc("Steaming cup of coffee.");
					Game.inventory.add(coffee);
					Game.print("You take a cup of coffee off the counter and consider leaving.");
					i=0;
					break;
				}
			}
		}
		
	}
	

