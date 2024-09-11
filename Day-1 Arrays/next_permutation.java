//longest prefix match
// find a[i]<a[i+1]

//find an element that is greater than a[i] but smallest in a[i+1:]
//swap it with a[i] then reverse the remaining a[i+1:] generated combination is next permutation


class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1,n=nums.length;
        for(int i=n-2;i>=0;i--){
          if(nums[i]<nums[i+1]){
            idx=i;
            break;
          }
        }
        if(idx==-1){
          reverse(nums,0,n-1);
          return;
        }
        for(int i=n-1;i>idx;i--){
          if(nums[i]>nums[idx]){
            swap(nums,i,idx);
            break;
          }
        }
        reverse(nums,idx+1,n-1);
    }
    public static void reverse(int []arr,int i,int j){
      int left=i,right=j;
      while(left<right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        left++;
        right--;
      }
    }
    public static void swap(int arr[],int i,int j){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
    }
}

