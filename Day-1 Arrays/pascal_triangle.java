/* 
    Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:    
*/
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
          ans.add(generateRow(i));
        }
        return ans;
    }
    public static List<Integer> generateRow(int row){
      int res=1;
      List<Integer> ansRow=new ArrayList<>();
      ansRow.add(1);
      for(int col=1;col<row;col++){
        
        res*=(row-col);
        res/=col;
        ansRow.add(res);
      }
      return ansRow;
    }
    
}