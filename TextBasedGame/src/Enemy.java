
import java.util.Random;


public class Enemy {
	int level;
	int attackdamage;
	int health;
	int crit;
	int maxhealth;
	String name;
	Random generator = new Random();
	private Mechanics mech = new Mechanics();
	
	public Enemy(Player user) {
		newEnemy(user);	//This class creates a new enemy. Uses getters to view enemy info.
		
		}
	public void newEnemy(Player user){	//Generates all stats and name for enemy
		level = user.getLevel();		
		level = (level - 1) + generator.nextInt(3);
		int levelvar = level*2;
		name = getRandomName();		
		health = (level *22) + generator.nextInt(levelvar);
		maxhealth = health;
		crit = level+ generator.nextInt(levelvar);
		attackdamage = level*2+ generator.nextInt(levelvar);
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int inlvl){
		level = inlvl;
	}
	
	public int getAD(){
		return attackdamage;
	}
	public void setAD(int inad){
		attackdamage = inad;
	}
	
	public int getHealth(){
		return health;
	}
	public String getRandomName(){ 
		name = mech.getRandomString("files/Enemies.txt");
		String enemytype = mech.getRandomString("files/EnemyTypes.txt");
		name = name + " " + enemytype;
		
		return name;
	}
	public String getName(){
		return name;
	}
	
	public boolean takeDamage(int indmg){
		boolean alive = true;
		health = health - indmg;
		if (health > 0){
			System.out.println("You did " + indmg + " damage and the enemy has " + health + "/" +maxhealth+" health left");
		}
		else{
			System.out.println("The enemy " + name +" has died! It took " + indmg + " damage. You rest and tend to your wounds. \n \n");
			//random item
			alive = false;
		}
		return alive;
		
	}
	
	public int attack(){
		int roll = generator.nextInt(10);
		int rannum = generator.nextInt(10);
		int diff = Math.abs(roll - rannum);
		double modifier = (double) diff / 10;
		attackdamage = (int) ((level*3+ generator.nextInt(level*10)) * (modifier*1.2));
		return attackdamage;
	}
	
	

}
