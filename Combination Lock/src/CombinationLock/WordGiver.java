package CombinationLock;

import java.util.*;
public class WordGiver {
    public static int giveRandom(ArrayList<String> list) {
        return (int)(Math.random() * list.size());
    }
}