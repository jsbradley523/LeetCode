package jamison.bradley.leet.code.questions.algorithms;

import java.util.List;

public class Triangle {
	/**
	 * https://leetcode.com/problems/triangle/
	 */
    public int minimumTotal(List<List<Integer>> triangle) {
    	//Empty triangle has no sum.
        if (triangle == null || triangle.isEmpty()){
        	return 0;
        }
        
        int[] sums = new int[triangle.size()];
        sums[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++){
        	//Start at right side of new row and work to the left choosing the smaller value
        	//from the above choices (which in this case will be the values already in sums).
        	for (int j = triangle.get(i).size() - 1; j >= 0; j--){
        		//The farthest right element in the row can only be reached through the farthest right
        		//element in the row above.
        		if (j == triangle.get(i).size() - 1){
        			sums[j] = sums[j - 1] + triangle.get(i).get(j);
        			continue;
        		}
        		//Likewise the farthest left can only be reached from the farthest left in the row above.
        		else if (j == 0){
        			sums[0] = sums[0] + triangle.get(i).get(0);
        			continue;
        		}
        		
        		//Left parent in row above is smaller than right.
        		if (sums[j - 1] < sums[j]){
        			sums[j] = sums[j - 1] + triangle.get(i).get(j);
        		} else {
        			sums[j] = sums[j] + triangle.get(i).get(j);
        		}
        	}
        }
        
        //Find the smallest value in sums.
        int min = sums[0];
        for (int i = 1; i < sums.length; i++){
        	if (sums[i] < min){
        		min = sums[i];
        	}
        }
        return min;
    }
}
