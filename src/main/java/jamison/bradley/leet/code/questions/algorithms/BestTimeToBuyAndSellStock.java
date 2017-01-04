package jamison.bradley.leet.code.questions.algorithms;

public class BestTimeToBuyAndSellStock {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 */
    public int maxProfit(int[] prices) {
    	//Can't buy and sell a stock if there is one or fewer prices.
        if (prices == null || prices.length <= 1){
        	return 0;
        }
        
        int minPrice = prices[0];
        int bestMargin = 0;
        for (int i = 1; i < prices.length; i++){
        	//A new minimum has been found which means buying the stock at this point would be
        	//better than buying it at the old min compared to any point later in the array
        	//when it could be sold.
        	if (prices[i] < minPrice){
        		minPrice = prices[i];
        	}
        	//A new best selling point has been found.
        	else if (prices[i] - minPrice > bestMargin){
        		bestMargin = prices[i] - minPrice;
        	}
        }
        return bestMargin;
    }
}
