import java.text.DecimalFormat;

public class Equipped {

	private int agil;
	private int stam;
	private int intel;
	private Item Helm = new Item(2, "Helm", "Beginner Helm");	//Starter objects, when you find new ones they overwrite these.
	private Item Chest = new Item(2, "Chest", "Beginner Chest");
	private Item Legs = new Item(2, "Legs", "Beginner Legs");
	private Item Sword = new Item(2, "Sword", "Beginner Sword");

	public Equipped(Player user) {
		setTotalEverything(user);		//A class that grabs all stats of an object and sets them to the players stats.
		
	}

	public void setTotalAgi(Player user) {
		agil = (int) Helm.getAgi() + (int) Chest.getAgi() + (int) Legs.getAgi()
				+ (int) Sword.getAgi();
		user.addAgility(agil);
	}
	public int getTotalAgi(Player user){
		agil = (int) Helm.getAgi() + (int) Chest.getAgi() + (int) Legs.getAgi()
				+ (int) Sword.getAgi();
		return agil;
	}

	public void setTotalStam(Player user) {
		stam = (int) Helm.getStm() + (int) Chest.getStm() + (int) Legs.getStm()
				+ (int) Sword.getStm();
		user.addStamina(stam);		
	}

	public void setTotalIntel(Player user) {
		intel = (int) Helm.getInt() + (int) Chest.getInt() + (int) Legs.getInt()
				+ (int) Sword.getInt();
		user.addIntellect(intel);
	}
	
	public void setiLvl(Player user){
		int avgilvl = ((Helm.getiLvl() + Chest.getiLvl() + Legs.getiLvl() + Sword.getiLvl())/4);
		user.setLevel(avgilvl);
		
	}
	
	private void setTotalEverything(Player user){	//Runs get total_skill and sets them all on the player
		setTotalIntel(user);
		setTotalStam(user);
		setTotalAgi(user);
		setiLvl(user);
	}
	
	public void changeItem(String armType, int ilvl, Player user, String iName) {	//Is passed the armor type, the ilvl of the item, the user who gets it and the name and sets the objects to equal that
		if (armType.equals("Helm")) {
			Helm.editItem(ilvl, iName);
			setTotalEverything(user);
			whatIsEquipped(user);
		}
		if (armType.equals("Chest")) {
			Chest.editItem(ilvl, iName);
			setTotalEverything(user);
			whatIsEquipped(user);
		}
		if (armType.equals("Legs")) {
			Legs.editItem(ilvl, iName);
			setTotalEverything(user);
			whatIsEquipped(user);
		}
		if (armType.equals("Sword")) {
			Sword.editItem(ilvl, iName);
			setTotalEverything(user);
			whatIsEquipped(user);
		}
	}

	public void whatIsEquipped(Player user){	//Prints out the equipped items/stats
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println("\nYour equipped items are:");
		System.out.println(Helm.getName()+":\t iLvl-"+  Helm.getiLvl()+": A:-"+df.format(Helm.getAgi())+": S-"+df.format(Helm.getStm())+": I-"+df.format(Helm.getInt()));
		System.out.println(Chest.getName()+":\t iLvl-"+  Chest.getiLvl()+": A-"+df.format(Chest.getAgi())+": S-"+df.format(Chest.getStm())+": I-"+df.format(Chest.getInt()));
		System.out.println(Legs.getName()+":\t iLvl-"+  Legs.getiLvl()+": A-"+df.format(Legs.getAgi())+": S-"+df.format(Chest.getStm())+": I-"+df.format(Legs.getInt()));
		System.out.println(Sword.getName()+":\t iLvl-"+  Sword.getiLvl()+": A-"+df.format(Sword.getAgi())+": S-"+df.format(Sword.getStm())+": I-"+df.format(Sword.getInt()));
	}
}
