import java.util.Scanner;

public class CoinFlipper {
   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.print("Enter number of coins to be flipped: ");
       int coinNum = in.nextInt();
       int tails = 0;
        
       String[] results = new String[coinNum];

       for(int i = 0; i < coinNum; i++){
           int rand = (int)(Math.random() * 2 + 1);
           if(rand == 1){
               results[i] = "Tails";
               tails += 1;
           }
           else if(rand == 2){
               results[i] = "Heads";
               
               
           }
       }
       if(coinNum < 100000){
           for(String result : results){
               System.out.println(result);
           }

       }
       System.out.println((double)((double)tails / coinNum));
       in.close(); 
   } 
}
