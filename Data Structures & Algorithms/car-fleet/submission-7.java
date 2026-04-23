class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for(int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Stack<Double> stack = new Stack<>();
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0],a[0]));

        for(int i = 0; i < n; i++) {
            double t = ((double)(target - pair[i][0])) / ((double)(pair[i][1]));
            if(stack.isEmpty() || t > stack.peek() ) {
                stack.push(t);
            } 

        }
        return stack.size();
    }
}
