package jamison.bradley.leet.code.questions.algorithms;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	/**
	 * https://leetcode.com/problems/word-search/
	 */
    public boolean exist(char[][] board, String word) {
    	//Can't find a word in an empty array.
        if (board == null || board.length == 0){
        	return false;
        }
        
        //Look for the first character in the word.
        for (int j = 0; j < board.length; j++){
        	for (int i = 0; i < board[j].length; i++){
        		if (board[j][i] == word.charAt(0)){
        			//The target word is only one char and that char has been found.
        			if (word.length() == 1){
        				return true;
        			}
        			
        			final Set<Point> visitedPoints = new HashSet<Point>();
        			final Point currentPoint = new Point(j, i);
        			visitedPoints.add(currentPoint);
        			if (search(board, word, currentPoint, visitedPoints)){
        				return true;
        			}
        		}
        	}
        }
        //The word was not found.
        return false;
    }
    
    private boolean search(final char[][] board, final String target, final Point lastPoint, final Set<Point> visitedPoints){
    	//The whole word has been found.
    	if (visitedPoints.size() == target.length()){
    		return true;
    	}
    	
    	final char nextLetter = target.charAt(visitedPoints.size());
    	//Check the point above the last point to see if it is the next letter.
    	if (lastPoint.y - 1 >= 0 && board[lastPoint.y - 1][lastPoint.x] == nextLetter){
    		final Point above = new Point(lastPoint.y - 1, lastPoint.x);
    		if (!visitedPoints.contains(above)){
    			visitedPoints.add(above);
    			if (search(board, target, above, visitedPoints)){
    				return true;
    			}
    			visitedPoints.remove(above);
    		}
    	}
    	//Check the point to the right of the last point.
    	if (lastPoint.x + 1 < board[0].length && board[lastPoint.y][lastPoint.x + 1] == nextLetter){
    		final Point right = new Point(lastPoint.y, lastPoint.x + 1);
    		if (!visitedPoints.contains(right)){
    			visitedPoints.add(right);
    			if (search(board, target, right, visitedPoints)){
    				return true;
    			}
    			visitedPoints.remove(right);
    		}
    	}
    	//Check the point below the last point.
    	if (lastPoint.y + 1 < board.length && board[lastPoint.y + 1][lastPoint.x] == nextLetter){
    		final Point below = new Point(lastPoint.y + 1, lastPoint.x);
    		if (!visitedPoints.contains(below)){
    			visitedPoints.add(below);
    			if (search(board, target, below, visitedPoints)){
    				return true;
    			}
    			visitedPoints.remove(below);
    		}
    	}
    	//Check the point to the left of the last point.
    	if (lastPoint.x - 1 >= 0 && board[lastPoint.y][lastPoint.x - 1] == nextLetter){
    		final Point left = new Point(lastPoint.y, lastPoint.x - 1);
    		if (!visitedPoints.contains(left)){
    			visitedPoints.add(left);
    			if (search(board, target, left, visitedPoints)){
    				return true;
    			}
    			visitedPoints.remove(left);
    		}
    	}
    	
    	return false;
    }
    
    private class Point {
    	int x;
    	int y;
    	
    	private Point(final int y, final int x){
    		this.y = y;
    		this.x = x;
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    }
}
