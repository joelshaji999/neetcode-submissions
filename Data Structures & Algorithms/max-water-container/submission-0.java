class Solution {
    public int maxArea(int[] heights) {
        int i= 0, j= heights.length-1;
        int max = -1;

        while(i<j){
            int amount = Integer.min(heights[i], heights[j]) * (j-i);

            if(amount > max) {
                max = amount;
            }

            if(heights[i] < heights[j]) {
                i++;
            } 
            else {
                j--;
            }
        }

        return max;
    }
}
