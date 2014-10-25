package snappy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadWords {
	public static final int ASCII_OFFSET = 97;
	public static final int NUM_OF_LETTERS = 26;

	public static void main(String[] args) {
		LetterNode[] top = makeTree();
		
		
		System.out.println("Enter a word and then press enter to see if it's in the English dictionary");
		while(true) {
			Scanner s = new Scanner(System.in);
			String word = s.nextLine();
			if(checkWord(top, word)) {
				System.out.println("Is a word");
			} else {
				System.out.println("Is not a word");
			}
			
		}

		

	}
	
	

	private static boolean checkWord(LetterNode[] top, String string) {
		if (string == "") {
			return false;
		}
		
		LetterNode[] traverse = top;
		int charNum = 0;
		for(int i = 0; i < string.length() - 1; i++) {
			charNum = string.charAt(i) - ASCII_OFFSET;
			if (traverse == null) {
				return false;
			}
			traverse = traverse[charNum].nextLetters;
		}
		charNum = string.charAt(string.length()-1) - ASCII_OFFSET;
		if (traverse == null) {
			return false;
		}
		return traverse[charNum].isWord;
	}



	private static LetterNode[] makeTree() {
		File words = new File("words.txt");

		Scanner wordScanner = null;
		Scanner letterScanner = null;
		try {
			wordScanner = new Scanner(words);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		LetterNode[] top = new LetterNode[NUM_OF_LETTERS];
		// Initialize each LetterNode in the array
		for (int j = 0; j < NUM_OF_LETTERS; j++) {
			top[j] = new LetterNode();
		}

		LetterNode[] traverseArray = null;
		LetterNode traverseLetter = null;

		int charNum = 0;

		while (wordScanner.hasNextLine()) {
			traverseArray = top;
			String word = wordScanner.nextLine();

			for (int i = 0; i < word.length(); i++) {
				// Convert first letter to number, and look at that LetterNode[]
				// index
				charNum = word.charAt(i) - ASCII_OFFSET;
				traverseLetter = traverseArray[charNum];
				//if we made a word, indicate with a 'true'
				if(i == word.length() - 1) {
					traverseLetter.isWord = true;
				}

				if (traverseArray[charNum].nextLetters == null) {
					traverseArray[charNum].nextLetters = new LetterNode[NUM_OF_LETTERS];
					// Initialize each LetterNode in the array
					for (int j = 0; j < NUM_OF_LETTERS; j++) {
						traverseArray[charNum].nextLetters[j] = new LetterNode();
					}
				}

				traverseArray = traverseLetter.nextLetters;
			}

		}
		return top;
	}

}
