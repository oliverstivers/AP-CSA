package DayFinderPack;
import java.util.Scanner;

public class DayFinder extends DayFinderFormulas{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter day number: ");
        int day = in.nextInt();
        System.out.println("Enter month number: ");
        int month = in.nextInt();
        System.out.println("Enter year (4 digits):");
        int year = in.nextInt();
        getDay(day, month, year);
        
        
        
        in.close();
    }

}
