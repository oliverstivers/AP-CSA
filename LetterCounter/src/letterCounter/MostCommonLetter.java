package letterCounter;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class MostCommonLetter {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
		File f = new File("mobydick.txt");
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
		}
		
		HashMap<String, Integer> letters = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			if(!letters.containsKey(list.get(i)) && !list.get(i).equals(" ")) {
				letters.put(list.get(i), 1);
			}
			else if(!list.get(i).equals(" ")){
				Integer count = letters.get(list.get(i));
				letters.replace(list.get(i), count + 1);
			}
		}
		System.out.println(letters);
		

	}

}
