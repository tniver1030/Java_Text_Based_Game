import java.io.FileNotFoundException;
import java.util.Random;

public class FindItem {
	private Random rand = new Random();
	private String tempslot;
	private String name;
	private int findchance = 50; //50% find chance
	private Mechanics mech = new Mechanics();

	public FindItem() {
		//Is run after fight to check if an item is found or not. Handles all of the equipping etc.
	}

	public boolean checkIfFound() {
		boolean found = false;

		if (rand.nextInt(100) > findchance) {
			found = true;
		}
		return found;
	}

	public void startItem(Player user, Equipped equipped) {
		if (checkIfFound()) {
			randomName();
			equipped.changeItem(tempslot, (user.getLevel() + rand.nextInt(2)),
					user, name);
		}
	}

	public void randomName() {

		randomSlot();
		try {
			name = tempslot + " of " + randomVerb();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void randomSlot() {

		tempslot = mech.getRandomString("files/ItemTypes.txt");
	}

	public String randomVerb() throws FileNotFoundException {
		String verb = mech.getRandomString("files/ItemVerbs.txt");
		return verb;
	}

}
