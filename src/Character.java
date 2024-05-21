
public class Character {
	
	private int health;
	private int strength;
	private int armor;
	private int speed;
	private int accuracy;
	private Items item;
	private int lvl;
	
	public Character(int lvl) {
		
		health = 100*lvl;
		strength = 50*lvl;
		armor = 25*lvl;
		speed = 5;
		accuracy = 10;
		this.lvl = lvl;
		item = new Items();
		
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public void takeDamage(int finalDamage) {
		if(finalDamage < 0)
			health -= 0;
		else
		health -=finalDamage;
	}
	
	public boolean isAlive() {
		return (health >0);
	}
	
	public int healthLost(int power) {
		return power-armor + (int) (Math.random()*lvl*10);
	}
	//subject to change
	public int defends() {
		return 100;
	}
	
	public void heal() {
		health +=item.getHealth()/2*lvl;
	}
	
	public void protect() {
		armor += item.getArmor()*1.5;
	}
	
	public void luck() {
		if(item.getLucky())
			strength = 1000000;
	}
	
	public int dodge() {
		return (int) (Math.random()*speed+1);
	}
	
	public void resetStrength() {
		strength = 50*lvl;
	}
	
	public void resetDefense() {
		armor = 5;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
	
}
