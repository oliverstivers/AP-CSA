
public class CombinationLock {
	private String combo;
	public CombinationLock(String combo) {
		this.combo = combo;
	}
	public String getClue(String clue) {
		String newString = "";
		for(int i = 0; i < clue.length(); i++) {
			if(clue.substring(i, i+1).equals(combo.substring(i, i+1))) {
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
