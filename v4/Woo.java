// Mykolyk {Fang, Brianna, Pepe, Cat}
// APCS pd06
// FP - Connect 4

import java.util.Scanner;

public class Woo {

        private int _mode;              // 0: Undecided // 1: Loner // 2: Multiplayer
        private String[][] _board;
        private int _rows;
        private int _columns;
        public String _winner;

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

                for (int col = 0; col < _columns; col++) {
                                        System.out.print ("  " + col + " ");
                                }

                System.out.println("\n=========================");
                for (int i = 0; i < _rows; i ++) {
                        for (int n = 0; n < _columns; n ++) {
                                System.out.print("| " + _board[i][n] + " ");
                        }
                        System.out.print("|\n");
                }
                System.out.println("=========================\n");

        }

        public void play() {
                Scanner s = new Scanner(System.in);
                        display();
                        int _selection = s.nextInt();
                        if (_selection < 0 || _selection >= _columns) {
                                System.err.print("Invalid Input. Please try again.");
                        } else {
                          for (int i = _rows - 1; i >= 0; i--) {
                            if (_board[i][_selection] == " ") {
                              _board[i][_selection] = "t"; //change with player's color
                              break;
                            }
                          }
                        }
                }

        public void botPlay() {
                int _selection = (int) ((_columns) * Math.random() );
                for (int i = _rows - 1; i >= 0; i--) {
                  if (_board[i][_selection] == " ") {
                        _board[i][_selection] = "B";
                        break;
                      }
                    }
                  }

        public void singlePlay() {
                int _maxTurns = _rows * _columns;
                int turn = 0;
                while (turn <= _maxTurns) { //and while there is no winner
                    System.out.println("\nThinkeren, make your move by choosing your column of destiny.");
                    play();
                    turn++;
                    botPlay();
                    turn++;
                  }
                }

        public void multiPlay() {
                int _maxTurns = _rows * _columns;
                int turn = 0;
                while (turn <= _maxTurns) { //and while there is no winner
                    System.out.println("\nPlayer 1, make your move.");
                    play();
                    turn++;
                    System.out.println("\nPlayer 2, make your move.");
                    play();
                    turn++;
                  }
                }

        public static void main(String[] args) {
                Woo game = new Woo();
                // Print Welcome Message
                game.welcome();
                //game.display();

                if (game._mode == 1) {
                        game.singlePlay();
                }

                if (game._mode == 2) {
                        game.multiPlay();
                }
                /* ======================================
                ====================================== */

        }

}
