package tp4;

public class Enemy extends GameCharacter{

	private String race;
	
	public Enemy(String nome, int healthPoints, int attackPoints, int defensePoints, String race) {
		super(nome, healthPoints, attackPoints, defensePoints);
		
		this.race = race;
	}
	
	public String getRace()
	{
		return race;
	}
}
