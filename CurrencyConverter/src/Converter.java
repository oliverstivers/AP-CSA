import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Converter {
    private static HashMap<String, Double> rates = new HashMap<>(){
        {
            put("EUR", 0.95);
            put("JPY", 128.23);
            put("CAD", 1.28);
            put("GBP", 0.81);
            put("USD", 1.0);
        }
    };
    
    public static double convert(String start, String end, double amt) throws IOException{
        update(start, end);
        double dollarAmt = (double)amt / (double)rates.get(start.toUpperCase()); 
               
        double result = (double)(Math.round((dollarAmt * rates.get(end.toUpperCase())) * 100.00 )) / 100.00;
        return result;
    }
    public static void update(String start, String end) throws IOException{
        
        String url_str = "https://v6.exchangerate-api.com/v6/d49c8370e3797128a2ffbb38/latest/USD";
        
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        
        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        
        // Accessing object
        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        
        rates.put(start, req_result.get(start).getAsDouble());
        rates.put(end, req_result.get(end).getAsDouble());
        
        
    

    }
    
    
    

   
}
