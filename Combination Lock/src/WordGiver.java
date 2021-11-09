public class WordGiver {
    public static int giveRandom(String[] wordList) {
        return (int)(Math.random() * wordList.length);
    }
}