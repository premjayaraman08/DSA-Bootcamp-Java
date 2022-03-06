package com.prem;

//search for an element in infinite array, meaning u cant use length end
public class InfiniteSortedArray {
    public static void main(String[] args) {

        int[] nums={12,23,25,26,27,29,33,34,35,45,46,55,57,77,88,101};

        int target=77;
        System.out.println(infiniteSearch(nums,target));
    }

    public static int infiniteSearch(int[] nums, int target){
        //we cant make use of lenght of array. we have to go in chunks
        //a chunk is bounded integer of range and each time we are doubling the space for search

        //initialize 2 pointers with search space 1
        int start=0;
        int end=1;
        //  0  1  2  3  4  5  6  7  8  9 10 11 12  13  14 15 16 17
        ///{12,23,25,26,27,29,33,34,35,45,46,55,57,66,77,88,90,101};
        //  s  e  new
        //target >
        while(target>nums[end]){
            start=end;
            end=2*end;
        }
        return BinarySearch(nums,target,start,end);

        //until item found double search space ?  when do u stop
    }

    public static int BinarySearch(int[] nums,int target, int start, int end ){
        while (start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}
