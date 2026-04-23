class Solution {

    StringBuilder s = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack(0, 0, n);
        return res;
    }

    private void backTrack(int open, int close, int n) {
        if(open == close && open == n) {
            // System.out.println(s);

            res.add(s.toString());
            return;
        }

        if(open < n) {
            s.append('(');
            backTrack(open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open) {
            s.append(')');
            backTrack(open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
