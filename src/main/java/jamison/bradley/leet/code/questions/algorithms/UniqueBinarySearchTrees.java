package jamison.bradley.leet.code.questions.algorithms;

public class UniqueBinarySearchTrees {
	
	//Values will be cached to speed up the calculation.
	private int[] cache;
	
	/**
	 * https://leetcode.com/problems/unique-binary-search-trees/
	 */
    public int numTrees(int n) {
    	cache = new int[n + 1];
    	solve(n);
    	return cache[n];
    }
    
    private void solve(final int n){
    	//Base case
    	if (n == 0){
    		cache[0] = 1;
    		return;
    	}
    	//Solve n - 1 first since its value will be needed to solve n.
    	solve(n - 1);
    	
    	//Number of unique trees follows this pattern shown for a tree with 4 nodes.
    	//f(4) = f(0) * f(3) + f(1) * f(2) + f(2) * f(1) + f(3) * f(0)
    	int sum = 0;
    	for (int i = 0; i < n; i++){
    		sum += cache[i] * cache[n - i - 1];
    	}
    	cache[n] = sum;
    }
}
