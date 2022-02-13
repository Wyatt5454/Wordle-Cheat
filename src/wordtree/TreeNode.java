/**
 * 
 */
package wordtree;

import java.util.ArrayList;

import guesses.GuessList;
import guesses.LetterGuess;

/**
 * Holds a letter which represents a branch traversal, and the 
 * list of nodes.
 * 
 * @author wyatt
 *
 */
public class TreeNode {
	
	private char letter;
	private ArrayList<TreeNode> nodes = new ArrayList<>();
	private int position = 0;
	
	private static int branchCount = 0;
	private static ArrayList<String> possibleWords = new ArrayList<>();
	
	private boolean isRoot = false;
	
	public TreeNode() {
		this.isRoot = true;
		position = -1;
	}
	
	public TreeNode(char letter, int position) {
		this.setLetter(letter);
		this.position = position;
		branchCount = getBranchCount() + 1;
	}
	
	/**
	 * Used to build additional TreeNodes if they are
	 * necessary to build.  Calls itself until we've 
	 * built the TreeNode for the 5th letter.
	 * @param word
	 * @param position
	 */
	public void buildExtendedTreeNodes(String word, int position) {
		
		// Quit the loop when we get to the 5th letter
		if (position > 4) {
			return;
		}
		
		// Check the next letter we need to make a node for
		char nextLetter = word.charAt(position);
		
		// Check to see if the letter already exists here.
		for ( TreeNode node : nodes ) {
			// No need to build a TreeNode if one already exists
			if (nextLetter == node.getLetter() ) {
				node.buildExtendedTreeNodes(word, ++position);
				return;
			}
		}
		
		// Here we know the next letter needs a new TreeNode
		TreeNode nextNode = new TreeNode(nextLetter, position);
		nodes.add(nextNode);
		nextNode.buildExtendedTreeNodes(word, ++position);
		
		
		return;
	}
	
	/**
	 * Do a full tree traversal, removing dead branches
	 * as we go.
	 * 
	 * Reset the total branch count and recount it as
	 * we traverse.
	 * 
	 * @param blackLetters
	 */
	public void pruneTree(GuessList blackLetters, GuessList yellowLetters) {
		
		ArrayList<TreeNode> nodesToRemove = new ArrayList<>();
		
		for (TreeNode node : nodes ) {
			
			if (blackLetters.containsLetter(node.getLetter())) {
				nodesToRemove.add(node);
			}
			else if (yellowLetters.containsLetterAtPosition(node.getLetter(), node.getPosition())) {
				nodesToRemove.add(node);
			}
			else {
				branchCount++;
				node.pruneTree(blackLetters, yellowLetters);
			}
		}
		
		nodes.removeAll(nodesToRemove);
	}
	
	public void checkTreeForWords(GuessList greenLetters, GuessList yellowLetters, String currentTraversal) {
		
		// We know we are at the bottom of the tree.
		if (position == 4) {
			assessGuess(currentTraversal, yellowLetters);
			return;
		}
		
		// First check if we have a green letter here.
		ArrayList<LetterGuess> nextPosition = greenLetters.getLettersAtPosition(this.position + 1);
		
		// Always traverse a green node if possible
		if (!nextPosition.isEmpty()) {
			//Check if it is possible to traverse to the green letter
			for (TreeNode node : nodes) {
				if (nextPosition.get(0).getLetter() == node.getLetter()) {
					StringBuilder nextTraversal = new StringBuilder(currentTraversal);
					nextTraversal.append(nextPosition.get(0).getLetter());
					node.checkTreeForWords(greenLetters, yellowLetters, nextTraversal.toString());
					return;
				}
			}			
		}
		// Try everything that hasn't been tried.
		else {
			for (TreeNode node : nodes ) {
				StringBuilder nextTraversal = new StringBuilder(currentTraversal);
				nextTraversal.append(node.getLetter());
				node.checkTreeForWords(greenLetters, yellowLetters, nextTraversal.toString());
			}
		}
		
		return;
	}

	/**
	 * Check to see if our guess contains each of the yellow letters.
	 * If it does, this is a legitimate guess.
	 * 
	 * @param currentTraversal
	 * @param yellowLetters
	 */
	private void assessGuess(String guess, GuessList yellowLetters) {
		
		for (LetterGuess letter : yellowLetters.getLetters() ) {
			if (!guess.contains(new StringBuilder(letter.getLetterAsString()))) {
				
				// Here our guess does not contain a yellow letter.  Reject it.
				return;
			}
		}
		
		possibleWords.add(guess);
		
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public ArrayList<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<TreeNode> nodes) {
		this.nodes = nodes;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public int getPosition() {
		return position;
	}

	public static int getBranchCount() {
		return branchCount;
	}
	
	public void resetBranchCount() {
		branchCount = 0;
	}

	public static ArrayList<String> getPossibleWords() {
		return possibleWords;
	}

	public void wipeGuesses() {
		possibleWords.clear();
	}

	

}
