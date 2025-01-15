import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    static public int[] searchRange(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;
        int biIdx;


        while(true) {
            if(upper <= lower) {
                return new int[]{-1, -1};
            }

            biIdx = (upper - lower) / 2 + lower;
//            System.out.println("biIdx = " + biIdx);
//            System.out.println(lower + " " + upper);

            if(nums[biIdx] == target) {
                int leftIdx = biIdx;
                int rightIdx = biIdx;
                while(true) {
                    if(leftIdx > 0 && nums[leftIdx - 1] == target)
                        leftIdx--;
                    else
                        break;
                }

                while(true) {
                    if(rightIdx < nums.length - 1 && nums[rightIdx + 1] == target)
                        rightIdx++;
                    else
                        break;
                }

                return new int[]{leftIdx, rightIdx};
            }

            if(nums[biIdx] > target) {
                upper = biIdx - 1;
            } else {
                lower = biIdx + 1;

            }
        }
    }

    public static void main(String[] args) {
        int[] ints;
        ints = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));

        ints = searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(Arrays.toString(ints));
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
    }
}
