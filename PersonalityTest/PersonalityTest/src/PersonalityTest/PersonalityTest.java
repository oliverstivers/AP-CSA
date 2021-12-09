package PersonalityTest;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
public class PersonalityTest extends PersonalityTestMethods{
    public static void main(String[] args) throws FileNotFoundException {
         ArrayList<String> names = new ArrayList<>();
         ArrayList<String> answers = new ArrayList<>();
         introduce();
         Scanner in = new Scanner(System.in);
         System.out.print("input file name? ");
         File f = new File(in.next());
         System.out.print("output file name? ");
         File output = new File(in.next());
         PrintStream printStream = new PrintStream(output);
         nameAndAnswerArray(names, answers, f);
         
         
         ArrayList<Integer> percentList = new ArrayList<>();
         
         for(int i = 0; i < names.size(); i++){
             String thisPersonality = getPersonality(answers.get(i), percentList);

             printStream.print(names.get(i) + ": " + percentList + " = " + thisPersonality);
             printStream.println();
             percentList.clear();
         }
         
         printStream.close();
         in.close();
    }
}
