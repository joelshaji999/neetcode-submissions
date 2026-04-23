class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        System.out.println("a");

        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }

        System.out.println("b");

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>()); // initialize every bucket
        }

        for(int key : hm.keySet()) {
            int count = hm.get(key);
            buckets.get(count).add(key);
        }

        System.out.println("c");
System.out.println("Buckets: " + buckets);

        int[] result = new int[k];
        int j = 0;

        // System.out.println(Arrays.toString(buckets));
        System.out.println("d");

        for(int i=nums.length; i>=0; i--){
            System.out.println("a"+i);

            for(int val:buckets.get(i)){
                result[j] = val;
                j++;
                k--;
            }

            if(k<=0) break;
        }

        return result;
    }
}
