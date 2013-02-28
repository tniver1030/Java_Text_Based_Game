import java.io.*;

public class main {	
	@SuppressWarnings("unused")
	public static void main(String args[]) throws IOException{
		
		//TODO 
		//Save states
		//Continue Story
		//Add backpack
		//Work on spells
		//Make levels based on skills and not items only
		//Map generation
		//Make stamina go up by lvl
		//Start quests
		
		Player user = new Player();
		SetStats stats = new SetStats(user);
		Equipped equipped = new Equipped(user);		
		Combat fight = new Combat();
		user.printAllStats(user);
		equipped.whatIsEquipped(user);			
		Story storyline = new Story(user, stats, equipped, fight);
		
	}
}
