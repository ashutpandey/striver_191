/*
 * You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
    int xor = 0;
    int N = A.size();
    for (int i = 0; i < N; i++) {
        xor ^= A.get(i);
        xor ^= (i + 1);
    }
    int number = xor & ~(xor - 1);
    int zgrp = 0, ogrp = 0;
    for (int i = 0; i < N; i++) {
        if ((number & A.get(i)) == 0) {
            zgrp ^= A.get(i);
           
        } else {
            ogrp ^= A.get(i);
           
        }
        if(((i+1)&number)!=0){
             ogrp ^= (i + 1);
        }else{
            zgrp^=(i+1);
        }
    }
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        if (A.get(i) == zgrp) cnt++;
    }
    if (cnt == 2) {
        return new ArrayList<>(Arrays.asList(zgrp, ogrp));
    }
    return new ArrayList<>(Arrays.asList(ogrp, zgrp));
}

}

