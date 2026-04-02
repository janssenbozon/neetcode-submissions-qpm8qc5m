class Solution {
    public int maxProfit(int[] prices) {
        HashSet<Integer> seen = new HashSet<Integer>();
        int maxProfit = 0;
        for(int sellPrice : prices) {
            for(int buyPrice : seen) {
                maxProfit = Math.max(sellPrice - buyPrice, maxProfit);
            }
            seen.add(sellPrice);
        }
        return maxProfit;
    }
}
