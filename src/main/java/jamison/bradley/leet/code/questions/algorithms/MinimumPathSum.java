package jamison.bradley.leet.code.questions.algorithms;

public class MinimumPathSum {
	/**
	 * https://leetcode.com/problems/minimum-path-sum/
	 */
    public int minPathSum(int[][] grid) {
    	//If the grid is empty the sum is zero.
        if (grid == null || grid.length == 0){
        	return 0;
        }
        
        //Find the minimum sum for each index in the grid. The result can be stored in the
        //grid itself to prevent the need for allocating new memory.
        int longestSide = grid.length > grid[0].length ? grid.length : grid[0].length;
        for (int n = 0; n < longestSide; n++){
        	//Find the path sum for all the indexes in the row.
        	if (n < grid.length){
		        for (int i = n; i < grid[0].length; i++){
		        	grid[n][i] = minSum(grid, i, n);
		        }
        	}
	        //Find the path sum for all indexes in the column.
        	if (n < grid[0].length){
		        for (int j = n + 1; j < grid.length; j++){
		        	grid[j][n] = minSum(grid, n, j);
		        }
        	}
        }
        
        //The min sum for each square in the grid has been calculated so the return result
        //is the value at the goal index.
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
    private int minSum(int[][] grid, int x, int y){
    	//The is starting point of the search so the value at that point is the min sum for it.
    	if (x == 0 && y == 0){
    		return grid[0][0];
    	}
    	
    	//Check what the sum would be if the index is accessed from the left.
    	int fromLeft = -1;
    	if (x - 1 >= 0){
    		fromLeft = grid[y][x - 1] + grid[y][x];
    	}
    	
    	//Check what the sum would be if the index is accessed from above.
    	int fromAbove = -1;
    	if (y - 1 >= 0){
    		fromAbove = grid[y - 1][x] + grid[y][x];
    	}
    	
    	//If either test sum is -1 that means there wasn't an index to the left/above.
    	if (fromLeft == -1){
    		return fromAbove;
    	} else if (fromAbove == -1){
    		return fromLeft;
    	}
    	//Pick the minimum sum.
    	return Math.min(fromAbove, fromLeft);
    }
    
}
