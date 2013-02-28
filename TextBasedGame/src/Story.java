import java.util.Random;

public class Story {

	private boolean dead = false;
	private boolean done = false;

	Random generator = new Random();
	//A class that will be passedd most objects and interact them all. Will work on mmakign this more efficient later
			
	public Story(Player user, SetStats stats, Equipped equipped, Combat fight) {
		Map map1 = new Map(5 ,5);
		boolean foundend = false;
		//Start quest
		System.out.println("You wake up and must go to your home town " + user.getName() + ", but first you must go through the forest.");
		
		while (!dead && !foundend) {			
			
			boolean isfight = map1.mapMenu();
			
			if (isfight){
				randCombat(user, fight, equipped);
			}
			foundend = map1.getFoundEnd();
			
		}
		System.out.println("Congrats you have escaped the forest and reached the town");
	}

	public void randCombat(Player user, Combat fight, Equipped equipped) {
		Random rand = new Random();
		if (!dead && (rand.nextInt(100) > 0)) { // 50% chance of starting combat
			dead = fight.startCombat(user);
			if (!dead) {
				fight.itemfind.startItem(user, equipped);
			}
		}
	}

}
