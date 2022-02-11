package guesses;

public class LetterGuess {
	
	// letter and position indicate where the guess took place
	private char letter;
	private int position = 0;
	
	// Assigned after the guess has taken place.
	private boolean isPresent = false;
	private boolean isCorrectPosition = false;
	
	
	public char getLetter() {
		return letter;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public boolean isPresent() {
		return isPresent;
	}
	
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}
	
	public boolean isCorrectPosition() {
		return isCorrectPosition;
	}
	
	public void setCorrectPosition(boolean isCorrectPosition) {
		this.isCorrectPosition = isCorrectPosition;
	}
}
