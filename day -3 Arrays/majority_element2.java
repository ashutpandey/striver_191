/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 */
import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
          if(cnt1==0&& nums[i]!=el2){
            cnt1=1;
            el1=nums[i];
          }
          else if(cnt2==0 && nums[i]!=el1){
            cnt2=1;
            el2=nums[i];
          }
          else if(el1==nums[i])cnt1++;
          else if(el2==nums[i])cnt2++;
          else{
            cnt1--;
            cnt2--;
          }

        }
        cnt1=0;cnt2=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
          if(el1==nums[i])cnt1++;
          else if(el2==nums[i])cnt2++;

        }
        int mini=n/3+1;
        if(cnt1>=mini)ans.add(el1);
        if(cnt2>=mini)ans.add(el2);
        return ans;
    }
}