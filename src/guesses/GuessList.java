package guesses;

import java.util.ArrayList;

/**
 * This class holds a collection of LetterGuesses that
 * need to be recorded.  Used to collect a guess from a 
 * user in the form of a word.  Also used to record previous
 * guesses for use in tree traversals.
 * 
 * @author wyatt
 *
 */
public class GuessList {
	
	private ArrayList<LetterGuess> letters = new ArrayList<>();
	
	
	/**
	 * Add if its not a duplicate.
	 * @param letter
	 */
	public void addLetterGuess(LetterGuess letter) {
		if (!letters.contains(letter)) {
			this.letters.add(letter);
		}
	}
	
	public boolean containsLetter(char letter) {
		
		for (LetterGuess guess : letters) {
			if (guess.getLetter() == letter) {
				return true;
			}
		}
		
		return false;
		
	}

	public ArrayList<LetterGuess> getLetters() {
		return this.letters;
	}
}
