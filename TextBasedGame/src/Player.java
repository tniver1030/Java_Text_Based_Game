/**
 * This class creates a new player and stores the stats of that player. Will be useful later
 * on for multiplayer or even for enemy generation. This class is all setters/getters
 * and the add*stat function will increase the users stats by 1. The set*skill class keeps track
 * of how often a skill (attack or spell) is used and will increase it if used often - allows players
 * to become more powerful the more they attack.
 * 
 * 
 * @version 26 September 2012
 * @author Taylor Niver
 * @author Justin Etzine
 */
public class Player {
	private String name;	
	private String charclass;
	private int[] stats = new int[3]; //Array for stats -- stats[0] = stamina, stats[1] = intellect, stats[2] = agility
	private int[] levels = new int[3]; //Array for levels -- levels[0] = overall level, levels[1] = attacklvl, levels[2] = spelllvl,
	private int attackct = 0;
	private int spellct = 0;
	
	/**
	 * The player class constructor. Holds the player's levels,
	 * stats (agility, stamina, intelligence), class, and name
	 */
	public Player() {
		
	}
	
	/**
	 * This method is for external classes to access the player's agility stat.
	 * 
	 * @return		The int value of agility
	 */
	public int getAgi(){
		//Agility
		return stats[2];
	}
	
	/**
	 * This method is for external classes to access the player's stamina stat.
	 * 
	 * @return		The int value of stamina
	 */
	public int getStm(){
		//Stamina
		return stats[0];
	}
	
	/**
	 * This method is for external classes to access the player's intellect stat.
	 * 
	 * @return		The int value of intellect
	 */
	public int getInt(){
		//Intellect
		return stats[1];
	}
	
	/**
	 * This method is for external classes to access the player's overall level.
	 * 
	 * @return		The int value of the overall level
	 */
	public int getLevel(){
		return levels[0];
	}
	
	/**
	 * This method is for external classes to access the player's name.
	 * 
	 * @return		The String value of name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method is for external classes to access the player's character class.
	 * 
	 * @return		The String value of charclass
	 */
	public String getCharClass(){
		return charclass;
	}
	
	/**
	 * This method is for external classes to access the player's attack level.
	 * 
	 * @return		The String value of levels[1]
	 */
	public int getAttacklvl(){
		return levels[1];
	}
	
	/**
	 * This method is for external classes to access the player's spell level.
	 * 
	 * @return		The String value of levels[2]
	 */
	public int getSpelllvl(){
		return levels[2];
	}
	
	/**
	 * Registers the agility stat to be set.
	 * Agility stat does...
	 * 
	 * @param agi	The calculated int to set.
	 */
	public void setAgi(int agi){
		//Agility
		stats[2] = agi;
	}
	
	/**
	 * Registers the stamina stat to be set.
	 * Stamina stat does...
	 * 
	 * @param intel	The calculated int to set.
	 */
	public void setStm(int stm){
		//Stamina
		stats[0] = stm;
	}
	
	/**
	 * Registers the intellect stat to be set.
	 * Intellect stat does...
	 * 
	 * @param intel	The calculated int to set.
	 */
	public void setInt(int intel){
		//Intellect
		stats[1] = intel;
	}
	
	/**
	 * Registers the overall level to be set.
	 * Overall level does...
	 * 
	 * @param lev	The int to set.
	 */
	public void setLevel(int lev){
		levels[0] = lev;
	}
	
	/**
	 * Registers the name the player will use.
	 * If the user does not enter a name or the name
	 * variable is null, then the name is set to 'Taylor'
	 * 
	 * Overall level does...
	 * 
	 * @param inname	The String to set.
	 */
	public void setName(String inname) {
		name = inname;
		if(inname == null || inname == "")
			name = "Taylor";
	}
	
	/**
	 * Registers the class the player will be.
	 * Classes do...
	 * 
	 * @param inclass	The String to set.
	 */
	public void setClass(String inclass) {
		charclass = inclass;
	}
	
	/**
	 * Registers the SpellCt the player will have.
	 * SpellCt does...
	 */
	public void setSpellCt(){
		spellct ++;
	}
	
	/**
	 * Registers the AttackCt the player will have.
	 * AttackCt does...
	 */
	public void setAttackCt(){
		attackct ++;
	}
	
	/**
	 * Registers the Attack Level the player will have.
	 * Attack Level dynamically increases agility the more a physical attack is used
	 */
	public void setAttacklvl(){
		if (attackct > levels[1]*5){
			levels[1]++;
			attackct = 0;
			addAgility(1);
		}

	}
	
	/**
	 * Registers the SpellCt the player will have.
	 * Spell Level dynamically increases intellect the more a spell is used
	 */
	public void setSpelllvl(){
		if (spellct > levels[2]*5){
			levels[2]++;
			spellct = 0;
			addIntellect(1);
		}
		
	}
	
	/**
	 * Adds to the stamina the player has.
	 * 
	 * @param stam	the int amount to add
	 */
	public void addStamina(int stam){
		stats[0] = stats[0]+stam;
	}
	
	/**
	 * Adds to the intellect the player has.
	 * 
	 * @param intel	the int amount to add
	 */
	public void addIntellect(int intel){
		stats[1] = stats[1]+intel;
	}
	
	/**
	 * Adds to the agility the player has.
	 * 
	 * @param agil	the int amount to add
	 */
	public void addAgility(int agil){
		stats[2] = stats[2]+agil;
	}
	
	/**
	 * Prints all the player info in a fancy table.
	 * 
	 * @param user	the Player class which has all the stats
	 */
	public void printAllStats(Player user){
		System.out.println("               Player Stats             ");
		System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("       Name: \t" + user.getName());
		System.out.println("      Level: \t" + user.getLevel());
		System.out.println("      Class: \t" + user.getCharClass());
		System.out.println("    Agility: \t" + user.getAgi());
		System.out.println("    Stamina: \t" + user.getStm());
		System.out.println("  Intellect: \t" + user.getInt());
		System.out.println("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("  Stats calculated after items have been\n  added.");
	}
}
