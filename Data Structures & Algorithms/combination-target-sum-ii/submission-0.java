class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();

        Arrays.sort(candidates);

        dfs(candidates, target, 0, res, cur);
        return res;
    }

    private void dfs(int[] candidates, int target, int i, List<List<Integer>> res, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || i >=candidates.length) {
            return;
        }

        cur.add(candidates[i]);
        dfs(candidates, target - candidates[i], i + 1, res, cur);

        cur.remove(cur.size() - 1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, target, i + 1, res, cur);
    }
}
