
public class Item {

	private String name;
	private String description;
	private boolean heavy;
	private boolean used;
	
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
	}
	
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public void setDesc(String description) {
		this.description = description;
	}

	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean u) {
		used = u;
	}
	
	public void look() {
		System.out.println(description);
	}
	
	public void use() {
		System.out.println("You can't use this item...yet.");
	}
	
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		return o.equals(name);
	}
}
