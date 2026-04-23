class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

        for(String s : strs) {
            int[] charCount = new int[26];
            char[] sArray = s.toCharArray();
            for(char c : sArray) {
                charCount[c-'a']++;
            }
            String key = Arrays.toString(charCount);
            hm.putIfAbsent(key, new ArrayList<String>());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
