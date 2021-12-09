package CombinationLock;
public class CombinationLock {
	private String combo;
    
	public CombinationLock(String combo) {
		this.combo = combo;
	}
	public String getClue(String clue) {
		String newString = "";
        String[] letterList = new String[clue.length()];
        for(int i = 0; i < clue.length(); i++){
            letterList[i] = clue.substring(i, i+1);
        }
		for(int i = 0; i < clue.length(); i++) {
			if(letterList[i].equals(combo.substring(i, i+1))) {
				newString += clue.substring(i, i+1);
			}
			else if(combo.contains(clue.substring(i, i+1))) {
				newString += "+";
			}
			else {
				newString += "*";
			}
		}
		return  newString;
	}
    public String getCombo(){
        return combo;
    }
}
