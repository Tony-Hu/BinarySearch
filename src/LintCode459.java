import java.util.PriorityQueue;

/**
 * [URL]: http://www.lintcode.com/en/problem/closest-number-in-sorted-array/
 * [Description]Closest Number in Sorted Array
 * Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

 Return -1 if there is no element in the array.
 *Given [1, 2, 3] and target = 2, return 1.

 Given [1, 4, 6] and target = 3, return 1.

 Given [1, 4, 6] and target = 5, return 1 or 2.

 Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
 */
public class LintCode459 {
    //Method 1 - Binary search + min heap.
    public class Info implements Comparable<Info>{
        public int index;
        public int value;
        public Info(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Info info){
            return value < info.value ? -1 : value == info.value ? 0 : 1;
        }
    }
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null)
            return -1;

        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target)
                start = mid;
            else
                end = mid;
        }
        PriorityQueue<Info> minHeap = new PriorityQueue<>();
        for (int i = -1; i <= 1; i++){
            if (mid + i >= A.length)
                break;
            if (mid + i < 0)
                continue;
            minHeap.add(new Info(mid + i, Math.abs(A[mid + i] - target)));
        }
        return minHeap.isEmpty() ? -1 : minHeap.peek().index;
    }

    //Method 2 - Binary search
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber2(int[] A, int target) {
        // Write your code here
        if (A == null)
            return -1;

        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start + 1 < end){//Binary search template
            mid = start + (end - start) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target)
                start = mid;
            else
                end = mid;
        }
        return Math.abs(A[start] - target) < Math.abs(A[end] - target) ? start : end;
    }
}
