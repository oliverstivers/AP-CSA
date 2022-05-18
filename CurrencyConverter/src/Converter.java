import java.util.HashMap;

public class Converter {
    private static HashMap<String, Double> rates = new HashMap<>(){
        {
            put("EURO", 0.95);
            put("YEN", 128.23);
            put("CAD", 1.28);
            put("POUND", 0.81);
            put("USD", 1.0);
        }
    };
    
    public static double convert(String start, String end, double amt){
        double dollarAmt = amt / rates.get(start.toUpperCase());        
        double result = (double)(Math.round(dollarAmt * rates.get(end.toUpperCase()) * 100.00) / 100.00);
        return result;
    }
    
    
    

   
}
