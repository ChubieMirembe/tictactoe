package tictactoe;

import java.util.*;

public class Main {

    static int counter(String x, char y) {
        int totalCharacters = 0;
        char temp;
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            if (temp == y) {
                totalCharacters++;
            }
        }
        return totalCharacters;
    }

    static String [] sideWays(String x){
        String h1 = x.substring(0,3);
        String h2 = x.substring(3,6);
        String h3 = x.substring(6,9);

        return new String[]{h1, h2, h3};
    }

    static String [] splitter(String x) {
        String fSet = x.substring(0, 3);
        fSet = fSet.replace(""," ").trim();
        String sSet = x.substring(3, 6);
        sSet = sSet.replace(""," ").trim();
        String tSet = x.substring(6, 9);
        tSet = tSet.replace(""," ").trim();

        return new String[]{fSet, sSet, tSet};
    }

    static boolean inARow(String x, char y) {
        // Method to check if there's 3 in a row
        String check = Character.toString(y);
        String check1 = check + check + check;

        // Checks horizontally
        String h1 = x.substring(0,3);
        String h2 = x.substring(3,6);
        String h3 = x.substring(6,9);

        // Checks vertically
        String v1 = x.charAt(0) + x.substring(3,4) + x.charAt(6);
        String v2 = x.charAt(1) + x.substring(4,5) + x.charAt(7);
        String v3 = x.charAt(2) + x.substring(5,6) + x.charAt(8);

        // Checks diagonally
        String d1 = x.charAt(0) + x.substring(4,5) + x.charAt(8);
        String d2 = x.charAt(2) + x.substring(4,5) + x.charAt(6);

        String [] arr = {h1, h2, h3, v1, v2, v3, d1, d2};   // Puts them into an array

        // Loop to check if they have 3 in a row
        for (String s : arr) {
            if (s.equalsIgnoreCase(check1)) {
                return true;
            }
        }
        return false;
    }

    static boolean emptyCells(String x) {
        char temp;
        for (int i = 0; i < x.length(); i++) {
            temp = x.charAt(i);
            if (temp == '_') {
                return true;
            }
        }
        return false;
    }

    static String replaceChar(String str, char ch, int index) {
        char[] chars = str.toCharArray();
        chars[index] = ch;
        return String.valueOf(chars);
    }

    static String changedLine(String x, int c1, int c2, char y) {
        if (c1 == 1){
            if (c2 == 1){
                x = replaceChar(x, y,  0);
            } else if (c2 == 2) {
                x = replaceChar(x, y,  1);
            } else if (c2 == 3){
                x = replaceChar(x, y,  2);
            }
        } else if (c1 == 2) {
            if (c2 == 1){
                x = replaceChar(x, y,  3);
            } else if (c2 == 2) {
                x = replaceChar(x, y,  4);
            } else if (c2 == 3){
                x = replaceChar(x, y,  5);
            }
        } else if (c1 == 3) {
            if (c2 == 1){
                x = replaceChar(x, y,  6);
            } else if (c2 == 2) {
                x = replaceChar(x, y,  7);
            } else if (c2 == 3) {
                x = replaceChar(x, y,  8);
            }
        }

        return x;
    }


    static void printBoard (String x, String y, String z) {
        System.out.println("--------");
        System.out.println("| " + x + " |");
        System.out.println("| " + y + " |");
        System.out.println("| " + z + " |");
        System.out.println("--------");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "_________";
        String [] str1 = splitter(str);
        String fSet = str1[0];
        String sSet = str1[1];
        String tSet = str1[2];
        printBoard(fSet, sSet, tSet);
        
        int cord1;
        int cord2;
        int counter = 0;
        boolean gameOver = false;
        char c = 'X';
        
        while (!gameOver) {
            switch (counter) {
                case 0:
                    c = 'X';
                    counter++;
                    break;
                case 1:
                    c = 'O';
                    counter--;
                    break;
            }
            System.out.print("Enter the coordinates: ");
            
            while(true) {
                try {
                    cord1 = Integer.parseInt(sc.next());
                    cord2 = Integer.parseInt(sc.next());
                    break;
                }catch (NumberFormatException e) {
                    System.out.print("You should enter numbers!");

                }
            }
            
            while(cord1 > 3 || cord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            System.out.print("Enter the coordinates: ");
            cord1 = sc.nextInt();
            cord2 = sc.nextInt();
            }

            boolean cond = true;
            while (cond) {
                String [] sides = sideWays(str);
                if (cord1 == 1){
                String sides1 = sides[0];
                if (!(sides1.charAt(cord2 - 1) == '_')){
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates: ");
                    cord1 = sc.nextInt();
                    cord2 = sc.nextInt();
                } else {
                    cond = false;
                }

                } else if (cord1 == 2) {
                    String sides1 = sides[1];
                    if (cord2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        System.out.print("Enter the coordinates: ");
                        cord1 = sc.nextInt();
                        cord2 = sc.nextInt();
                    }
                    else if (!(sides1.charAt(cord2 - 1) == '_')){
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.print("Enter the coordinates: ");
                        cord1 = sc.nextInt();
                        cord2 = sc.nextInt();
                    } else {
                        cond = false;
                    }

                }else if (cord1 == 3) {
                    String sides1 = sides[2];
                    if (!(sides1.charAt(cord2 - 1) == '_')){
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.print("Enter the coordinates: ");
                        cord1 = sc.nextInt();
                        cord2 = sc.nextInt();
                    } else {
                        cond = false;
                    }
                }
            }
            
            str = changedLine(str, cord1, cord2, c);
            str1 = splitter(str);
            fSet = str1[0];
            sSet = str1[1];
            tSet = str1[2];

            printBoard(fSet, sSet, tSet);

            boolean xWins = inARow(str, 'X'); //&& !emptyCells(str);
            boolean oWins = inARow(str, 'O'); //&& !emptyCells(str);
            int xCount = counter(str, 'X');
            int oCount = counter(str, 'O');
            int diff = Math.abs(xCount - oCount);
            boolean impossible = xWins && oWins && diff > 1;

            boolean xRow = inARow(str, 'X');
            boolean oRow = inARow(str, 'Y');
            boolean notXO = !xRow && !oRow;
            boolean draw = notXO && !emptyCells(str);

            if (impossible){
                System.out.println("Impossible");
            } else if (draw) {
                System.out.println("Draw");
                gameOver = true;
                break;
            } else if (notXO && !emptyCells(str)) {
                System.out.println("Game not finished");
                gameOver = true;
            } else if (xWins) {
                System.out.println("X wins");
                gameOver = true;
                break;
            } else if (oWins) {
                System.out.println("O wins");
                gameOver = true;
                break;
            }

        }

    }
}
