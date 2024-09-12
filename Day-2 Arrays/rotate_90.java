/*
 You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */


class Solution {
    public void rotate(int[][] matrix) {
      int n=matrix.length;
        for(int i=0;i<n-1;i++){
          for(int j=i+1;j<n;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
          }
        }
        for(int []nums:matrix){
          reverse(nums);
        }
    }
    public void reverse(int arr[]){
      int left=0,right=arr.length-1;
      while(left<right){
        swap(arr,left,right);
        left++;
        right--;
      }
    }
    public void swap(int []arr,int i,int j){
      int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}




