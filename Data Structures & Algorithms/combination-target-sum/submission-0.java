class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();;
        List<Integer> cur = new ArrayList();
        backTrack(nums, target, cur, 0);

        return res;
    }

    private void backTrack(int[] nums, int target, List<Integer> cur, int i) {
        if(target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backTrack(nums, target - nums[i], cur, i);

        cur.remove(cur.size() - 1);
        backTrack(nums, target, cur, i + 1);
    }
}
