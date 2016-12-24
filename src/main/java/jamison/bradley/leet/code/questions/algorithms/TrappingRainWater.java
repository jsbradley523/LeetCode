package jamison.bradley.leet.code.questions.algorithms;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */
    public int trap(int[] height) {
    	//Can't trap water if there are two or less heights as two heights are needed to create a 
    	//boundary for the "puddle".
        if (height == null || height.length <= 2){
        	return 0;
        }
        
        /*
         * Run through the list of heights and look for local maximums. Not all local maximums
         * will be kept though because a local max in a valley between two larger maxes isn't going
         * to be a boundary for trapping any water.
         */
        final List<Integer> localMaxIndexes = new ArrayList<Integer>();
        int peakIndex = -1;
        for (int i = 0; i < height.length; i++){
        	//Local maximum found.
        	if ((i - 1 < 0 || height[i] >= height[i - 1])){ 
        			//&& (i + 1 >= height.length || height[i] >= height[i + 1])){
        		//No peak has been set yet.
        		if (peakIndex == -1){
        			localMaxIndexes.add(i);
        			peakIndex = 0;
        			continue;
        		} 
    			//Delete local max values to the left of this one that are smaller than the current
        		//max since this max will be capable of holding water above them.
    			for (int j = localMaxIndexes.size() - 1; j > peakIndex; j--){
    				if (height[localMaxIndexes.get(j)] > height[i]){
    					break;
    				}
    				localMaxIndexes.remove(j);
    			}
    			localMaxIndexes.add(i);
    			//Current local max is the largest seen so far.
    			if (height[i] >= height[localMaxIndexes.get(peakIndex)]){
    				peakIndex = localMaxIndexes.size() - 1;
    			}
        	}
        }
        
        //Sum the amount of water trapped between each local maximum up to the peak.
        int sum = 0;
        for (int i = 0; i < peakIndex; i++){
        	int leftBoundary = height[localMaxIndexes.get(i)];
        	int rightBoundary = height[localMaxIndexes.get(i + 1)];
        	int smallerBoundary = leftBoundary < rightBoundary ? leftBoundary : rightBoundary;
        	for (int j = localMaxIndexes.get(i) + 1; j < localMaxIndexes.get(i + 1); j++){
        		//The larger local max may be part of a upward slope with values larger than the left
        		//local max and in that case we can just exit because the water would spill over the
        		//left.
        		if (height[j] > smallerBoundary){
        			break;
        		}
        		sum += smallerBoundary - height[j];
        	}
        }
        
        //Sum the amount of water trapped starting at the end and working toward the peak.
        for (int i = localMaxIndexes.size() - 1; i > peakIndex; i--){
        	int leftBoundary = height[localMaxIndexes.get(i - 1)];
        	int rightBoundary = height[localMaxIndexes.get(i)];
        	int smallerBoundary = leftBoundary < rightBoundary ? leftBoundary : rightBoundary;
        	for (int j = localMaxIndexes.get(i) - 1; j > localMaxIndexes.get(i - 1); j--){
        		//See explanation above, although in this case it would be the left bound that would
        		//be larger.
        		if (height[j] > smallerBoundary){
        			break;
        		}
        		sum += smallerBoundary - height[j];
        	}
        }
        
        return sum;
    }
}
