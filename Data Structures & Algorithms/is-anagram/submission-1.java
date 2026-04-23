class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for(int i=0; i<sArray.length; i++){
            hm.put(sArray[i], hm.getOrDefault(sArray[i],0)+1);
        }

        for(int i=0; i<tArray.length; i++){
            hm.put(tArray[i], hm.getOrDefault(tArray[i],0)-1);
        }

        
        for(char key : hm.keySet()){
            if(hm.get(key) != 0){
                return false;
            }
        }

        return true;
    }
}
