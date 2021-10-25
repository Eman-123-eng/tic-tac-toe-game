
import java.util.*;


// pr(8.9)

public class sec {
    static String[] board;
    static String turn;

    static String checkWinner(){
        for (int a=0;a<=8;a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[3] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (Objects.equals(line, "XXX")) {
                return "X";
            } else if (Objects.equals(line, "OOO")) {
                return "O";
            }
        }

            for (int a = 0; a < 9; a++) {
                if (board[a].contains(String.valueOf(a + 1))) {
                    break;
                } else if (a == 8) {
                    return "draw";
                }
            }
            System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in");
            return null;


    }

    static void printBoard(){
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // pr(7.3)
        /*int arr[] = new int[10];
        System.out.println("Enter the array elements");
        for(int i=0;i<=9;i++) {
            arr[i] = scn.nextInt();
            if (arr[i]==0){
                break;
            }

        }
        for(int i=0;i<=9;i++) {
            System.out.print(arr[i]);

        }

        for(int j=0;j<=9;j++) {
            for(int m=1;m<=9;m+=2){
                    if (arr[j] == arr[m] && j!=m) {
                        System.out.println(" element no. " + j + " = element no." + m);
                    }
            }

        }*/
//------------------------------
        board = new String[9];
        turn="X";
        String winner = null;

        for(int a=0;a<9;a++){
            board[a] = String.valueOf(a+1);
        }
        System.out.println("welcome to tic tac toe game!");
        printBoard();
        System.out.println("X will play first, Enter a slot number to place X in:");


        while (winner==null){
            int numInput;
            try{
                numInput=scn.nextInt();
                if(!(numInput>0 && numInput<=9)){
                    System.out.println("Invalid Input! re-enter slot number: ");
                    continue;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! re-enter slot number: ");
                continue;
            }
            if(board[numInput-1].equals(String.valueOf(numInput))){
                board[numInput-1]=turn;
                if(turn.equals("X")){
                    turn="O";
                }
                else {
                    turn="X";
                }
                printBoard();
                winner=checkWinner();

            }
            else {
                System.out.println("Slot already taken; re- enter slot number");
            }
        }

        if(winner.equals("draw")){
            System.out.println("It's a draw! Thanks for playing.");
        }
        else {
            System.out.println("Congratulations! "+ winner +"'s have won! Thanks for playing.");
        }







    }
}
