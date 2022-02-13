package driver;

import java.io.FileNotFoundException;

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

	}

}
