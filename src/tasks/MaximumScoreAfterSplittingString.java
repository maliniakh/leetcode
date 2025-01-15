package tasks;

import java.util.Arrays;

public class MaximumScoreAfterSplittingString {
    public int maxScore(String s) {
        int[] s0Count = new int[s.length() - 1];
        int[] s1Count = new int[s.length() - 1];

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            }
            if (s.charAt(s.length() - i - 1) == '1') {
                oneCount++;
            }

            s0Count[i] = zeroCount;
            s1Count[s.length() - i - 2] = oneCount;
        }

        System.out.println(Arrays.toString(s0Count));
        System.out.println(Arrays.toString(s1Count));

        int max = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            int currentScore = s0Count[i] + s1Count[i];
            if (currentScore > max) {
                max = currentScore;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int i = new MaximumScoreAfterSplittingString().maxScore("1111");
        System.out.println(i);
    }
}
