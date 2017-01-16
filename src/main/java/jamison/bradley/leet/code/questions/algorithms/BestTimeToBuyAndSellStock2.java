package jamison.bradley.leet.code.questions.algorithms;

public class BestTimeToBuyAndSellStock2 {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 */
    public int maxProfit(int[] prices) {
    	//If the array is one or less there is no opportunity to buy and sell a stock.
        if (prices == null || prices.length <= 1){
        	return 0;
        }
        
        int localMinIndex = -1;
        int profit = 0;
        //Look for local mins to buy at and local maxes to sell at.
        for (int i = 0; i < prices.length; i++){
        	//Check if current index is a local minimum.
        	if (localMinIndex == -1 && (i - 1 < 0 || prices[i - 1] >= prices[i]) 
        			&& (i + 1 >= prices.length || prices[i + 1] > prices[i])){
        		localMinIndex = i;
        		continue;
        	}
        	//Check if current index is a local maximum.
        	if (localMinIndex != -1 && (i - 1 < 0 || prices[i - 1] <= prices[i])
        			&& (i + 1 >= prices.length || prices[i + 1] < prices[i])){
        		profit += prices[i] - prices[localMinIndex];
        		localMinIndex = -1;
        	}
        }
        return profit;
    }
}
