import java.io.*;
import java.util.*;

public class Mechanics {
	Scanner scan = new Scanner(System.in);
	Random generator = new Random();

	public Mechanics() {
		
		//This class is where I put a lot of programming specific code. Check below for descriptions.
	}

	public int intVerification() {	//Verifies that the input is an integer. Reasks if it isn't.
		boolean chk = true;
		int output = 0;
		while (chk) {
			String input = scan.next();
			if (tryParseInt(input)) {
				output = Integer.parseInt(input);
				chk = false;
			} else {
				System.out.println("Please re-enter your number");
			}
		}
		return output;

	}

	private boolean tryParseInt(String value) {//Used for int verification
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public String getRandomString(String inputfile) {	//Gets string from a file and returns a random value from the txt file - used for name generation
		int maxitems = 100;
		String[] namearray = new String[maxitems];
		String name = null;
		try {
			FileInputStream fs = new FileInputStream(inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			int cnt = 1;
			while (true) {
				namearray[cnt] = br.readLine();
				if (namearray[cnt].equalsIgnoreCase("LastItem")) {
					break;
				}
				maxitems = cnt;
				cnt++;
			}
			int randline = generator.nextInt(maxitems-1);
			randline++;
			name = namearray[randline];
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;

	}
};
