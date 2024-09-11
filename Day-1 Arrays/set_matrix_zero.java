//Given an m x n integer matrix matrix, if an element is 0,
// set its entire row and column to 0's.

//You must do it in place.
class Solution {
    public void setZeroes(int[][] matrix) {
      boolean row0=false;
      int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            if(matrix[i][j]==0){
              matrix[0][j]=0;
              
              if(i>0){
                matrix[i][0]=0;
              }
              else{
                row0=true;
              }
            }
          }
        }
        for(int i=1;i<m;i++){
          for(int j=1;j<n;j++){
            if(matrix[i][0]==0 || matrix[0][j]==0){
              matrix[i][j]=0;
            }
          }
        }
        if(matrix[0][0]==0){
          for(int i=0;i<m;i++){
            matrix[i][0]=0;
          }
        }
        if(row0){
          for(int j=0;j<n;j++){
            matrix[0][j]=0;
          }
        }
    }
}