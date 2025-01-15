package tasks;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int n1n2Sum = 0;
        int n1 = 2;
        int n2 = 1;
        for(int i = 2; i < n; i++) {
            n1n2Sum = n1 + n2;
            n1 = n1n2Sum;
            n2 = n1 - n2;
        }

        return n1n2Sum;
    }
}
