class Solution {
    List<String> res = new ArrayList<String>();
    List<Character> sub = new ArrayList<Character>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<String>();

        char[] numbers = digits.toCharArray();
        List<String> c = new ArrayList<>();

        for(char num : numbers) {
            if(num == '2'){
                c.add("abc");
            }
            if(num == '3'){
                c.add("def");
            }
            if(num == '4'){
                c.add("ghi");
            }
            if(num == '5'){
                c.add("jkl");
            }
            if(num == '6'){
                c.add("mno");
            }
            if(num == '7'){
                c.add("pqrs");
            }
            if(num == '8'){
                c.add("tuv");
            }
            if(num == '9'){
                c.add("wxyz");
            }
        }

        dfs(c, 0, 0);

        return res;
    }

    private void dfs(List<String> c, int i, int j) {

        if(i >= c.size()) {
            res.add(sub.stream()
           .collect(StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append)
           .toString());
            return;
        }
        if(j >= c.get(i).length()) return;


        sub.add(c.get(i).charAt(j));
        dfs(c, i + 1, 0);

        sub.remove(sub.size() - 1);
        dfs(c, i, j + 1);
    }
}
