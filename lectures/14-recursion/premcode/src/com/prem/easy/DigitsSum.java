package com.prem.easy;

public class DigitsSum {
    public static void main(String[] args) {
      // Q: Sum of digits 1234
        // A: 1234 => 10
        int sum=0;
        System.out.println(Sum(1234));
    }

    // 1. break into sub problems => 1234 = 123+4;
    //                                      123=> 120+3;
    //                                              12=> 10+2
    //                                                    1+0
    // 2. Find recurrence relation F(n) = Remainder + rest of digts
    //                           F(n) = N %10 + F(N/10)
    //3. Draw tree
    //4. About tree -> flow of fn adding to stack, idenfity left subtree then right subtree
    //5. Find what values are returned at each half
    public static int Sum(int nums){
        //base condition
        if(nums==0){
            return 0;
        }
        int sum=  Sum(nums/10)+nums%10;
        return sum;
    }
}
