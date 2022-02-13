package wordtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import guesses.LetterGuess;
import guesses.GuessList;

/**
 * 
 * @author wyatt
 *
 */
public class WordTree {
	
	private TreeNode root = new TreeNode();
	
	private GuessList yellowLetters = new GuessList();
	private GuessList greenLetters = new GuessList();
	private GuessList blackLetters = new GuessList();
	
	
	public WordTree(String filename) throws FileNotFoundException {
		
		File readFile = new File(filename);
		
		if(readFile.exists()) {
			buildTree(readFile);
		}
		else {
			System.out.println("File chosen to build WordTree does not exist.");
		}		
		
	}

	private void buildTree(File file) throws FileNotFoundException {
		
		Scanner myReader = new Scanner(file);
		
		while(myReader.hasNext()) {
			root.buildExtendedTreeNodes(myReader.next(), 0);
		}		
		
		myReader.close();
	}
	
	public void addGuess(GuessList guess) {
		
		for (LetterGuess letter : guess.getLetters() ) {
			// Here we have a perfect letter guess.
			if (letter.isPresent() && letter.isCorrectPosition()) {
				
				greenLetters.addLetterGuess(letter);
			}
			else if (letter.isPresent() && !letter.isCorrectPosition()) {
				
				yellowLetters.addLetterGuess(letter);
			}
			else {
				
				blackLetters.addLetterGuess(letter);
			}
		}
		
		pruneTree();
	}
	
	public ArrayList<String> getPossibleWords() {
		root.checkTreeForWords(greenLetters, yellowLetters, "");
		return TreeNode.getPossibleWords();
		
	}

	/**
	 * This method needs to take the last guesses black letters
	 * and do a full tree traversal, pruning branches as it goes.
	 * 
	 * Wipe the list afterwards.  No use for them after pruning.
	 */
	private void pruneTree() {
		root.resetBranchCount();
		root.pruneTree(blackLetters, yellowLetters);
		blackLetters = new GuessList();
	}
	
	public int getBranchCount() {
		return TreeNode.getBranchCount();
	}

	public void wipeGuesses() {
		root.wipeGuesses();
		
	}
}
