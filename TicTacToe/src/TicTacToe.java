public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
    private String[][] board = new String[3][3];
    private String first;
    public TicTacToe(String first){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = "-";
            }
        }
        this.first = first;
    }
   private int turn = 0;
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.println("  0 1 2");
       for(int i = 0; i < board.length; i++){
            System.out.print(i + " ");    
           for(int j = 0; j < board[i].length; j++){
               System.out.print(board[i][j] + " ");
           }
           System.out.println();
       }
   }
   
   //This method returns true if space row, col is a valid space
  public boolean pickLocation(int row, int col)
  {
       if(row >= 0 && row <= 2 && col >= 0 && col <= 2){
           if(board[row][col].equals("-")){
               return true;
           }
           else{
               return false;
           }
       }
       else{
           return false;
       }
  }
   
  //This method places an X or O at location row,col based on the int turn
  public void takeTurn(int row, int col)
  {
       if(turn % 2 == 0 && pickLocation(row, col)){
           board[row][col] = first;
           turn += 1;
       }
       else if(turn % 2 == 1 && pickLocation(row, col)){
           if(first.equalsIgnoreCase("X")){
             board[row][col] = "O";
           }
           if(first.equalsIgnoreCase("O")){
            board[row][col] = "X";
           }
           
           turn += 1;
       }
  }
   
  //This method returns a boolean that returns true if a row has three X or O's in a row
  public boolean checkRow()
  {
      int counter = 0;
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[i].length; j++){
               if(board[i][j].equalsIgnoreCase("X")){
                   counter += 1;
                   if(counter >= 3){
                       System.out.println("X wins!");
                       return true;
                   }
                   continue;
               }
               else{
                   break;
               }
           }
           counter = 0;
       }
       if(counter >= 3){

           return true;
       }
       
       counter = 0;
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[i].length; j++){
               if(board[i][j].equalsIgnoreCase("O")){
                   counter += 1;
                   if(counter >= 3){
                    System.out.println("O wins!");
                    return true;
                }
                   continue;
               }
               else{
                   break;
               }
           }
           counter = 0;
       }
       
       return false;
  }
   
    //This method returns a boolean that returns true if a col has three X or O's
  public boolean checkCol()
  {
      int counter = 0;
       for(int row = 0; row < board.length; row++){
           for(int col = 0; col < board[row].length; col++){
               if(board[col][row].equalsIgnoreCase("X")){
                   
                   counter += 1;
                   if(counter >= 3){
                       System.out.println("X wins!");
                       return true;
                   }
                   continue;
               }
               else{
                   break;
               }
               
           }
           counter = 0;
       }
       
       
       counter = 0;
       for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
               if(board[col][row].equalsIgnoreCase("O")){
                   counter += 1;
                   if(counter >= 3){
                    System.out.println("O wins!");
                       return true;
                   }
                   continue;
               }
               else{
                   break;
               }
               
               
           }
           counter = 0;
       }
       if(counter >= 3){
           return true;
       }
       return false;
  }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
  public boolean checkDiag()
  {
        if(board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")){
          System.out.println("X wins!");
          return true;
        }
        if(board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")){
            System.out.println("O wins!");
            return true;
        }
        if(board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O")){
            System.out.println("O wins!");
            return true;
        }
        if(board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X")){
            System.out.println("X wins!");
            return true;
        }
        return false;
      
  }
   
  //This method returns a boolean that checks if someone has won the game
  public boolean checkWin()
  {
       if(checkDiag() || checkRow() || checkCol()){
           return true;
       }
       else{
           return false;
       }
  }

}