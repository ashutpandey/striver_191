/*
 *  You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.

    You must write a solution in O(log(m * n)) time complexity.
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length*matrix[0].length-1;
        int n=matrix[0].length;
        while(low<=high){
          int mid=(low+high)/2;
          int row=mid/n;
          int col=mid%n;
          if(matrix[row][col]<target){
            low=mid+1;
          }
          else if(matrix[row][col]>target){
            high=mid-1;
          }
          else{
            return true;
          }
        }
        return false;
    }
}
    

