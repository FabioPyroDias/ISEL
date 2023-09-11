package tp4;

public class Item {
	private String nome;
	private String rarity;
	private String type;
	private int healthModifier;
	private int attackModifier;
	private int defenseModifier;
	
	public Item(String nome, String rarity, String type, int healthModifier, int attackModifier, int defenseModifier)
	{
		this.nome = nome;
		this.rarity = rarity;
		this.type = type;
		this.healthModifier = healthModifier;
		this.attackModifier = attackModifier;
		this.defenseModifier = defenseModifier;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public String getRarity()
	{
		return rarity;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getHealthModifier()
	{
		return healthModifier;
	}
	
	public int getAttackModifier()
	{
		return attackModifier;
	}
	
	public int getDefenseModifier()
	{
		return defenseModifier;
	}
	
	public void printItemInfo()
	{
		System.out.println("[" + getType() + "] " + getRarity() + ": " + getNome() + " | HP: " + getHealthModifier() + ", ATK: " + getAttackModifier() + ", DEF: " + getDefenseModifier());
	}
}