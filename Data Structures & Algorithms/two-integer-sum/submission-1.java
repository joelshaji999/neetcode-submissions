class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++) {
            hs.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(hs.get(target - nums[i]) != null){
                if(i != hs.get(target - nums[i]))
                return new int[]{i, hs.get(target - nums[i])};
            }
        }
        return new int[]{};

    }
}
