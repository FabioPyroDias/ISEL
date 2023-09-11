package tp4;

public class ItemGenerator {
	
	public Item generateItem()
	{
		String rarity = generateRarity();
		String type = generateType();
		
		int healthModifier = generateHealthModifier(rarity, type);
		int attackModifier = generateAttackModifier(rarity, type);
		int defenseModifier = generateDefenseModifier(rarity, type);
		
		return new Item(generateName(rarity, type), rarity, type, healthModifier, attackModifier, defenseModifier);
	}
	
	private String generateRarity()
	{
		String[] rarity = {"Common", "Uncommon", "Rare", "Legendary"};
		int maxValue = 3;
		int minValue = 0;
		
		return rarity[(int)(Math.random()*(maxValue-minValue+1)+minValue)];
	}
	
	private String generateType()
	{
		String[] type = {"Weapon", "Helmet", "Armor", "Pants", "Gloves", "Boots"};
		int maxValue = 5;
		int minValue = 0;
		
		return type[(int)(Math.random()*(maxValue-minValue+1)+minValue)];
	}
	
	private String generateName(String rarity, String type)
	{
		//Por fazer. Pode envolver um ficheiro com nomes
		
		return type + " Equipamento";
	}
	
	private int generateHealthModifier(String rarity, String type)
	{
		int maxValue = 0;
		int minValue = 0;
		
		switch(rarity)
		{
			case "Common":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						break;
						
					case "Helmet":
						maxValue = 50;
						minValue = 20;
						
						break;
						
					case "Armor":
						maxValue = 80;
						minValue = 30;
						
						break;
						
					case "Pants":
						maxValue = 50;
						minValue = 10;
						
						break;
					
					case "Gloves":
						maxValue = 40;
						minValue = 10;
						
						break;
						
					case "Boots":
						maxValue = 40;
						minValue = 10;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Uncommon":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Helmet":
						maxValue = 90;
						minValue = 60;
						
						break;
						
					case "Armor":
						maxValue = 200;
						minValue = 100;
						
						break;
						
					case "Pants":
						maxValue = 100;
						minValue = 60;
						
						break;
					
					case "Gloves":
						maxValue = 80;
						minValue = 50;
						
						break;
						
					case "Boots":
						maxValue = 80;
						minValue = 50;
						
						break;
						
					default:
						break;	
				}
				
				break;
				
			case "Rare":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Helmet":
						maxValue = 180;
						minValue = 100;
						
						break;
						
					case "Armor":
						maxValue = 500;
						minValue = 300;
						
						break;
						
					case "Pants":
						maxValue = 200;
						minValue = 120;
						
						break;
					
					case "Gloves":
						maxValue = 150;
						minValue = 100;
						
						break;
						
					case "Boots":
						maxValue = 150;
						minValue = 100;
						
						break;
						
					default:
						break;	
				}
				
				break;
				
			case "Legendary":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Helmet":
						maxValue = 400;
						minValue = 200;
						
						break;
						
					case "Armor":
						maxValue = 1000;
						minValue = 700;
						
						break;
						
					case "Pants":
						maxValue = 400;
						minValue = 300;
						
						break;
					
					case "Gloves":
						maxValue = 300;
						minValue = 200;
						
						break;
						
					case "Boots":
						maxValue = 300;
						minValue = 200;
						
						break;
						
					default:
						break;	
				}
				
				break;
				
			default:
				break;
		}
		
		return (int)(Math.random()*(maxValue-minValue+1)+minValue);
	}
	
	private int generateAttackModifier(String rarity, String type)
	{
		int maxValue = 0;
		int minValue = 0;
		
		switch(rarity)
		{
			case "Common":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 50;
						minValue = 20;
						break;
						
					case "Helmet":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Armor":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Pants":
						maxValue = 0;
						minValue = 0;
						
						break;
					
					case "Gloves":
						maxValue = 20;
						minValue = 10;
						
						break;
						
					case "Boots":
						maxValue = 20;
						minValue = 10;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Uncommon":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 100;
						minValue = 60;
						break;
						
					case "Helmet":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Armor":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Pants":
						maxValue = 0;
						minValue = 0;
						
						break;
					
					case "Gloves":
						maxValue = 50;
						minValue = 30;
						
						break;
						
					case "Boots":
						maxValue = 50;
						minValue = 30;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Rare":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 300;
						minValue = 150;
						break;
						
					case "Helmet":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Armor":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Pants":
						maxValue = 0;
						minValue = 0;
						
						break;
					
					case "Gloves":
						maxValue = 100;
						minValue = 70;
						
						break;
						
					case "Boots":
						maxValue = 100;
						minValue = 70;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Legendary":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 700;
						minValue = 400;
						break;
						
					case "Helmet":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Armor":
						maxValue = 0;
						minValue = 0;
						
						break;
						
					case "Pants":
						maxValue = 0;
						minValue = 0;
						
						break;
					
					case "Gloves":
						maxValue = 180;
						minValue = 120;
						
						break;
						
					case "Boots":
						maxValue = 180;
						minValue = 120;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			default:
				break;
		}
		
		return (int)(Math.random()*(maxValue-minValue+1)+minValue);
	}
	
	private int generateDefenseModifier(String rarity, String type)
	{
		int maxValue = 0;
		int minValue = 0;
		
		switch(rarity)
		{
			case "Common":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						break;
						
					case "Helmet":
						maxValue = 20;
						minValue = 10;
						
						break;
						
					case "Armor":
						maxValue = 30;
						minValue = 10;
						
						break;
						
					case "Pants":
						maxValue = 20;
						minValue = 10;
						
						break;
					
					case "Gloves":
						maxValue = 10;
						minValue = 5;
						
						break;
						
					case "Boots":
						maxValue = 10;
						minValue = 5;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Uncommon":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						break;
						
					case "Helmet":
						maxValue = 50;
						minValue = 30;
						
						break;
						
					case "Armor":
						maxValue = 80;
						minValue = 40;
						
						break;
						
					case "Pants":
						maxValue = 50;
						minValue = 30;
						
						break;
					
					case "Gloves":
						maxValue = 30;
						minValue = 15;
						
						break;
						
					case "Boots":
						maxValue = 30;
						minValue = 15;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Rare":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						break;
						
					case "Helmet":
						maxValue = 90;
						minValue = 60;
						
						break;
						
					case "Armor":
						maxValue = 150;
						minValue = 100;
						
						break;
						
					case "Pants":
						maxValue = 90;
						minValue = 60;
						
						break;
					
					case "Gloves":
						maxValue = 70;
						minValue = 40;
						
						break;
						
					case "Boots":
						maxValue = 70;
						minValue = 40;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			case "Legendary":
				
				switch(type)
				{
					case "Weapon":
						maxValue = 0;
						minValue = 0;
						break;
						
					case "Helmet":
						maxValue = 150;
						minValue = 100;
						
						break;
						
					case "Armor":
						maxValue = 300;
						minValue = 180;
						
						break;
						
					case "Pants":
						maxValue = 150;
						minValue = 100;
						
						break;
					
					case "Gloves":
						maxValue = 150;
						minValue = 80;
						
						break;
						
					case "Boots":
						maxValue = 150;
						minValue = 80;
						
						break;
							
					default:
						break;	
				}
				
				break;
				
			default:
				break;
		}
		
		return (int)(Math.random()*(maxValue-minValue+1)+minValue);
	}
}