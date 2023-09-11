package tp4;

public class Player extends GameCharacter{
	
	private Item[] equippedItems = new Item[6];
	private Item[] inventoryItems = new Item[50];
	
	private int numEquippedItems = 0;
	private int numInventoryItems = 0;
	
	public Player(String nome, int healthPoints, int attackPoints, int defensePoints, Item weapon) {
		super(nome, healthPoints, attackPoints, defensePoints);
		
		placeItemInEquippedItemsAt(weapon, 0);
	}
	
	//Stats
	public int[] getModifiedStats()
	{
		int healthModified = 0;
		int attackModified = 0;
		int defenseModified = 0;
		
		for(int index = 0; index < equippedItems.length; index++)
		{
			if(equippedItems[index] != null)
			{
				healthModified += equippedItems[index].getHealthModifier();
				attackModified += equippedItems[index].getAttackModifier();
				defenseModified += equippedItems[index].getDefenseModifier();
			}
		}
		
		return new int[] {healthModified, attackModified, defenseModified};
	}
	
	//Inventory Methods
	public void placeItemInInventoryAt(Item item, int index)
	{
		if(inventoryItems[index] == null)
		{
			inventoryItems[index] = item;
			numInventoryItems ++;
			return;
		}
		
	}
		
	//Mete no primeiro índice vazio.
	public void placeItemInInvetory(Item item)
	{
		for(int index = 0; index < inventoryItems.length; index++)
		{
			if(inventoryItems[index] == null)
			{
				inventoryItems[index] = item;
				numInventoryItems++;
				return;
			}
		}
	}
	
	public Item removeItemInInventory(int index)
	{
		Item item = inventoryItems[index];
		inventoryItems[index] = null;
		
		if(item != null)
		{
			numInventoryItems--;
		}
		
		return item;
	}
	
	public Item[] getInventoryItems()
	{
		return inventoryItems.clone();
	}
	
	public void printInventoryItems()
	{
		for(int index = 0; index < inventoryItems.length; index++)
		{
			System.out.print("(" + index + ") : ");
			if(inventoryItems[index] != null)
			{
				inventoryItems[index].printItemInfo();
			}
			else
			{
				System.out.println("VAZIO");
			}
		}
	}
	
	//Equipped Items Methods
	public void placeItemInEquippedItemsAt(Item item, int index)
	{
		if(item != null)
		{
			equippedItems[index] = item;
			numEquippedItems++;
			return;
		}
	}
	
	public Item removeItemInEquippedItemsAt(int index)
	{
		Item item = equippedItems[index];
		equippedItems[index] = null;
		
		if(item != null)
		{
			numEquippedItems--;
		}
		
		return item;
	}
	
	public Item[] getEquippedItems()
	{
		return equippedItems.clone();
	}
	
	public void printEquippedItems()
	{
		for(int index = 0; index < equippedItems.length; index++)
		{
			System.out.print("(" + index + ") : ");
			if(equippedItems[index] != null)
			{
				equippedItems[index].printItemInfo();
			}
			else
			{
				System.out.println("VAZIO");
			}
		}
	}

	//Num Inventory Items
	public int getNumInventoryItems()
	{
		return numInventoryItems;
	}

	public int getNumEquippedItems()
	{
		return numEquippedItems;
	}
}