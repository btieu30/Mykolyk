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

// resource aquired from TerminallyIll.java
// ===================================================================

        private static final int BRIGHT = 1;
        private static final int DARK = 2;
        private static final int ITALICS = 3;
        private static final int BLACK = 30;
        private static final int RED = 31;
        private static final int GREEN = 32;
        private static final int YELLOW = 33;
        private static final int BLUE = 34;
        private static final int MAGENTA = 35;
        private static final int CYAN = 36;
        private static final int WHITE = 37;
        private static final String CLEAR_SCREEN =  "\033[2J";
        private static final String HIDE_CURSOR =  "\033[?25l";
        private static final String SHOW_CURSOR =  "\033[?25h";

        //use this to go back to normal terminal colors
        private static final String RESET = color(40,37)+SHOW_CURSOR;

        //use this to convert from color to background (30 to 37 becomes 40 to 47)
        public static int background(int color)
        {
          return color + 10;
        }

        //terminal specific character to move the cursor to a location
        //top left is 1,1
        private static String go(int x, int y)
        {
          return ("\033[" + x + ";" + y + "H");
        }


        private static String color(int a, int b)
        {
          return ("\033[0;" + a+ ";" + b + "m");
        }
        private static String color(int a, int b, int c)
        {
          return ("\033[0;" + a+ ";" + b + ";" + c+ "m");
        }
        private static String color(int a, int b, int c, int d)
        {
          return ("\033[0;" + a+ ";" + b + ";" + c + ";" + d + "m");
        }

// ===================================================================


        public void welcome() {

                Scanner s = new Scanner(System.in);
                int menuChoice = -1;
                int modeChoice = -1;
                String tempScan = "";

                System.out.println(CLEAR_SCREEN + go(1,1));
                String msg = "\nHey thinkeren, welcome to Connect 4 Life!";
                msg += "\n[Final Project by yours truly, FMC and B2, aka Mykolyk]";
                System.out.println(msg);

                while (true) {
                  //menu
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
                        System.out.println(CLEAR_SCREEN + go(1,1));

                        if (menuChoice == 0) {
                          //directions
                                msg = "\n====================================\n";
                                msg += "\nDirections: ";
                                msg += "\n- Begin by choosing your gamemode: single player or multiplayer.";
                                msg += "\n- Single player: Face off against ten-time Connect 4 Champion, Bot Mykolyk.";
                                msg += "\n- Multiplayer: Find another thinkeren and take turns switching control of \n  the machine to face off.";
                                msg += "\n- Choose your color and symbol, then begin the game and place your pieces \n  by choosing the column number until you get a row (horizontally, \n  vertically, diagonally) of 4 pieces to win!";
                                System.out.println(msg);
                                System.out.print("\nType Something to Return: ");
                                tempScan = s.next();
                                System.out.println(CLEAR_SCREEN + go(1,1));
                        } else
                        if (menuChoice == 1) {
                          //modeChoice
                                msg = "\n====================================\n";
                                msg += "\nPick a mode:";
                                msg += "\n0: Single as a Pringle";
                                msg += "\n1: Duo Player";
                                msg += "\nSelection: ";
                                System.out.print(msg);
                                modeChoice = s.nextInt();
                                if (modeChoice == 0) {
                                        _mode = 1;
                                } else
                                if (modeChoice == 1) {
                                        _mode = 2;
                                } else
                                        System.out.println("Invalid. Returning to the menu...");
                                System.out.println(CLEAR_SCREEN + go(1,1));
                        } else
                        if (menuChoice == 2 && _mode > 0) {
                                System.out.println(CLEAR_SCREEN + go(1,1));
                                break;
                        } else
                                System.out.println("Invalid Input");
                                System.out.println(CLEAR_SCREEN + go(1,1));

                }

        }

        public void clearBoard() {

            _board = new String[_rows][_columns];
                for (int r = 0; r < _board.length; r ++) {
                        for (int c = 0; c < _board[r].length; c ++) {
                                _board[r][c] = " ";
                        }
                }

        }


        public void display() {
          //display game board

                String top = "";
                String bottom = color(WHITE, background(WHITE), DARK);

                System.out.println(CLEAR_SCREEN + go(1,1)); //clear screen of menu
                for (int col = 0; col < _columns; col++) {
                         System.out.print ("  " + col + " ");
                }

                for (int c = 0; c < _columns; c ++) {
                        top += color(WHITE, background(WHITE), DARK) + "=" + RESET + "===";
                        bottom += "====";
                }
                top += color(WHITE, background(WHITE), DARK) + "=" + RESET;
                bottom += color(WHITE, background(WHITE), DARK) + "=" + RESET;


                System.out.println("\n" + top);
                for (int i = 0; i < _rows; i ++) {
                        for (int n = 0; n < _columns; n ++) {
                                System.out.print(color(WHITE, background(WHITE)) + "|" + RESET + " " + _board[i][n] + " ");
                        }
                        System.out.print(color(WHITE, background(WHITE)) + "|\n" + RESET);
                }
                System.out.println(bottom + "\n");
        }


        public void play(Gamer hum) {

                int _selection;

                Scanner s = new Scanner(System.in);
                display(); //display board w each play
                System.out.println("Thinker " + hum.name() + ", make your move by choosing the number of your column of destiny!");
                System.out.print("Move: ");
                while (true) {
                        _selection = s.nextInt();
                        if (_selection < 0 || _selection > _columns - 1) {
                          System.out.print("\n*** Invalid Input. Please try again. ***\n");
                          System.out.print("Move: ");
                          continue; //jump to next
                        }
                        if (_board[0][_selection] != " ") {
                          System.out.print("\n*** Selected column is full. Try picking another column. ***\n");
                          System.out.print("Move: ");
                           continue; //jump to next
                        }
                        for (int i = _rows - 1; i >= 0; i--) {
                          if (_board[i][_selection] == " ") {
                            _board[i][_selection] = color(BRIGHT,WHITE,background(hum.Bg())) + hum.letter() + RESET; //change with player's color
                            return; //exit loop + return void
                          }
                        }
                  }
            }


        public void botPlay(Bot yogurt) {

                int _selection = (int) ((_columns) * Math.random() );
                for (int i = _rows - 1; i >= 0; i--) {
                        if (_board[i][_selection] == " ") {
                                _board[i][_selection] = color(BRIGHT,WHITE,background(yogurt.Bg())) + yogurt.letter() + RESET;
                                break;
                        }
                        if (_board[0][_selection] != " ") {
                          botPlay(yogurt);
                          break;
                        }
                    }
                }


        public void singlePlay() {

                int _maxTurns = _rows * _columns;
                int turn = 0;
                Scanner s = new Scanner(System.in);
                Bot Poggers = new Bot();
                String pickChar = "";
                int pickBg;
                int pickMenu = 0;

                System.out.print("\nWell well, I see that you are alone. What doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Mykolyk = new Gamer(s.next(), "Temp");

                while (Mykolyk.letter() == "Temp") {
                        System.out.print("\nPick a character of your choice: ");
                        pickChar = s.next();

                        if (!(pickChar.equals("")) && pickChar.length() == 1) {
                                Mykolyk.setLetter(pickChar);
                                if (pickChar.equals("B")) {
                                    Poggers.setLetter("M");
                                }
                        } else {
                                System.out.print("\nThat's not a character. Try again!");
                        }
                      }

                while (Mykolyk._colorBg == 30) {
                        System.out.print("\nColor Superiority");
                        System.out.print("\n0: Red \n1: Green \n2: Yellow \n3: Blue \n4: Magenta");
                        System.out.print("\nPick a color of your choice: ");
                        pickBg = s.nextInt();

                        if(pickBg >= 0 && pickBg < 5) {
                                Mykolyk.setBg(pickBg + 1);
                        }
                        else {
                                System.out.print("\nThat's not a valid selection. Try again!");
                             }
                }

                while (pickMenu != 1) { 
                    while ((_winner ==  "") && (turn <= _maxTurns))  {
                        play(Mykolyk);
                        checkWin(Mykolyk);
                        turn++;
                        if (_winner == Mykolyk.name()) {
                            Mykolyk.won();
                        } else {
                            botPlay(Poggers);
                            checkWin(Poggers);
                            turn++;
                            if (_winner == Poggers.name()){
                              Mykolyk.lost();
                            }
                        }
                    }
                    if (turn > _maxTurns) {
                      System.out.println("All players have occupied all spots on the board without any matches. There is no winner!");
                    }

                    System.out.print("\n====================================");
                    System.out.print("\nCurrent Wins:Losses = " + Mykolyk.wins() + ":" + Mykolyk.losses());
                    System.out.print("\nThis game has ended, but what's stopping you from another?");
                    System.out.print("\nWould you fancy a rematch with Bot Mykolyk?");
                    System.out.print("\n0: Yes");
                    System.out.print("\n1: Nah");
                    System.out.print("\nSelection: ");
                    pickMenu = s.nextInt();
                    if (pickMenu == 1) {
                        System.out.println("\nWhat a shame. Bye!\n");
                        break;
                    } else {
                        if (pickMenu != 0) { // forcing the player to keep playing for as long as possible
                            System.out.print("\nThat's not one of the choices, but I'll take it that you want to play again.");
                        } 
                    }

                    _winner = "";
                    turn = 0;
                    clearBoard();

                }
        }


        public void multiPlay() {

                Scanner s = new Scanner(System.in);
                String pickChar = "";
                int pickBg = -1;
                int pickMenu = -1;
                String fustrations = "";

                int _maxTurns = _rows * _columns;
                int turn = 0;


                System.out.print("\nPlayer 1, what doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Fang = new Gamer(s.next(), "");

                System.out.print("\nPlayer 2, what doest thou call themselves? ");
                System.out.print("\nType your name: ");
                Gamer Bri = new Gamer(s.next(), "");

                while (Fang.letter() == "") {
                    System.out.print("\n" + Fang.name() + " -- Pick a character of your choice: ");
                    pickChar = s.next();

                    if (!(pickChar.equals("")) && pickChar.length() == 1) {
                            Fang.setLetter(pickChar);
                            break;
                    } else {
                            System.out.print("\nThat's not a character. Try again!");
                    }
                }
                while (Bri.letter() == "") {
                    System.out.print("\n" + Bri.name() + " -- Pick a character of your choice: ");
                    pickChar = s.next();
                    if (!(pickChar.equals("")) && pickChar.length() == 1) {
                            if (pickChar.equals(Fang.letter())) {
                                System.out.print("\nSorry, first comes, first serve. Pick another one.");
                            } else {
                                Bri.setLetter(pickChar);
                            }
                    } else {
                            System.out.print("\nThat's not a character. Try again!");
                    }
                }


                System.out.print("\nNow let's choose our colors of greatness! Here are the choices:");
                System.out.println("\n0: Red \n1: Green \n2: Yellow \n3: Blue \n4: Magenta");

                while (Fang._colorBg == 30) {
                    System.out.print("\n" + Fang.name() + " -- Pick a color of your choice: ");
                    pickBg = s.nextInt();

                    if(pickBg >= 0 && pickBg < 5) {
                        Fang.setBg(pickBg + 1);
                    }
                    else {
                            System.out.print("\nThat's not a valid selection. Try again!");
                         }
                }

                 while (Bri._colorBg == 30) {
                    System.out.print("\n" + Bri.name() + " -- Pick a color of your choice: ");
                    pickBg = s.nextInt();

                    if(pickBg >= 0 && pickBg < 5) {
                        Bri.setBg(pickBg + 1);
                    }
                    else {
                            System.out.print("\nThat's not a valid selection. Try again!");
                         }
                }

                while (pickMenu != 1) {

                    while ((_winner == "") && (turn <= _maxTurns)) {

                        play(Fang);
                        checkWin(Fang);
                        turn++;
                        if (_winner == Fang.name()) {
                            Fang.won();
                            Bri.lost();
                        } else {
                            play(Bri);
                            checkWin(Bri);
                            turn++;
                            if (_winner == Bri.name()) {
                                Fang.lost();
                                Bri.won();
                            }
                        }

                    }

                    System.out.print("\n====================================");
                    System.out.print("\nCurrent Score | " + Fang.name() + ": " + Fang.wins() + " | " + Bri.name() + ": " + Bri.wins());
                    System.out.print("\nThis game has ended, but what's stopping you from another?");
                    System.out.print("\nWould you guys fancy a rematch with Bot Mykolyk?");
                    System.out.print("\n0: Yes");
                    System.out.print("\n1: Nah");
                    System.out.print("\nSelection: ");
                    pickMenu = s.nextInt();
                    if (pickMenu == 1) {
                        System.out.println("\nWhat a shame. Bye!\n");
                        break;
                    } else {
                        if (pickMenu != 0) { // forcing the players to keep playing for as long as possible
                            System.out.print("\nThat's not one of the choices, but I'll take it that you want to play again.");
                            System.out.print("\nType your fustrations before continuing: ");
                                fustrations = s.scanner();
                        } 
                    }

                    _winner = "";
                    turn = 0;
                    clearBoard();

                }
        }


        public void checkWin(Player cheese) {

                //increment wins and losses - Gamer.java
                String check = color(BRIGHT,WHITE,background(cheese.Bg())) + cheese.letter() + RESET;

                for (int r = 0; r < _rows; r++) {
                  for (int c = 0; c < _columns - 3; c++) {
                    if ( (_board[r][c].equals(check)) &&
                       (_board[r][c+1].equals(check)) &&
                       (_board[r][c+2].equals(check)) &&
                       (_board[r][c+3].equals(check)) ) {
                         _winner = cheese.name();
                         display();
                         System.out.println(_winner + " has claimed victory!\n");
                         return;
                       }
                  }
                }

                for (int r = 0; r < _rows - 3; r++) {
                  for (int c = 0; c < _columns; c++) {
                    if ( (_board[r][c].equals(check)) &&
                       (_board[r+1][c].equals(check)) &&
                       (_board[r+2][c].equals(check)) &&
                       (_board[r+3][c].equals(check)) ) {
                         _winner = cheese.name();
                         display();
                         System.out.println(_winner + " has claimed victory!\n");
                         return;
                       }
                  }
                }

                for (int r = 0; r < _rows - 3; r++) {
                  for (int c = 0; c < _columns - 3; c++) {
                    if ( (_board[r][c].equals(check)) &&
                       (_board[r+1][c+1].equals(check)) &&
                       (_board[r+2][c+2].equals(check)) &&
                       (_board[r+3][c+3].equals(check)) ) {
                         _winner = cheese.name();
                         display();
                         System.out.println(_winner + " has claimed victory!\n");
                         return;
                       }
                  }
                }

                for (int r = 3; r < _rows; r++) {
                  for (int c = 0; c < _columns - 3; c++) {
                    if ( (_board[r][c].equals(check)) &&
                       (_board[r-1][c+1].equals(check)) &&
                       (_board[r-2][c+2].equals(check)) &&
                       (_board[r-3][c+3].equals(check)) ) {
                         _winner = cheese.name();
                         display();
                         System.out.println(_winner + " has claimed victory!\n");
                         return;
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
