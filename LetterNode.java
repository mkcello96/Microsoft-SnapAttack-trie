package snappy;

public class LetterNode {
	public Boolean isWord;
	public LetterNode[] nextLetters;
	
	public LetterNode() {
		this.isWord = false;
		this.nextLetters = null;
	}

}
