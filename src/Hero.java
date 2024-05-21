
public class Hero extends Character{

	private String  name;
	
	public Hero(int lvl) {
		super(lvl);
		name = "Test Hero";
	}
	
	public String toStirng() {
		return  name;
	}
	
}
