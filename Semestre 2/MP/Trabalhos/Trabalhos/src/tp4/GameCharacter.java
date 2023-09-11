package tp4;

public abstract class GameCharacter {
	protected String nome;
	protected int healthPoints;
	protected int attackPoints;
	protected int defensePoints;
	protected int currentHealth;
	
	public GameCharacter(String nome, int healthPoints, int attackPoints, int defensePoints)
	{
		this.nome = nome;
		this.healthPoints = healthPoints;
		this.attackPoints = attackPoints;
		this.defensePoints = defensePoints;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	public int getAttackPoints()
	{
		return attackPoints;
	}
	
	public int getDefensePoints()
	{
		return defensePoints;
	}
	
	public void setCurrentHealth(int health)
	{
		currentHealth = health;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
}
