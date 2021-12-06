

public class DayFinderFormulas {
    public static int total = 0;
    public static void getDay(int day, int month, int year){
        
        total += day;
        System.out.println("Day " + day + " month " + month + " year " + year);
        
        if(month == 1 || month == 10){
            total += 1;
            
        }
        else if(month == 2 || month == 3 || month == 11){
            total += 4;


        }
        else if(month == 5){
            total += 2;

        }
        else if(month == 6){
            total += 5;

        }
        else if(month == 8){
            total += 3;

        }
        else if(month == 9 || month == 12){
            total += 6;
            

        }
        int century = (int)(year / 100);
        century = century % 4;
        boolean added = false;
        if(century == 0 && added == false){
            total += 6;
            System.out.println("year is 2000");
            added = true;
            System.out.println(added);
        }
        else if(century == 1 && added == false){
            total += 4;
            System.out.println("year is 1700");
            added = true;
        }
        else if(added != true && century == 2);{
            total += 2;
            System.out.println("year is 1800");
        }
        
        int yearNum = year % 100;
        total += yearNum;
        total += (yearNum / 4);
        int weekDay = total % 7;
        
        System.out.println(weekDay);
        if(weekDay == 0){
            System.out.println("Saturday");
        }
        else if(weekDay == 1){
            System.out.println("Sunday");
        }
        else if(weekDay == 2){
            System.out.println("Monday");
        }
        else if(weekDay == 3){
            System.out.println("Tuesday");
        }
        else if(weekDay == 4){
            System.out.println("Wednesday");
        }
        else if(weekDay == 5){
            System.out.println("Thursday");
        }
        else if(weekDay == 6){
            System.out.println("Friday");
        }
    }
    public static void getCentury(){
        
    }
}
