import java.io.*;
import java.util.*;

public class SaveState {
	private String pName, pClass;
	private int stm, agi, itl, pLevel;
	private ArrayList<String> pItems;
	private PrintWriter saveFile;
	private Scanner loadFile;
	public SaveState() {}
	public void save(Player user) throws IOException {
		//Saves to a file with the same name as the character
		saveFile = new PrintWriter(System.getenv("APPDATA") + "/TextAdventure/saves/" + name + ".player");
		
		//Prints: name, class, stats, level, and items
		saveFile.println(user.getName());
		saveFile.println(user.getCharClass());
		
		saveFile.println(user.getStm());
		saveFile.println(user.getInt());
		saveFile.println(user.getAgi());
		
		saveFile.println(user.getLevel());
		saveFile.println(user.getAttacklvl());
		saveFile.println(user.getSpelllvl());
		
		/*for(int x = 0; x < items.size(); x++) {
			saveFile.println(items.get(x));
		}*/
		
		//Closes the file.
		saveFile.close();
	}
	
	public void load(String name) {
		try {
			loadFile = new Scanner(new File(System.getenv("APPDATA") + "/TextAdventure/saves/" + name + ".player"));
			pName = loadFile.nextLine();
			pClass = loadFile.nextLine();
			stm = loadFile.nextInt();
			itl = loadFile.nextInt();
			agi = loadFile.nextInt();
			
			pLevel = loadFile.nextInt();
			
			pItems = new ArrayList<String>(0);
			while(loadFile.hasNext()) {
				pItems.add(loadFile.nextLine());
			}
			
		} catch(IOException e) {
		}
	}
	
	public String getClassType() {
		return pClass;
	}
	
	public int getIntelligence() {
		return itl;
	}
	
	public int getStamina() {
		return stm;
	}
	
	public int getAgility() {
		return agi;
	}
	
	public int getLevel() {
		return pLevel;
	}
	
	public ArrayList<String> getItems() {
		return pItems;
	}
}