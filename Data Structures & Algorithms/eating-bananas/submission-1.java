class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        int size = piles.length;

        for (int i = 0; i < size; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }

        int l = 1, r = max;
        int res = r;
        while(l <= r) {
            int m = l + (r - l) / 2;

            int time = 0;
            for(int i = 0; i < size; i++) {
                time = time + (int) Math.ceil((double) piles[i] / m);
                if(time > h) break;
            }
            if(time <= h) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }

        }

        return res;
    }
}
