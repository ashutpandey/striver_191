/*
 * For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.

An inversion is defined for a pair of integers in the array/list when the following two conditions are met.

A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').
 */
import java.util.*; 
import java.io.*; 

class Solution {
    public static long getInversions(long arr[], long n) {
        return mergeSort(arr, 0, n - 1);
    }

    private static long merge(long arr[], long low, long high, long mid) {
        ArrayList<Long> temp = new ArrayList<>();
        long cnt = 0;
        long left = low;
        long right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[(int)left] <= arr[(int)right]) {  
                temp.add(arr[(int)left]);
                left++;
            } else {
                cnt += (mid - left + 1);
                temp.add(arr[(int)right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[(int)left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[(int)right]);
            right++;
        }

        for (long i = low; i <= high; i++) {
            arr[(int)i] = temp.get((int)(i - low));
        }

        return cnt;
    }

    private static long mergeSort(long arr[], long low, long high) {
        long cnt = 0;
        if (low >= high) return cnt;

        long mid = (low + high) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, high, mid);

        return cnt;
    }
}
