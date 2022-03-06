package com.prem;

public class Floor {
    public static void main(String[] args) {
        int[] arr ={1,4,6,8,11,22,26,30};
        int target=21; //floor 11

        System.out.println(arr[floor(arr,target)]);
    }

    private static int floor(int[] arr, int target) {

        //find greatest element smaller than target
        //idea we reduce space search until cross over
        //0 1 2 3 4  5  6  7  //target 21 ans 11
        //1,4,6,8,11,22,26,30
        //        e s

        int start=0;
        int end=arr.length-1;

        while(start<=end){

            int mid= start+(end-start)/2;
            if(target>arr[mid]){
                start=mid+1; //search right side
            }else if(target<arr[mid]){
                end = mid-1; //search left side
            }else{
                return mid;
            }

        }

        return end;
    }



}
