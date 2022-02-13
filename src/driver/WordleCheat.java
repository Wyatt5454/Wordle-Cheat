package driver;

import java.io.FileNotFoundException;
import java.util.Scanner;

import guesses.LetterGuess;
import guesses.WordGuess;
import wordtree.WordTree;

/**
 *  Main driver for the application
 *
 */
public class WordleCheat {
	
	static WordTree tree;

	public static void main(String[] args) {
		
		try {
			tree = new WordTree("C:\\Users\\wyatt\\eclipse-workspace\\Wordle Cheat\\WordLists\\5letterwords.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.print("WordTree build successfully.");
		
		// Now we have our word tree built, so we need to ask the user for their guess
		for (int turn = 1; turn < 7; turn++) {
			
			WordGuess guess = new WordGuess();
			Scanner in = new Scanner(System.in);
			
			System.out.print("Your Guess?\n");
			String word = in.nextLine();
			
			System.out.print("\n Enter the results in this format: xxxxx\n b for black, y for yellow, and g for green.");
			String results = in.nextLine();
			
			for (int i = 0; i < 5; i++) {
				guess.addLetterGuess(new LetterGuess(word.charAt(i), i, results.charAt(i)));
			}
			
			System.out.print("\nPossible answers:\n\n");
			
			
			
		}
		

	}

}
