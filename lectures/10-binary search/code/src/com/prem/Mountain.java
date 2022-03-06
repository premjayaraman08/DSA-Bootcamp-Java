package com.prem;

public class Mountain {
    public static void main(String[] args) {
        int[] nums= {1,2,4,5,7,17,18,11,10}; //peak is 17
                   //        m s
        //BS reduce search space when start and end from array or equal that ur peak
        //initialize 2 pointers
        int start=0;
        int end=nums.length-1;
        //Loop until start < end , why not equal ? when they are equal we found peak
        while(start<end) {
            int mid=start+(end-start)/2;

            if(nums[mid]>nums[mid+1]) {
                end=mid;//decreasing sub array //why mid and mid-1? mid could be the ans peak
                //if mid>mid-1 //increasing sub array
            }else if(nums[mid]>nums[mid-1]) {
                start=mid+1;
            }
        }
        System.out.println(nums[start]);

    }
}
