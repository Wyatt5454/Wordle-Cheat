package guesses;

public class LetterGuess {
	
	// letter and position indicate where the guess took place
	private char letter;
	private int position = 0;
	
	// Assigned after the guess has taken place.
	private boolean isPresent = false;
	private boolean isCorrectPosition = false;
	
	public LetterGuess(char letter, int position, char result) {
		this.letter = letter;
		this.position = position;
		
		if (result == 'y' ) {
			isPresent = true;
		}
		else if (result == 'g') {
			isPresent = true;
			isCorrectPosition = true;
		}
	}
	
	public char getLetter() {
		return letter;
	}
	
	public String getLetterAsString() {
		return "" + letter;
	}
	
	public int getPosition() {
		return position;
	}
	
	public boolean isPresent() {
		return isPresent;
	}
	
	public boolean isCorrectPosition() {
		return isCorrectPosition;
	}
}
