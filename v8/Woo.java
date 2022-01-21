// Mykolyk {Fang, Brianna, Pepe, Cat}
// APCS pd06
// FP - Connect 4

import java.util.Scanner;

public class Woo {

        private int _mode;              // 0: Undecided // 1: Loner // 2: Multiplayer
        private String[][] _board;
        private int _rows;
        private int _columns;
        private String _winner = "";

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
                String tempScan = "";

                String msg = "\nHey thinkeren, welcome to Connect 4 Life!";
                msg += "\n[insert another message]";
                System.out.println(msg);

                while (true) {

                        msg = "\n====================================\n";
                        msg += "\nMENU";
                        msg += "\n0: How-To-Play";
                        msg += "\n1: GameMode Selection";

                        if (_mode > 0) {
                                msg += "\n2: Proceed";
                        }

                        System.out.println(msg);
                        System.out.print("Selection: ");
                        menuChoice = s.nextInt();

                        if (menuChoice == 0) {
                                msg = "\n====================================\n";
                                msg += "\nDirections: ";
                                msg += "\n- Begin by choosing your gamemode: single player or multiplayer.";
                                msg += "\n- Single player: Face off against ten-time Connect 4 Champion, Bot Mykolyk.";
                                msg += "\n- Multiplayer: Find another thinkeren and take turns switching control of \n  the machine to face off.";
                                msg += "\n- Choose your color and symbol, then begin the game and place your pieces \n  by choosing the column number until you get a row (horizontally, \n  vertically, diagonally) of 4 pieces to win!";
                                System.out.println(msg);
                                System.out.print("\nType Something to Return: ");
                                tempScan = s.next();

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
                                        System.out.println("Invalid. Returning to the menu...");
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


        public void play(Gamer hum) {

                Scanner s = new Scanner(System.in);
                        display();
                        int _selection = s.nextInt();
                        if (_selection < 0 || _selection >= _columns) {
                                System.err.print("*** Invalid Input. Please try again. ***");
                        } else {
                                for (int i = _rows - 1; i >= 0; i--) {
                                        if (_board[i][_selection] == " ") {
                                                _board[i][_selection] = hum.color(); //change with player's color
                                                break;
                                        }
                                        if (_board[0][_selection] != " ") {
                                                System.err.print("\n*** Selected column is full. Try picking another column. ***\n");
                                                break;

                                        }
                                }
                        }

                }


        public void botPlay(Bot yogurt) {

                int _selection = (int) ((_columns) * Math.random() );
                for (int i = _rows - 1; i >= 0; i--) {
                        if (_board[i][_selection] == " ") {
                                _board[i][_selection] = yogurt.color();
                                break;
                        }
                }
        }


        public void singlePlay() {

                int _maxTurns = _rows * _columns;
                int turn = 0;
                Scanner s = new Scanner(System.in);
                Bot poggers = new Bot();
                String pickColor = "";

                System.out.print("\nWell well, I see that you are alone. What doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Mykolyk = new Gamer(s.next(), "Temp");

                while (true) {
                        System.out.print("\nPick a character of your choice: ");
                        pickColor = s.next();

                        if (!(pickColor.equals("")) && pickColor.length() == 1) {
                                Mykolyk.setColor(pickColor);
                                break;
                        } else {
                                System.out.print("\nThat's not a character. Try again!");
                        }
                }


                while ((turn <= _maxTurns) && (_winner.compareTo("") == 0) ) { //and while there is no winner
                    System.out.println("\n" + Mykolyk.name() + ", make your move by choosing your column of destiny.");
                    play(Mykolyk);
                    checkWin(Mykolyk);
                    if (_winner == Mykolyk._color) {
                      break;
                    }
                    turn++;
                    botPlay(poggers);
                    checkWin(poggers);
                    if (_winner == poggers._color){
                      break;
                    }
                    turn++;
                }

        }

        public void multiPlay() {

                Scanner s = new Scanner(System.in);
                String pickColor = "";

                int _maxTurns = _rows * _columns;
                int turn = 0;


                System.out.print("\nPlayer 1, what doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Fang = new Gamer(s.next(), "Temp");

                System.out.print("\nPlayer 2, what doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Bri = new Gamer(s.next(), "Temp");

                while (true) {
                        System.out.print("\nPlayer 1 -- Pick a character of your choice: ");
                        pickColor = s.next();

                        if (!(pickColor.equals("")) && pickColor.length() == 1) {
                                Fang.setColor(pickColor);
                        } else {
                                System.out.print("\nThat's not a character. Try again!");
                        }
                        System.out.print("\nPlayer 2 -- Pick a character of your choice: ");
                        pickColor = s.next();

                        if (!(pickColor.equals("")) && pickColor.length() == 1) {
                                Bri.setColor(pickColor);
                                break;
                        } else {
                                System.out.print("\nThat's not a character. Try again!");
                        }
                }
                while ((turn <= _maxTurns) && _winner.compareTo("") == 0) { //fix winner declaration
                    System.out.println("\n" + Fang.name() + ", make your move by choosing your column of destiny.");
                    play(Fang);
                    checkWin(Fang);
                    if (_winner == Fang._color) {
                      break;
                    }
                    turn++;
                    System.out.println("\n" + Bri.name() + ", make your move by choosing your column of destiny.");
                    play(Bri);
                    checkWin(Bri);
                    if (_winner == Bri._color) {
                      break;
                    }
                    turn++;
                }

        }

        public void checkWin(Player cheese) {

                //increment wins and losses - Gamer.java

                for (int r = 0; r < _rows; r++) {
                  for (int c = 0; c < _columns - 3; c++) {
                    if ( (_board[r][c] == cheese._color) &&
                       (_board[r][c+1] == cheese._color) &&
                       (_board[r][c+2] == cheese._color) &&
                       (_board[r][c+3] == cheese._color) ) {
                         _winner = cheese._color;
                         display();
                         System.out.println(_winner + " has claimed victory!");
                         break;
                       }
                  }
                }

                for (int r = 0; r < _rows - 3; r++) {
                  for (int c = 0; c < _columns; c++) {
                    if ( (_board[r][c] == cheese._color) &&
                       (_board[r+1][c] == cheese._color) &&
                       (_board[r+2][c] == cheese._color) &&
                       (_board[r+3][c] == cheese._color) ) {
                         _winner = cheese._color;
                         display();
                         System.out.println(_winner + " has claimed victory!");
                         break;
                       }
                  }
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
