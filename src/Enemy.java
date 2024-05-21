
public class Enemy extends Character{
	private String name;
	//add random name generator?
	
	public Enemy(int lvl, String name) {
		super(lvl);
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	
	
}
