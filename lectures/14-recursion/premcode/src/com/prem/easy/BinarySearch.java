package com.prem.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={2,4,55,534,888,2332,77767};
        int target=4;

        System.out.println(BS(nums,target,0,nums.length-1));
    }

    public static int BS(int[] nums,int target,int start,int end){

        //same as while loop end
        if(start>end){
            return -1;
        }

        int mid=start+(end-start)/2;

        if(nums[mid]==target){
            return mid;
        }

        if(target>nums[mid]){
            return BS(nums,target,mid+1,end);
        }
        return BS(nums,target,start,mid-1);

    }
}
