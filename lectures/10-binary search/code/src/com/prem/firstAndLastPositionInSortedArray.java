package com.prem;

import java.util.Arrays;

public class firstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,8,8,8,9,10};
        int target=7;
        System.out.println(Arrays.toString(searchIndexes(nums,target)));

    }

    public static int[] searchIndexes(int[] nums, int target){
        //Find target present in array
        //if found
        //perform binary search


        int firstIndex=-1;
        boolean findFirst=true;

        int secondIndex=-1;

        //do binary search on left side firstIndex
        firstIndex=BinarySearch(nums,target,0, nums.length-1,true );
        if(firstIndex==-1){
            return new int[]{firstIndex,secondIndex};
        }
        //do binary search on right side of index
        secondIndex =BinarySearch(nums,target,firstIndex, nums.length-1,false );

        //if not found return -1,-1
        return new int[]{firstIndex,secondIndex};
    }

    public static int BinarySearch(int[] nums,int target, int start, int end,boolean findFirst){
        int ans=-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{

                ans=mid;
                if(findFirst){
                    end=mid-1;//Keep doing binary search until left side is finished
                }else{
                    start=mid+1;//Keep doing binary search until right side finished
                }

            }
        }
        return ans;
    }
}
