class Solution {

    public String encode(List<String> strs) {
        String k = "";
        for(String str : strs) {
            int length = str.length();
            k= k + length + "#" + str;
        }
        
        System.out.println(k);
        
        return k;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<String>();

        String length = "";
        for(int i=0; i<str.length();i++) {


            if(str.charAt(i) != '#' && isInt(str.charAt(i))) {
                length+=str.charAt(i);
            }
            // System.out.println(length);
            if(str.charAt(i) == '#') {
                System.out.println("length"+length);

                int len = Integer.parseInt(length);
                String s = "";
                int j=1;
                for(;j<=len; j++){
                    System.out.println("i"+i);
                    System.out.println("j"+j);
                    s+=str.charAt(i+j);
                }
                strs.add(s);
                System.out.println("j2"+j);
                i= i + j - 1;
                length="";
                System.out.println("s"+s);
            }
        }

        return strs;
    }

    public boolean isInt(char s) {
        try{
            Character.isDigit(s);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
