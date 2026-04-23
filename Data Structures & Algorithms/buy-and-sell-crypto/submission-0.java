class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0, r = l + 1;
        int maxProfit = 0;
        while(l < r && r < prices.length) {
            if(prices[l] > prices[r]) {
                l++;
                r = l + 1;
            } else {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
                r++;
            }
        }

        return maxProfit;
    }
}
