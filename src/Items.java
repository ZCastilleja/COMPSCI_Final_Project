
public class Items {
	
	private int health;
	private int armor;
	
	public Items() {
		health = 100;
		armor = 25;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public boolean getLucky() {
		return (int) (Math.random()*1000+1)==1;
	}

}
