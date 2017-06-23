/**
 * [URL]: http://www.lintcode.com/en/problem/search-a-2d-matrix/
 * [Description]Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example
 Consider the following matrix:

 [
 [1, 3, 5, 7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class LintCode28 {

    //Treat the 2d array as a single 1d array.
    //Suppose we have a 1d coordinate mid, we can convert it to 2d coordinate by
    //row = mid / cols;
    //col = mid % cols;
    //Where cols is the columns of the 2d array.
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int row = 0;
        int col = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            row = mid / matrix[0].length;
            col = mid % matrix[0].length;
            //System.out.println(mid + "," + row + "," + col);
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target)
                start = mid;
            else
                end = mid;
        }

        if (matrix[start / matrix[0].length][start % matrix[0].length] == target ||
                matrix[end / matrix[0].length][end % matrix[0].length] == target)
            return true;
        return false;

    }
}
