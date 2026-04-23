class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);

        dfs(nums, res, cur, 0);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int i) {
        if(i == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, res, cur, i + 1);

        cur.remove(cur.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(nums, res, cur, i + 1);
    }
}
