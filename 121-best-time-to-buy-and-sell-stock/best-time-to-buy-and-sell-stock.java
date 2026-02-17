class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrices = prices[0];

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrices){
                minPrices = prices[i];
            } else {
             int profit = prices[i] - minPrices;
             if (profit > maxProfit){
                maxProfit = profit;
             }
            } 
        }
        return maxProfit;
    }
}