/**
 * [URL]: http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/#
 * [Description]
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.
 Given [4, 5, 6, 7, 0, 1, 2] return 0
 */
public class LintCode159 {

    // Main idea: compare with left end and right end to determine keep which half.
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]){
                if (nums[left] < nums[right]){
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[left] < nums[right]){
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    //TODO Has more convenient way
}
