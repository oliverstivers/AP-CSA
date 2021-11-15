package letterCounter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
import java.lang.*;
public class MostCommonLetter {

	public static void main(String[] args) throws FileNotFoundException{
		
		
		File f = new File("harrypotter.txt");
		Scanner in = new Scanner(f);
		ArrayList<String> list = new ArrayList<>();
		while(in.hasNext()) {
			String line = in.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter("");
			while(lineScanner.hasNext()) {
				String letter = lineScanner.next();
				list.add(letter.toLowerCase());

			}
            lineScanner.close();
		}
		
		HashMap<String, Integer> letters = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
            
            String s = list.get(i);
			if(!letters.containsKey(list.get(i)) && Character.isLetter(s.charAt(0))) {
				letters.put(list.get(i), 1);
			}
			else if(!list.get(i).equals(" ") && Character.isLetter(s.charAt(0))){
				Integer count = letters.get(list.get(i));
				letters.replace(list.get(i), count + 1);
			}
		}
		List<Map.Entry<String, Integer>> entry = new LinkedList<Map.Entry<String, Integer>>(letters.entrySet());
        Collections.sort(entry, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));
        HashMap<String, Integer> sorted = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> aa : entry){
            sorted.put(aa.getKey(), aa.getValue());
        }
        sorted.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    
        in.close();
	}
    

}
