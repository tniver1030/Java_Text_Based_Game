
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Item {
	private double stmstat;
	private double agistat;
	private double intstat;
	// private int armstat;
	private int ilvl;
	private String itemslot;
	private String itemname;
	private int x = 1;
	private Scanner scan = new Scanner(System.in);

	//A class that creates new random items and chooses if you equip them or not. runs once with the beginner items.
		
	
	public Item(int inilvl, String initemslot, String iName) {

		ilvl = inilvl;
		itemslot = initemslot;
		editItem(ilvl, iName);

	}

	public void editItem(int inilvl, String iName) {
		Random generator = new Random();
		double randdec = (generator.nextDouble() / 2) + .5;
		ilvl = inilvl;
		
		if (x == 1) {	//runs once for each slot
			// Make beginner items
			itemname = iName;
			stmstat = (randdec * ilvl) + (generator.nextInt(ilvl));
			intstat = (randdec * ilvl) + (generator.nextInt(ilvl));
			agistat = (randdec * ilvl) + (generator.nextInt(ilvl));
			x++;
		} else {
			DecimalFormat df = new DecimalFormat("#.#");
			double randstm = (randdec * ilvl) + generator.nextInt(ilvl);
			double randint = (randdec * ilvl) + generator.nextInt(ilvl);
			double randagi = (randdec * ilvl) + generator.nextInt(ilvl);

			System.out.println("You just found: " + iName + " level " + ilvl);
			System.out.println("A- " + df.format(randagi) + " S- "
					+ df.format(randstm) + " I- " + df.format(randint));
			System.out
					.println("Would you like to equip this? Your currently equipped item is: (Y/N)");
			System.out.println(itemname + ": iLvl-" + ilvl + ": A-"
					+ df.format(agistat) + ": S-" + df.format(stmstat) + ": I-"
					+ df.format(intstat));			
			while (true) {
				
				String decision = scan.next();
				if (decision.equalsIgnoreCase("Y")) {
					ilvl = inilvl;
					itemname = iName;
					stmstat = randstm;
					intstat = randint;
					agistat = randagi;
					itemname = iName;
					break;
				} else if (decision.equalsIgnoreCase("N")) {
					break;
				} else {
					System.out.println("Please re-enter your choice");
				}
			}
		}
	}

	public double getStm() {
		return stmstat;
	}

	public double getAgi() {
		return agistat;
	}

	public double getInt() {
		return intstat;
	}

	public String getItemSlot() {
		return itemslot;
	}

	public int getiLvl() {
		return ilvl;
	}

	public String getName() {
		return itemname;
	}

}
