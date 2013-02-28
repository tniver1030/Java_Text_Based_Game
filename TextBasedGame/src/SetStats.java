/**
 * This class runs once when the player is created and sets all of the stats for the user. It interacts
 * with the Player class, and edits the user object. This class should only run once.
 * 
 * @version 26 September 2012
 * @author Taylor Niver
 * @author Justin Etzine
 */

import java.util.*;
import java.io.*;

public class SetStats {

	int[] start = new int[3]; //Array for start values = start[0] = startstm, start[1] = startint, start[2] = startagi

	private int ct = 1;
	boolean valid = false;
	private Mechanics mech = new Mechanics();

	private int totpoints = 25;
	
	public SetStats(Player user) throws IOException {
		int remainingP = 25;
		int oldval = 25;
		boolean ck = true;
		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter your characters name: \n");
		String name = scan.next();
		boolean exists = (new File(System.getenv("APPDATA") + "/TextAdventure/saves/" + name + ".player")).exists();
		if(exists) {
			exists(user, name);
		}
		else {
			user.setName(name);
			String cclass;
			while (true) {
				System.out.print("What class would you like to play? (Warrior, Rogue, Mage)\n");
				cclass = scan.next();

				// Check warrior, mage, rogue -> return set stats;
				
				if (cclass.equalsIgnoreCase("Rogue")) {
					user.setClass("Rogue");	
					break;
				}
				else if (cclass.equalsIgnoreCase("Warrior")) {
					user.setClass("Warrior");
					break;
				}
				else if (cclass.equalsIgnoreCase("Mage")) {
					user.setClass("Mage");
					break;
				}
				else {
					System.out.println("Please re-enter your choice.");
				}
			}
			CharClasses charclass = new CharClasses(cclass);
			start[1] = charclass.getStartInt();
			start[2] = charclass.getStartAgi();
			start[0] = charclass.getStartStm();
			
			System.out.println("Please allocate your skill points (25 total)");
			
			while ((oldval == remainingP) && (ct == 1)) {
				
			System.out.print("Stamina-(" + remainingP + " remaining):");
			
			int instam = mech.intVerification();
			
			remainingP = setSkills("stm", instam, user);
			if (instam == 0) {
				remainingP--;
				ck = false;
			}
			if (remainingP == oldval) {
				System.out.println("Please re-enter a number, you have "
						+ remainingP + " points left");
			}
		}
		ct++;
		if (remainingP < 0) {
			remainingP = 0;
			oldval = remainingP;
		}
		if (!ck) {
			remainingP++;
			oldval = remainingP;
			ck = true;
		}
		oldval = remainingP;
		while ((oldval == remainingP) && (ct == 2)) {
			oldval = remainingP;
			System.out.print("Agility-(" + remainingP + " remaining):");
			int inagil = mech.intVerification();
			
			remainingP = setSkills("agi", inagil, user);
			if (inagil == 0) {
				remainingP--;
				ck = false;
			}
			if (remainingP == oldval) {
				System.out.println("Please re-enter a number, you have "
						+ remainingP + " points left");
			}
		}
		oldval = remainingP;
		ct++;
		if (!ck) {
			remainingP++;
			oldval = remainingP;
			ck = true;
		}
		if (remainingP < 0) {
			remainingP = 0;
			oldval = remainingP;
		}

		while ((oldval == remainingP) && (ct == 3)) {
			oldval = remainingP;
			System.out.print("Intellect-(" + remainingP + " remaining):");
			int inint = mech.intVerification();
			remainingP = setSkills("int", inint, user);
			if (inint == 0) {
				remainingP--;
			}
			if (remainingP == oldval) {
				System.out.println("Please re-enter a number, you have " + remainingP + " points left");
			}

		}
		}
		printStats(user);
	}

	public void printStats(Player user){
		System.out.println("               Player Stats             ");
		System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("       Name: \t" + user.getName());
		System.out.println("      Level: \t" + user.getLevel());
		System.out.println("      Class: \t" + user.getCharClass());
		System.out.println("    Agility: \t" + user.getAgi());
		System.out.println("    Stamina: \t" + user.getStm());
		System.out.println("  Intellect: \t" + user.getInt());
		System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void exists(Player user, String name) {
		//WORK IN PROGRESS
		
		//If the character has played before, then...
		SaveState state = new SaveState();
		state.load(name);
		String cclass = state.getClassType();
		
		user.setClass(cclass);
		
		//Okay so just use state.get_____(); to get all the values.
	}
	
	public int setSkills(String ability, int value, Player user) {

		totpoints -= value;

		if (totpoints >= 0) {
			if (ability.equals("stm")) {
				if (totpoints >= 0) {
					user.setStm(value + start[0]);
				} else {
					valid = true;
				}
			} else if (ability.equals("agi")) {
				if (totpoints >= 0) {
					user.setAgi(value + start[2]);
				} else {
					valid = true;
				}
			} else {
				if (totpoints >= 0) {
					user.setInt(value + start[1]);
				} else {
					valid = true;
				}

			}
		} else {
			totpoints += value;
		}

		return totpoints;
	}

}
