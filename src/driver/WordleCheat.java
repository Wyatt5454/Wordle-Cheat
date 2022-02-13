package driver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import guesses.LetterGuess;
import guesses.GuessList;
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
		
		System.out.print("WordTree build successfully.  Contains " + tree.getBranchCount() + " branches.");
		
		// Now we have our word tree built, so we need to ask the user for their guess
		for (int turn = 1; turn < 7; turn++) {
			
			GuessList guess = new GuessList();
			Scanner in = new Scanner(System.in);
			
			System.out.print("Your Guess?\n");
			String word = in.nextLine();
			
			System.out.print("\n Enter the results in this format: xxxxx\n b for black, y for yellow, and g for green.\n");
			String results = in.nextLine();
			
			for (int i = 0; i < 5; i++) {
				guess.addLetterGuess(new LetterGuess(word.charAt(i), i, results.charAt(i)));
			}
			
			tree.addGuess(guess);
			
			System.out.print("WordTree altered.  Contains " + tree.getBranchCount() + " branches.");
			
			
			System.out.print("\n\nPossible answers:\n\n");
			
			tree.wipeGuesses();
			ArrayList<String> possibleAnswers = tree.getPossibleWords();
			
			StringBuilder builder = new StringBuilder();
			
			for (String answer : possibleAnswers ) {
				builder.append(answer);
				builder.append('\t');
			}
			
			System.out.println(builder.toString());
			
			
			
		}
		

	}

}
