package letterCounter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;
import java.io.*;
public class MostCommonLetter {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a file path: ");
		File f = new File(user.nextLine());
		Scanner in = new Scanner(f);
		ArrayList<String> list = new ArrayList<>();
		while(in.hasNext()) {
			String line = in.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter("");
			while(lineScanner.hasNext()) {
				String letter = lineScanner.next();
				System.out.println(letter);
                letter = letter.replaceAll("[^a-zA-Z]", "");
                if(!letter.equals("")){
                    list.add(letter.toUpperCase());
                }
				

			}
            lineScanner.close();
		}
		
		HashMap<String, Integer> letters = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
            
            
			if(!letters.containsKey(list.get(i))) {
				letters.put(list.get(i), 1);
			}
			else if(!(list.get(i).equals(" ") || list.get(i).equals(""))){
				Integer count = letters.get(list.get(i));
				letters.replace(list.get(i), count + 1);
			}
		}
		List<Map.Entry<String, Integer>> entry = new LinkedList<Map.Entry<String, Integer>>(letters.entrySet());
        Collections.sort(entry, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));
        List<Map.Entry<String, Integer>> reversed = new LinkedList<Map.Entry<String, Integer>>();
        for(int i = entry.size() - 1; i >=0; i--){
            reversed.add(entry.get(i));
        }
        HashMap<String, Integer> sorted = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> aa : reversed){
            sorted.put(aa.getKey(), aa.getValue());
        }
        
        int minLetter = Integer.MAX_VALUE;
        int maxLetter = Integer.MIN_VALUE;
        String minLetterChar = "";
        String maxLetterChar = "";
        List<Integer> numList = new ArrayList<>();
        List<String> charList = new ArrayList<>();
        
        
        charList.add(minLetterChar);
        charList.add(maxLetterChar);
        numList.add(minLetter);
        numList.add(maxLetter);
        
        sorted.forEach((key, value) -> {
            
            if(value < numList.get(0)){
                numList.set(0, value);
                charList.set(0, key);
            }
            if(value > numList.get(1)){
                numList.set(1, value);
                charList.set(1, key);
            }
        });
        
        System.out.println("The least common letter in the text is " + charList.get(0) + " with " + numList.get(0) + " occurrences.");
        System.out.println("The most common letter in the text is " + charList.get(1) + " with " + numList.get(1) + " occurrences.");
        System.out.println("Would you like the see the full letter list and percentages? (y or n): ");
        String answer = user.nextLine();
        while(!(answer.equals("y") || answer.equals("n"))){
            System.out.println("Symbol " + answer + " ot recognized, please try again: ");
            answer = user.nextLine();
        }
        if(answer.toLowerCase().equals("y")){
            sorted.forEach((key, value) -> {
                System.out.println(key + " " + value);
            });
            System.out.println("Percentages: ");
            sorted.forEach((key, value) -> {
                System.out.println(key + " " + (double)value / (double)list.size() * 100);
            });
            
        }
        System.out.println("Would you like to export csv? (y or n): ");
        String csvAns = user.nextLine();
        if(csvAns.toLowerCase().equals("y")){
            System.out.println("Enter file path and name to write csv to: ");
            String csvPath = user.nextLine();
            String csvName = user.nextLine();
            try{
                BufferedWriter bw = new BufferedWriter(
                new FileWriter(csvPath + "\\" + csvName + ".csv"));
                for(Map.Entry<String, Integer> line: sorted.entrySet()){
                    bw.write(line.getKey() + "," + line.getValue());
                    bw.newLine();
                }
                BufferedWriter percent = new BufferedWriter(new FileWriter(csvPath + "\\" + csvName + "percents.csv"));
                for(Map.Entry<String, Integer> percentLine: sorted.entrySet()){
                    percent.write(percentLine.getKey() + "," + (double)percentLine.getValue() / list.size() * 100);
                    percent.newLine();
                }
                percent.flush();
                percent.close();
                bw.flush();
                bw.close();
                
            }
            catch(Exception e){
                user.close();
                in.close();
                return;
            }
            
        }

    
        in.close();
        user.close();
	}
    

}
