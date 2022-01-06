package src.TicTacToe;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        int turns = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Who will go first, x or o?");
        String first = in.nextLine().toUpperCase();
        TicTacToe board = new TicTacToe(first);
        board.printBoard();
        ;
        while(board.checkWin() == false){
            
            System.out.println("Enter column, then row: ");
            
            int col = in.nextInt();
            int row = in.nextInt();
            if(!board.pickLocation(row, col)){
            while(!board.pickLocation(row, col)){
                System.out.println("Invalid position, try again: ");
                col = in.nextInt();
                row = in.nextInt();
                if(board.pickLocation(row, col)){
                    board.takeTurn(row, col);
                    turns += 1;
                    break;
                }
            }
            if(board.checkWin() == true){
                break;
            }
            }
            else{
               board.takeTurn(row, col);
               turns += 1;
            
            }
            board.printBoard();
            if(board.checkWin() == true){
                break;
            }
            if(turns == 9 && !board.checkWin()){
            System.out.println("tie");
            break;
            }
            
        }
        
        System.out.println("Game over");
        in.close();
    }
}