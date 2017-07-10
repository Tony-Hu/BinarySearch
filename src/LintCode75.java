/**
 * [URL]: http://www.lintcode.com/en/problem/find-peak-element/#
 * [Description]:
 * There is an integer array which has the following features:

 The numbers in adjacent positions are different.
 A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 We define a position P is a peek if:

 A[P] > A[P-1] && A[P] > A[P+1]
 Find a peak element in this array. Return the index of the peak.
 Example
 Given [1, 2, 1, 3, 4, 5, 7, 6]

 Return index 1 (which is number 2) or 6 (which is number 7)
 */
public class LintCode75 {

    //Solution 1 - Based on traditional binary search algorithm. Since it can return immediately once
    //find the peak. It's better than solution 2.(Nine chapter's solution.)
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null)
            return -1;

        int left = 0, right = A.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if ((A[mid - 1] < A[mid]) && (A[mid + 1] < A[mid])){
                return mid;
            }
            if (A[mid] < A[mid + 1]){
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }


    //Solution 2 - Nine chapter solution.
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak2(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
