class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();

        for(String c : tokens) {
            System.out.println("stack"+s);
            System.out.println("c"+c);

            if(c.equals("+")) {
                System.out.println("in");

                String b = s.pop();
                String a = s.pop();

                int res = Integer.parseInt(a) + Integer.parseInt(b);

                s.push(Integer.toString(res));
            } else if(c.equals("-")) {
                String b = s.pop();
                String a = s.pop();

                int res = Integer.parseInt(a) - Integer.parseInt(b);

                s.push(Integer.toString(res));
            } else if(c.equals("*")) {
                String b = s.pop();
                String a = s.pop();

                int res = Integer.parseInt(a) * Integer.parseInt(b);

                s.push(Integer.toString(res));
            } else if(c.equals("/")) {
                String b = s.pop();
                String a = s.pop();

                int res = Integer.parseInt(a) / Integer.parseInt(b);

                s.push(Integer.toString(res));
            } else {
                s.push(c);
            }
        }

        String result = s.pop();

        return Integer.parseInt(result);
    }
}
