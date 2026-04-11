class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        int oneBefore = 2;
        int twoBefore = 1;

        for (int i = 3; i <= n; i++) {
            int temp = oneBefore;
            oneBefore = oneBefore + twoBefore;
            twoBefore = temp;
        }

        return oneBefore;
    }
}
