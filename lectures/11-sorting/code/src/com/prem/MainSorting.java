package com.prem;

import java.util.Arrays;

public class MainSorting {
    public static void main(String[] args) {
        int[] nums={5,3,4,2,1};
        //bubbleSort(nums);
        selectionSortMax(nums);
        selectionSortMin(nums);
        System.out.println(Arrays.toString(nums));
     }

    private static void selectionSortMax(int[] nums) {

        //selection sort
        //find Max item from given subarray and swap with correct index
        for(int i=0;i<nums.length;i++) {
            int maxIndex = getMaxIndex(nums,0,nums.length-i);
            System.out.println(maxIndex);
            //swap with right index
            swap(nums,maxIndex,nums.length-1-i);
        }
    }

    private static void selectionSortMin(int[] nums) {

        for(int i=0;i<nums.length;i++) {
            //getMinIndex
            int minIndex =getMinIndex( nums,i,nums.length);
            swap(nums,i,minIndex);
        }
    }

    private static int getMinIndex(int[] nums,int start, int end){
        int min=start;
        for(int i=start+1;i<end;i++){
            if(nums[i]<nums[start]){
                min=i;
            }
        }
        return min;
    }





    private static int getMaxIndex(int[] nums, int start, int end){
        int max=start;
        for(int i=start;i<end;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        return max;
    }


    private static void bubbleSort(int[] nums) {

        for(int i=0;i<nums.length;i++){
            //stop swapping if array is already sorted
                boolean swap=false;// swap is
            //compare with previous element
            for(int j=1;j<nums.length-i;j++){
                if(nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                    swap=true;
                }


            }
            if(!swap){
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }



}
