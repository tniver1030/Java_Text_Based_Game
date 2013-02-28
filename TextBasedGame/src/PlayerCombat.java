import java.util.Random;


public class PlayerCombat {
	private int maxhealth;
	private int health;
	private int crit;
	private int attackdamage;
	private int spellpower;
	private double dmg;
	private double modifier;
	private Random generator = new Random();
	//private Scanner scan = new Scanner(System.in);
	private boolean dead = false;
	private Mechanics mech = new Mechanics();

	public PlayerCombat(Player user) {
		setPlayer(user);
		//Gets the players stats and handles all of the damage outputs
	}
	
	public boolean getDead(){
		return dead;
	}

	public boolean takeDamge(Player user, int damage, Enemy enemy) {
		

		health = health - damage;
		if (health <= 0) {
			health = 0;
			dead = true;
			System.err.println("Im sorry you have died");
		}
		else{
		System.out.println("The enemy " + enemy.getName() + " did " + damage
				+ " damage. You now have " + health + "/" + maxhealth
				+ " health remaining");
		}
		
		return dead;
	}

	public void setPlayer(Player user) {
		int level = user.getLevel();
		health = (int) (user.getStm() * 1.5);
		maxhealth = health;
		crit = level + generator.nextInt(level + 5);
		attackdamage = user.getAgi();
		spellpower = user.getInt();
	}

	public int getHealth() {
		return health;
	}

	public int getAD() {
		return attackdamage;
	}

	public int getSP() {
		return spellpower;
	}

	public int getADamage(Player user) {
		setPlayer(user);
		user.setAttackCt();
		System.out.println("Please enter a number 1-10");
		int roll = mech.intVerification();
		int rannum = generator.nextInt(10);
		double diff = Math.abs(roll - rannum);
		modifier = (double) Math.abs((diff - 10) / 10);
		if (roll <= 10) {
			if (generator.nextInt(100) <= crit) {
				System.err.println("Critical Hit!");
				dmg = getAD() * 2;
				dmg = (dmg * modifier);
			} else {
				dmg = getAD();
				dmg = (dmg * modifier);
			}
		} else {
			dmg = 0;
		}
		return (int) dmg;
	}

	public int getSDamage(Player user) {
		user.setSpellCt();
		System.out.println("Please enter a number 1-10");
		int roll = mech.intVerification();
		int rannum = generator.nextInt(10);
		double diff = Math.abs(roll - rannum);
		modifier = (double) Math.abs((diff - 10) / 10);
		if (roll < 10) {
			if (generator.nextInt(100) < crit) {
				dmg = getSP() * 2;
				dmg = (dmg * modifier);
			} else {
				dmg = getSP();
				dmg = (dmg * modifier);
			}
		} else {
			dmg = 0;
		}
		return (int) dmg;
	}

}
