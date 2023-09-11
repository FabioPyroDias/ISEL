package tp4;

public class EnemyGenerator {
	
	private String[] names = 
	{
		"Anthrax",
		"Arwap",
		"Baron",
		"Blemau",
		"Cir'Sa",
		"Cruya",
		"Drakun",
		"Dreamlu",
		"Embrine",
		"Etuyr",
		"Fang",
		"Fyr",
		"Glamber",
		"Gull",
		"Helion",
		"Hyris",
		"Indra",
		"Illoum",
		"Jor'Klaum",
		"Jultan",
		"Kallar",
		"Kruyon",
		"Lamia",
		"Letricia",
		"Maon",
		"Murtyr",
		"Nagra",
		"Nilian",
		"Otran'Lars",
		"Ourtu",
		"Palldar",
		"Pytramum",
		"Qlediba",
		"Quo'Sang",
		"Rayza",
		"Rliferyan",
		"Sanbra",
		"Sullyam",
		"Torian",
		"Tywen",
		"Ulsa",
		"Utio'Rasa",
		"Valam",
		"Vikuria",
		"Weyland",
		"Wuinlo",
		"Xerxyz",
		"Xutyr",
		"Yeloz",
		"Yrutuan",
		"Zaplad",
		"Zhooul"
	};
	
	private String[] races = 
	{
		"Abada",
		"Banshee",
		"Chimaera",
		"Drakon",
		"Er Gui",
		"Faun",
		"Ghoul",
		"Hellhound",
		"Imp",
		"Jengu",
		"Kumiho",
		"Lilin",
		"Moroi",
		"Naga",
		"Ork",
		"Poukai",
		"Qilin",
		"Re'em",
		"Satyr",
		"Tianlong",
		"Urias",
		"Vampire",
		"Wendigo",
		"Xelhua",
		"Yong",
		"Zin"
	};
	
	public Enemy generateEnemy(int level)
	{
		int health;
		int attack;
		int defense;
		float ratio;
		int minHealthValue;
		int maxHealthValue;
		int minAttackValue;
		int maxAttackValue;
		int minDefenseValue;
		int maxDefenseValue;
		
		if(level > 0 && level < 5)
		{
			ratio = level / 4;

			minHealthValue = 20;
			maxHealthValue = 70;
		
			minAttackValue = 15;
			maxAttackValue = 40;
			
			minDefenseValue = 10;
			maxDefenseValue = 40;
			
			health = (int)(ratio * Math.random()*(maxHealthValue-minHealthValue+1)+minHealthValue);
			attack = (int)(ratio * Math.random()*(maxAttackValue-minAttackValue+1)+minAttackValue);
			defense = (int)(ratio * Math.random()*(maxDefenseValue-minDefenseValue+1)+minDefenseValue);
			
			return new Enemy(names[(int)(Math.random()*(names.length))], health, attack, defense, races[(int)(Math.random()*(races.length))]);
		}
		else if(level >= 5 && level < 11)
		{
			ratio = level / 10;
			
			minHealthValue = 70;
			maxHealthValue = 200;
		
			minAttackValue = 40;
			maxAttackValue = 90;
			
			minDefenseValue = 40;
			maxDefenseValue = 70;
			
			health = (int)(ratio * Math.random()*(maxHealthValue-minHealthValue+1)+minHealthValue);
			attack = (int)(ratio * Math.random()*(maxAttackValue-minAttackValue+1)+minAttackValue);
			defense = (int)(ratio * Math.random()*(maxDefenseValue-minDefenseValue+1)+minDefenseValue);
			
			return new Enemy(names[(int)(Math.random()*(names.length))], health, attack, defense, races[(int)(Math.random()*(races.length))]);
		}
		else if(level >= 11 && level < 19)
		{
			ratio = level / 18;
			
			minHealthValue = 200;
			maxHealthValue = 500;
		
			minAttackValue = 90;
			maxAttackValue = 150;
			
			minDefenseValue = 70;
			maxDefenseValue = 100;
			
			health = (int)(ratio * Math.random()*(maxHealthValue-minHealthValue+1)+minHealthValue);
			attack = (int)(ratio * Math.random()*(maxAttackValue-minAttackValue+1)+minAttackValue);
			defense = (int)(ratio * Math.random()*(maxDefenseValue-minDefenseValue+1)+minDefenseValue);
			
			return new Enemy(names[(int)(Math.random()*(names.length))], health, attack, defense, races[(int)(Math.random()*(races.length))]);
		}
		else if(level >= 19 && level < 30)
		{
			ratio = level / 29;
			
			minHealthValue = 500;
			maxHealthValue = 1500;
		
			minAttackValue = 150;
			maxAttackValue = 300;
			
			minDefenseValue = 100;
			maxDefenseValue = 150;
			
			health = (int)(ratio * Math.random()*(maxHealthValue-minHealthValue+1)+minHealthValue);
			attack = (int)(ratio * Math.random()*(maxAttackValue-minAttackValue+1)+minAttackValue);
			defense = (int)(ratio * Math.random()*(maxDefenseValue-minDefenseValue+1)+minDefenseValue);
			
			return new Enemy(names[(int)(Math.random()*(names.length))], health, attack, defense, races[(int)(Math.random()*(races.length))]);
		}
		else if(level >= 30 && level < 45)
		{
			ratio = level / 44;
			
			minHealthValue = 1500;
			maxHealthValue = 3000;
		
			minAttackValue = 300;
			maxAttackValue = 500;
			
			minDefenseValue = 150;
			maxDefenseValue = 400;
			
			health = (int)(ratio * Math.random()*(maxHealthValue-minHealthValue+1)+minHealthValue);
			attack = (int)(ratio * Math.random()*(maxAttackValue-minAttackValue+1)+minAttackValue);
			defense = (int)(ratio * Math.random()*(maxDefenseValue-minDefenseValue+1)+minDefenseValue);
			
			return new Enemy(names[(int)(Math.random()*(names.length))], health, attack, defense, races[(int)(Math.random()*(races.length))]);
		}
		else
		{	
			return new Enemy(names[(int)(Math.random()*(names.length))], 67 * level, 11 * level, 9 * level, races[(int)(Math.random()*(races.length))]);
		}
	}
	
}