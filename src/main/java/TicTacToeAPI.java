import java.util.Scanner;

public class TicTacToeAPI {
    private static final String EMPTY = "   ";
    private static final String CROSS = " x ";
    private static final String ZERO = " o ";
    private static final int RAW = 3;
    private static final int STRING = 3;
    private static String [][] gameNet = new String[STRING][RAW];
    private static int statusGame;
    private static final int GAME_IS_IN_PROCESS = 0;
    private static final int GAME_IS_OVER_DRAW = 1;
    private static final int GAME_IS_OVER_DRAW_WINNER_X = 2;
    private static final int GAME_IS_OVER_DRAW_WINNER_O = 3;
    private static String activePlayer;
    private static Scanner scanner = new Scanner(System.in);

     public static void startGame(){
         for (int i = 0; i < STRING; i++) {
             for (int j = 0; j < RAW; j++) {
                 gameNet[STRING][RAW] = EMPTY;
             }
             activePlayer = CROSS;
             drawNet();

         }

     }
     public static void getPlayer(){
         boolean EnterIsTrue = false;
         do {
             System.out.println("Player " + activePlayer + "enter pleas string from 1 to 3");
             int string = scanner.nextInt() - 1;
             int raw = scanner.nextInt() - 1;
             if (string >= 0 && string<= STRING && raw >=0 && raw <= RAW && gameNet[STRING][RAW] == EMPTY){
                 gameNet[STRING][RAW] = activePlayer;
                 EnterIsTrue = true;
             }else{
                 System.out.println("selected accommodation (" + (string + 1) +"," + (raw + 1)+ ") is forbidden  - try again");

             }


         }while (!EnterIsTrue);

     }
     public static void checkField(){


     }
     public static boolean checkFullField(){
         return false;
     }
     public static String findWinner(){
         int countSame = 0;
         for (int i = 0; i < STRING ; i++) {
             for (int j = 0; j < RAW; j++) {
                 if(gameNet[i][0]!= EMPTY && gameNet[i][0] == gameNet[i][j]) {
                     countSame++;
                 }
             }
             if (countSame == 3){
                 return gameNet[i][0];
             }
             for (int j = 0; i < RAW ; j++) {
                 for (int i = 0; i < STRING; i++) {
                     if(gameNet[0][RAW]!= EMPTY && gameNet[0][RAW] == gameNet[i][j]) {
                         countSame++;
                     }
                 }
                 if (countSame == 3){
                     return gameNet[0][0];
                 }


         }
     }
     public static void drawNet(){
         for (int i = 0; i < STRING; i++) {
             for (int j = 0; j < RAW; j++) {
                 System.out.print(gameNet[i][j]);
                 if (j != RAW-1){
                     System.out.print("|");
                 }
             }
             System.out.println();
             if(i != STRING-1){
                 System.out.print("-----------");
             }
             System.out.println();

         }


     }

    public static void main(String[] args) {
        drawNet();

    }
}
