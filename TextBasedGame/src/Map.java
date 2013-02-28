import java.util.Random;
import java.util.Scanner;

public class Map {
	private int[][] map;
	private int height;
	private int width;
	private Random generator = new Random();
	private int[] startlocation = new int[2];// width height
	private int[] endlocation = new int[2];// width height
	private Scanner scan = new Scanner(System.in);
	private int[] playerlocation = new int[2];
	private boolean foundend = false;
	private Mechanics mech = new Mechanics();

	// 1 = start
	// 2 = finish
	// 0 = nothing
	// 3 = path
	// 4 = cannot walk
	public Map(int h, int w) {
		//Creates a 2D map and allows movement in it. Makes sur eyou cant leave the map and handles out of bounds errors
		
		height = h;
		width = w;
		map = new int[w + 1][h + 1];
		mapGenerate();

	}

	private void mapGenerate() {
		set_map();// set all as null
		random_start();
		random_finish();
		verify_route();
		printarray();
		finishrandomizing();
		System.out.print("\n");
		printarray();
		map[startlocation[0]][startlocation[1]] = 1;
		map[endlocation[0]][endlocation[1]] = 2;
		playerlocation[1] = startlocation[0];
		playerlocation[0] = startlocation[1]; // because I fail

	}

	private void random_start() {
		int x = generator.nextInt(2);
		int y = generator.nextInt(2);
		startlocation[0] = x;
		startlocation[1] = y;
		map[x][y] = 1;

	}

	private void random_finish() {
		int x = width - generator.nextInt(2);
		int y = height - generator.nextInt(2);
		endlocation[0] = x;
		endlocation[1] = y;
		map[x][y] = 2;
	}

	private void set_map() {
		for (int x = 0; x <= width; x++) {
			for (int y = 0; y <= height; y++) {
				map[x][y] = 0;
			}
		}
	}

	private void verify_route() {
		int sx = startlocation[0];
		int sy = startlocation[1];
		int ex = endlocation[0];
		int ey = endlocation[1];

		while (!(map[sx][sy] == 2)) {
			int randx = generator.nextInt(2);
			int randy = generator.nextInt(2);
			if (sx != ex) {
				if (randx == 1) {

					if (sx != ex) {
						map[sx][sy] = 3;
					}
					sx += 1;
				}
			}
			if (sy != ey) {
				if (randy == 1) {

					if (sy != ey) {
						map[sx][sy] = 3;
					}
					sy += 1;
				}
			}
			map[startlocation[0]][startlocation[1]] = 1;
			map[endlocation[0]][endlocation[1]] = 2;
		}

	}

	private void finishrandomizing() {
		for (int x = 0; x <= height; x++) {
			for (int y = 0; y <= width; y++) {
				if (map[x][y] == 0) {
					map[x][y] = randomplacement();
				}
			}
		}
	}

	public void printarray() {
		for (int x = 0; x <= width; x++) {
			for (int y = 0; y <= height; y++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println("\n");
		}

	}

	private int randomplacement() {
		switch (generator.nextInt(10)) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return 3;
		case 5:
		case 6:
		case 7:
			return 4;
		case 8:
			return 5;
		case 9:
			return 0;
		default:
			return 3;

		}
	}

	public boolean mapMenu() {

		boolean fight = false;
		boolean verify = true;
		while (verify) {
			fight = false;
			System.out
					.println("\nWhich direction would you like to go? (Up, Down, Left, Right)");
			String input = scan.next();
			if (input.equalsIgnoreCase("left")) {
				playerlocation[0]--;

				if (playerlocation[0] < 0) {
					playerlocation[0]++;
					verify = true;
					System.out.println("You cannot move left");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] == 0) {
					verify = true;
					System.out.println("You cannot move left");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] > 3) {
					String X = mech.getRandomString("files/CombatReasons.txt");
					System.out.println(X);
					fight = true;
					verify = false;
				} else if (map[playerlocation[1]][playerlocation[0]] == 3) {
					// On path
					verify = false;
				} else if (map[playerlocation[0]][playerlocation[1]] == 2) {
					{
						System.out.println("ahsdbhak");
						foundend = true;
						verify = false;

					}
				}

			} else if (input.equalsIgnoreCase("right")) {
				playerlocation[0]++;

				if (playerlocation[0] > width) {
					playerlocation[0]--;
					verify = true;
					System.out.println("You cannot move right");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] == 0) {
					verify = true;
					System.out.println("You cannot move right");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] > 3) {
					String X = mech.getRandomString("files/CombatReasons.txt");
					System.out.println(X);
					fight = true;
					verify = false;
				} else if (map[playerlocation[1]][playerlocation[0]] == 3) {
					verify = false;
				} else if (map[playerlocation[0]][playerlocation[1]] == 2) {
					{
						System.out.println("ahsdbhak");
						foundend = true;
						verify = false;
					}
				}

			} else if (input.equalsIgnoreCase("up")) {
				playerlocation[1]--;

				if (playerlocation[1] < 0) {
					playerlocation[1]++;
					verify = true;
					System.out.println("You cannot move up");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] == 0) {
					verify = true;
					System.out.println("You cannot move up");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] > 3) {
					String X = mech.getRandomString("files/CombatReasons.txt");
					System.out.println(X);
					fight = true;
					verify = false;
				} else if (map[playerlocation[1]][playerlocation[0]] == 3) {

					verify = false;
				} else if (map[playerlocation[0]][playerlocation[1]] == 2) {
					{
						System.out.println("ahsdbhak");
						foundend = true;
						verify = false;
					}
				}

			} else if (input.equalsIgnoreCase("down")) {
				playerlocation[1]++;

				if (playerlocation[1] > height) {
					playerlocation[1]--;
					verify = true;
					System.out.println("You cannot move down");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] == 0) {
					verify = true;
					System.out.println("You cannot move down");
					System.out.println("Please re-enter your chocie;");
				} else if (map[playerlocation[1]][playerlocation[0]] > 3) {
					String X = mech.getRandomString("files/CombatReasons.txt");
					System.out.println(X);
					fight = true;
					verify = false;
				} else if (map[playerlocation[1]][playerlocation[0]] == 3) {

					verify = false;
				} else if (map[playerlocation[0]][playerlocation[1]] == 2) {
					{
						System.out.println("ahsdbhak");
						foundend = true;
						verify = false;
					}
				}

			} else {
				System.out.println("Please Re-Enter");
			}
		}
		// printarray();
		return fight;
	}

	public boolean getFoundEnd() {
		return foundend;
	}
}
