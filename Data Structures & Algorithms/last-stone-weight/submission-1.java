class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        while(maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            if(max1 != max2) {
                int newVal = max1 - max2;
                maxHeap.offer(newVal);
            }

        }
        
        if(maxHeap.size() == 1)
            return maxHeap.poll();
        else return 0;
    }
}
