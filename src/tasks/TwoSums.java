package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        // Arrays.sort(nums);

        Map<Integer, List<Integer>> numMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> nIdx = numMap.get(n);
            if (nIdx == null) {
                numMap.put(n, List.of(i));
            } else {
                numMap.put(n, List.of(nIdx.get(0), i));
            }
        }

        Arrays.sort(nums);

        for (int i = 0;; i++) {
            int a = nums[i];
            List<Integer> aIdxList = numMap.get(a);
            int aIdx = aIdxList.get(0);

            if (a > target) {
                // min max moznaby wprowadzic
            }

            int targetB = target - a;
            if (targetB == a) {
                return new int[] { aIdxList.get(0), aIdxList.get(1) };
            }

            List<Integer> bIdxList = numMap.get(targetB);

            if (bIdxList != null) {
                return new int[] { aIdx, bIdxList.get(0) };
            }
        }

    }
}