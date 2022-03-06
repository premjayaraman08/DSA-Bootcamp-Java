package com.prem;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums ={2, 5, 9, 15, 18, 27,29, 34};
        int target = 2;

        System.out.println(binary(nums, target));
        ;
    }

    public static int binary(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        //2,4,5,9,15,18,27,29,34
        //m = 4 a[m]=15
        while (start <= end) {
            int mid = start + (end - start) / 2;

            //target> mid search right
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1; //target less than mid search left
            }else{
                return mid; //find target
            }
        }

        return -1;
    }
}
