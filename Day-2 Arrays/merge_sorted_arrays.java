/*
 You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
 */



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      if(n==0)return;
      int end_idx=nums1.length-1;
      while(n>0 && m>0){
        if(nums2[n-1]>=nums1[m-1]){
          nums1[end_idx]=nums2[n-1];
          n--;
        }
        else{
          nums1[end_idx]=nums1[m-1];
          m--;
        }
        end_idx--;
      }
      while(n>0){
        nums1[end_idx]=nums2[n-1];
        n--;
        end_idx--;
      }
    }
}


/*though in this problem the size of the array 1 is equal to m+n
 * if there are two different arrays and we have to sort them and put the elements in those two arrays
 * then the best solution run in log(m+n)*(m+n) and use the concept of gap method which is used in shell sort
 *
 * void merge(int arr1[],int arr2[],int n,int m){
 *  int len=(n+m);
 *  int gap=(len/2)+(len%2);
 *  while(gap>0){
 *      int left=0;
 *      int right=left+gap;
 *      while(right<len){
 *          if(left<n && right>=n){
 *              swapIfGreater(arr1,arr2,left,right-n);
 *          }
 *          else if(left>=n){
 *               swapIfGreater(arr2,arr2,left-n,right-n);
 *          }
 *          else{
 *               swapIfGreater(arr1,arr1,left-n,right-n);
 *          }
 *          left++;
 *          right--;         
 *          }
 *          if(gap==1)break;
 *          gap=(gap/2)+(gap%2);
 *      }
 *  }
 * }
 * 
 */
