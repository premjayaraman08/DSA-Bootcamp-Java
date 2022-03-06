package com.prem;

//smallest number closet to target
public class Ceiling {
    public static void main(String[] args) {

        int[] nums={2,4,5,8,13,19,22,25};
        int target=26;
        System.out.println( nums[ceiling(nums,target)]);
    }

    public static int ceiling(int[] nums,int target){
        //initialize 2 pointers
        int start=0;
        int end=nums.length-1;
        //upper bound
        if(target>nums[nums.length-1]){
            return -1;
        }

        //Loop until they cross each other ?? = ?
        while(start<=end) {
            //handle edge case when out of bounds on either side

            //calculate mid
            int mid=start + (end-start)/2;

            //handle 3 case of binary search
            //case1 target greater mid
            if (target >nums[mid]){
                start=mid+1;
            }else if(target < nums[mid]){            //case2 target less than mid
                end=mid-1;
            }else{
                return mid;             //case3 target = mid

            }
        }
        return start; //why start ??
    }

}
