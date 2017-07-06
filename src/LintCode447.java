/**
 * [URL]: http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/#
 * [Description]
 * Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

 Return -1, if the number doesn't exist in the array.

 Notice

 If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

 Example
 Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

 Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 */
public class LintCode447 {

    //Solution 1 - find right bound dynamically. Hard to say it's a O(logn) time complexity.
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int left = 0;
        int right = 100;
        int mid = 50;
        while (left + 1 < right){
            mid = left + (right - left) / 2;
            int value = reader.get(mid);
            if (value < target){
                right *= 2;
                left = mid;
            } else {
                right = mid;
            }
        }
        if (reader.get(left) == target)
            return left;
        if (reader.get(mid) == target)
            return mid;
        return -1;
    }


    //Solution 2 - Calculate right border first. Guarantee to be a O(logn) method.

    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int left = 0;
        int right = 1;
        int mid = 0;
        while (reader.get(right) < target){
            right *= 2;
        }

        while (left + 1 < right){
            mid = left + (right - left) / 2;
            int value = reader.get(mid);
            if (value < target){
                left = mid;
            } else {
                right = mid;
            }
        }

        if (reader.get(left) == target)
            return left;
        if (reader.get(right) == target)
            return right;
        return -1;
    }
}
