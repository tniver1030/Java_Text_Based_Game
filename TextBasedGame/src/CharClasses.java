import java.util.*;

public class CharClasses {	//USed to store unique values for each class. Runs once when player is created and sets the player stats accordingly
	
	Random generator = new Random();
	
	private int startStm; //Stamina
	private int startAgi; //Agility
	private int startInt; //Intelligence
	
	public CharClasses(String cclass) {
		if (cclass.equalsIgnoreCase("warrior")){
			Warrior();
		}
		else if (cclass.equalsIgnoreCase("rogue")){
			Rogue();
		}
		else{
			Mage();
		}
	}

	public void Warrior() {
		startStm = 17 + generator.nextInt(3);
		startAgi= 9 + generator.nextInt(3);
		startInt = 5 + generator.nextInt(3);
		
	}

	public void Rogue() {
		startStm = 8 + generator.nextInt(3);
		startAgi= 16 + generator.nextInt(3);
		startInt = 8 + generator.nextInt(3);

	}

	public void Mage() {
		startStm = 7 + generator.nextInt(3);
		startAgi= 3 + generator.nextInt(3);
		startInt = 17 + generator.nextInt(3);

	}
	
	public int getStartStm(){
		return startStm;		
	}
	public int getStartAgi(){
		return startAgi;		
	}
	public int getStartInt(){
		return startInt;		
	}
}
