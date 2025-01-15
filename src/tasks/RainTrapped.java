package tasks;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RainTrapped {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for(int i = 1; i < height.length; i++) {
            maxLeft[i] = max(height[i - 1], maxLeft[i - 1]);
            maxRight[maxRight.length - i - 1] = max(height[maxRight.length - i], maxRight[maxRight.length - i]);
        }

        int vol = 0;
        for (int i = 0; i < height.length; i++) {
            vol += max(min(maxLeft[i], maxRight[i]) - height[i], 0);
        }

        return vol;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int volume = new RainTrapped().trap(height);
        System.out.println(volume);

        height = new int[]{4,2,0,3,2,5};
        volume = new RainTrapped().trap(height);
        System.out.println(volume);

    }
}

// egde cases: flat
// single extreme
// two peeks

