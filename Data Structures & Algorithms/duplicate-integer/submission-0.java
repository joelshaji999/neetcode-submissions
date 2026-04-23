class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsset = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(numsset.contains(nums[i])){
                return true;
            }
            else{
                numsset.add(nums[i]);
            }
        }

        return false;
    }
}