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
	
	public boolean containsLetterAtPosition(char letter, int position) {
		for (LetterGuess guess : letters) {
			if (guess.getLetter() == letter && guess.getPosition() == position) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Used to get the positions where guesses have taken place.
	 * @param position
	 * @return
	 */
	public ArrayList<LetterGuess> getLettersAtPosition(int position) {
		ArrayList<LetterGuess> lettersAtPosition = new ArrayList<LetterGuess>();
		
		for (LetterGuess guess : letters ) {
			if (guess.getPosition() == position) {
				lettersAtPosition.add(guess);
			}
		}
		
		return lettersAtPosition;
	}
	
	/**
	 * Used to get the list of letters that are yellow, and 
	 * have not been guessed in a certain position.
	 * @param position
	 * @return
	 */
	public ArrayList<LetterGuess> getLettersNotAtPosition(int position) {
		ArrayList<LetterGuess> lettersNotAtPosition = new ArrayList<LetterGuess>();
		
		for (LetterGuess guess : letters ) {
			if (guess.getPosition() != position) {
				lettersNotAtPosition.add(guess);
			}
		}
		
		ArrayList<LetterGuess> removeList = new ArrayList<LetterGuess>();
		
		// This loop removes a letter if it has been guessed
		// in the current position.
		for (LetterGuess guess : lettersNotAtPosition ) {
			for (LetterGuess guessCheck : letters ) {
				if (guess.getLetter() == guessCheck.getLetter()) {
					if (guessCheck.getPosition() == position) {
						removeList.add(guess);
					}
				}
			}
		}
		
		lettersNotAtPosition.removeAll(removeList);
		
		
		return lettersNotAtPosition;
		
	}

	public ArrayList<LetterGuess> getLetters() {
		return this.letters;
	}
}
