package wordtree;

import java.util.ArrayList;

public class WordGuess {
	
	// A WordGuess always consists of 5 letters
	private ArrayList<LetterGuess> letters = new ArrayList<>(5);
	
	
	public void addLetterGuess(LetterGuess letter) {
		if (letters.size() < 5) {
			this.letters.add(letter);
		}
	}
	
	public ArrayList<LetterGuess> getCorrectLetters() {
		
		ArrayList<LetterGuess> correctLetters = new ArrayList<>();
		
		for (LetterGuess letter : letters) {
			if (letter.isPresent()) {
				correctLetters.add(letter);
			}
		}
		
		return correctLetters;
	}
}
