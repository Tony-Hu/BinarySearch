/**
 * [URL]: http://www.lintcode.com/en/problem/last-position-of-target/
 * [Description]Last Position of Target
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 * Given [1, 2, 2, 4, 5, 5].

 For target = 2, return 2.

 For target = 5, return 5.

 For target = 6, return -1.
 */
public class LintCode458 {

    public int lastPosition(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target)//Find last. Must keep last half if nums[mid] = target. If find first, should be nums[mid] >= target ()
                start = mid;
            else
                end = mid;
        }

        if (nums[end] == target)
            return end;
        if (nums[start] == target)
            return start;
        return -1;
    }
}
