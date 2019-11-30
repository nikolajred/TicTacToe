import java.util.Scanner;

public class TicTacToeAPI {
    private static final String EMPTY = "   ";
    private static final String CROSS = " X ";
    private static final String ZERO  = " O ";
    private static final int ROW = 3;
    private static final int STRING = 3;
    private static String [][] gameNet = new String[STRING][ROW];
    private static int statusGame;
    private static final int GAME_IS_IN_PROCESS = 0;
    private static final int GAME_IS_OVER_DRAW = 1;
    private static final int GAME_IS_OVER_DRAW_WINNER_X = 2;
    private static final int GAME_IS_OVER_DRAW_WINNER_O = 3;
    private static String activePlayer;
    private static Scanner scanner = new Scanner(System.in);

     public static void startGame(){
         for (int i = 0; i < STRING; i++) {
             for (int j = 0; j < ROW; j++) {
                 gameNet[i][j] = EMPTY;
             }
         }
         activePlayer = CROSS;
         drawNet();

     }
     public static void getPlayer(){
         boolean EnterIsTrue = false;
         do {
             System.out.println("Player " + activePlayer + " pleas enter number of string from 1 to 3, and number of raw from 1 to 3");
             int string = scanner.nextInt() - 1;
             int raw = scanner.nextInt() - 1;
             if (string >= 0 && string<= STRING && raw >=0 && raw <= ROW && gameNet[string][raw] == EMPTY){
                 gameNet[string][raw] = activePlayer;
                 EnterIsTrue = true;
             }else{
                 System.out.println("selected accommodation (" + (string + 1) +"," + (raw + 1)+ ") is forbidden  - try again");

             }


         }while (!EnterIsTrue);

     }
     public static void checkField(){
         String winner = findWinner();
         if (winner.equals(CROSS)){
             statusGame = GAME_IS_OVER_DRAW_WINNER_X;
         }else if(winner.equals(ZERO)){
             statusGame = GAME_IS_OVER_DRAW_WINNER_O;
         }else if(checkFullField()){
            statusGame = GAME_IS_OVER_DRAW;
         }else {
             statusGame = GAME_IS_IN_PROCESS;
         }
     }
     public static boolean checkFullField(){
         for (int i = 0; i < STRING; i++) {
             for (int j = 0; j < ROW; j++) {
                 if (gameNet[i][j]==EMPTY){
                     return false;
                 }

             }

         }


         return true;
     }
     public static String findWinner(){

         for (int i = 0; i < STRING ; i++) {
             int countSame = 0;
             for (int j = 0; j < ROW; j++) {
                 if(gameNet[i][0]!= EMPTY && gameNet[i][0] == gameNet[i][j]) {
                     countSame++;
                 }
             }
             if (countSame == 3){
                 return gameNet[i][0];
             }

                 }
         for (int i = 0; i < ROW ; i++) {
             int countSame = 0;
             for (int j = 0; j < STRING; j++) {
                 if(gameNet[0][i]!= EMPTY && gameNet[0][i] == gameNet[j][i]) {
                     countSame++;
                 }
                 if (countSame == 3){
                     return gameNet[0][i];
             }
         }
     }
         if (gameNet[0][0] != EMPTY && gameNet[0][0]==gameNet[1][1] && gameNet[0][0]==gameNet[2][2] ){
         return gameNet[0][0];
         }
         if (gameNet[0][2] != EMPTY && gameNet[1][1]==gameNet[0][2] && gameNet[0][2]==gameNet[2][0] ){
             return gameNet[0][2];
         }
         return EMPTY;
     }
     public static void drawNet(){
         for (int i = 0; i < STRING; i++) {
             for (int j = 0; j < ROW; j++) {
                 System.out.print(gameNet[i][j]);
                 if (j != ROW-1){
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
        startGame();
        do {
            getPlayer();
            checkField();
            drawNet();
            findWinner();
            if (statusGame ==GAME_IS_OVER_DRAW_WINNER_X){
                System.out.println("winner is X");
            }else if(statusGame==GAME_IS_OVER_DRAW_WINNER_O){
                System.out.println("winner is O");
            }else if(statusGame==GAME_IS_OVER_DRAW){
                System.out.println("game is over draw");
            }
             activePlayer = (activePlayer==CROSS?ZERO:CROSS);

        }while (statusGame == GAME_IS_IN_PROCESS);

    }
}
