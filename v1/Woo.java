// Mykolyk {Fang, Brianna, Pepe, Cat}
// APCS pd06
// FP - Connect 4

import java.util.Scanner;

public class Woo {

	private int _mode;	// 0: Undecided // 1: Loner // 2: Multiplayer
	private String[][] _board;
	private int _rows;
	private int _columns;

	public Woo() {
		_mode = 0;
		_rows = 5;
		_columns = 6;
		_board = new String[_rows][_columns];
		for (int r = 0; r < _board.length; r ++) {
			for (int c = 0; c < _board[r].length; c ++) {
				_board[r][c] = " ";
			}
		}
	}

	public void welcome() {

		Scanner s = new Scanner(System.in);
		int menuChoice = -1;
		int modeChoice = -1;

		String msg = "Hey thinkeren, welcome to Connect 4 Life!";
		msg += "\n[Insert More Message]";
		msg += "\n====================================";
		System.out.println(msg);

		while (true) {

			msg = "\nMENU";
			msg += "\n0: How-To-Play";
			msg += "\n1: GameMode Selection";

			if (_mode > 0) {
				msg += "\n2: Proceed";
			}

			System.out.println(msg);
			System.out.print("Selection: ");
			menuChoice = s.nextInt();

			if (menuChoice == 0) {
				System.out.println("\n[Insert How-To-Play]");
			} else
			if (menuChoice == 1) {
				System.out.print("\nPick a mode:");
				System.out.print("\n0: Single as a Pringle");
				System.out.println("\n1: Duo Player");
				System.out.print("Selection: ");
				modeChoice = s.nextInt();
				if (modeChoice == 0) {
					_mode = 1;
				} else
				if (modeChoice == 1) {
					_mode = 2;
				} else
					System.out.println("Returning to the menu...");
			} else
			if (menuChoice == 2 && _mode > 0) {
				break;
			} else
				System.out.println("Invalid Input");

		}

	}


	public void display() {

		System.out.println("=========================");
		for (int i = 0; i < _rows; i ++) {
			for (int n = 0; n < _columns; n ++) {
				System.out.print("| " + _board[i][n] + " ");
			}
			System.out.print("|\n");
		}
		System.out.println("=========================");

	}


	public static void main(String[] args) {
		Woo game = new Woo();

		// Print Welcome Message
		// game.welcome();
		game.display();

		/* ======================================
		if (game._mode == 1) {
			singlePlay();
		}

		if (game._mode == 2) {
			multiPlay();
		}
		====================================== */

	}

}
