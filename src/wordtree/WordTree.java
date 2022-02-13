package wordtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import guesses.LetterGuess;
import guesses.WordGuess;

/**
 * 
 * @author wyatt
 *
 */
public class WordTree {
	
	private TreeNode root = new TreeNode();
	
	private ArrayList<LetterGuess> yellowLetters = new ArrayList<>();
	private ArrayList<LetterGuess> greenLetters = new ArrayList<>();
	private ArrayList<LetterGuess> blackLetters = new ArrayList<>();
	
	
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
	
	public void addGuess(WordGuess guess) {
		ArrayList<LetterGuess> letters = guess.getLetters();
		
		for (LetterGuess letter : letters ) {
			// Here we have a perfect letter guess.
			if (letter.isPresent() && letter.isCorrectPosition()) {
				
				if (!greenLetters.contains(letter)) {
					greenLetters.add(letter);
				}
			}
			else if (letter.isPresent() && !letter.isCorrectPosition()) {
				
				//TODO: Change so that yellow letter guesses position's are recorded.
				if (!yellowLetters.contains(letter)) {
					yellowLetters.add(letter);
				}
				
			}
			else {
				if (!blackLetters.contains(letter)) {
					blackLetters.add(letter);
				}
			}
		}
		
		pruneTree();
	}

	/**
	 * This method needs to take the last guesses black letters
	 * and do a full tree traversal, pruning branches as it goes.
	 */
	private void pruneTree() {
		// TODO make it dummy.
		
	}
}
