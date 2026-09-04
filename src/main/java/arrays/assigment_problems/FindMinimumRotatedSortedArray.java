package arrays.assigment_problems;

import java.util.Arrays;

public class FindMinimumRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right part
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left part
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1:");
        System.out.println("nums = " + Arrays.toString(nums1));
        System.out.println("Minimum: " + findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nTest Case 2:");
        System.out.println("nums = " + Arrays.toString(nums2));
        System.out.println("Minimum: " + findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nTest Case 3 (Already sorted):");
        System.out.println("nums = " + Arrays.toString(nums3));
        System.out.println("Minimum: " + findMin(nums3));
    }
}
