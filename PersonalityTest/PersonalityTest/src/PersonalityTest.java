import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
public class PersonalityTest extends PersonalityTestMethods{
    public static void main(String[] args) throws FileNotFoundException {
         ArrayList<String> names = new ArrayList<>();
         ArrayList<String> answers = new ArrayList<>();
         File f = new File("c:/users/olive/documents/github/ap-csa/personalitytest/personalitytest/testFile.txt");
         nameAndAnswerArray(names, answers, f);
         System.out.println(names);
         System.out.println(answers);
         ArrayList<String> personality = getPersonality(answers.get(0));
         System.out.println(personality);
    }
}
