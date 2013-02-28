
import java.util.Scanner;

public class Combat {
	Scanner scan = new Scanner(System.in);
	boolean dead = false;
	FindItem itemfind = new FindItem();

	public Combat() {
		//This class handles all of the combat. It is passed the user that is fighting and returns if the user died or not.
	}

	public boolean startCombat(Player user) {
		
		System.out.println("\nBegin Fight Sequence");
		Enemy enemy = new Enemy(user);	//Creates new random enemy
		PlayerCombat userfight = new PlayerCombat(user); //Gets the players stats and handles all of the damage outputs
		openingSequence(user, enemy, userfight);	//Runs original opening sequence. Tells enemies health and stats.
		combat(user, enemy, userfight);	//RUns until someone dies
		if (!dead){
			endCombat(user);	//runs if you did not die
		}		
		return dead;

	}

	private void openingSequence(Player user, Enemy enemy, PlayerCombat userfight) {
		System.out.println("You find an enemy " + enemy.getName()
				+ " who is level " + enemy.getLevel() + " has "
				+ enemy.getHealth() + " health, and does ~" + enemy.getAD()
				+ " damage.");
		System.out.println(user.getName() + ", is level " + user.getLevel()
				+ ", has " + userfight.getHealth() + " health, does ~"
				+ userfight.getAD() + " damage, and ~" + userfight.getSP()
				+ " spell damage.");
	}

	public boolean combat(Player user, Enemy enemy, PlayerCombat userfight) {
		boolean didwin = false;
		

		while ((didwin == false) && (dead == false)) {	//runs when both people are alive

			System.out
					.println("Would you like to attack or cast a spell? (A/S)");
			String ans = scan.next();
			if (ans.equalsIgnoreCase("A")) {	//Uses physical attack
				boolean enemyalive = enemy.takeDamage(userfight.getADamage(user));	//Does damage to enemy and returns if they died
				didwin = !enemyalive;	//If enemy died you win!
				if (didwin == false){	//If did not win 
					dead = userfight.takeDamge(user, enemy.attack(), enemy);	//Enemy does damage in return, checks if you die and sets that variable	
				}
			} else if (ans.equalsIgnoreCase("S")) {
				boolean enemyalive = enemy.takeDamage(userfight.getSDamage(user));
				didwin = !enemyalive;
				if (didwin == false){
					dead = userfight.takeDamge(user, enemy.attack(), enemy);
				}
			} else {
				System.out.println("Please re-enter your choice");
			}
		}

		return didwin;
	}

	public void endCombat(Player user) {	//used to increase/change your current stats
		int spelllvl = user.getSpelllvl();
		int attacklvl = user.getAttacklvl();
		user.setSpelllvl();
		user.setAttacklvl();
		if (spelllvl < user.getSpelllvl()) {
			System.out.println("Congrats your Intellect increased to: "
					+ user.getInt());
		}
		if (attacklvl < user.getAttacklvl()) {
			System.out.println("Congrats your Agility increased to: "
					+ user.getAgi());
		}

	}
	
	
}
