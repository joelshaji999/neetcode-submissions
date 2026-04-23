class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        int result = 0;
        for(int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }

        return result;
    }
}
