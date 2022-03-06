package com.prem;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        //int[] nums ={1,2,4,5,7,9,11,13};
        int[] nums= {13,11,9,8,7,6,4,3,2};
        int target=11;

        System.out.println(orderBS(nums, target));

    }

    public static int orderBS(int[] nums, int target) {

        int start=0;
        int end= nums.length-1;

        //find if isAscending compare start and end
        boolean isAsc;
        isAsc=nums[end]>nums[start];

        //calculate mid

        while(start<=end) {
            //Handle asc
            int mid=start+(end-start)/2;

            if (isAsc) {
                if (target > nums[mid]) {
                    start = mid + 1;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                //Handle desc
                if (target > nums[mid]) {
                    end = mid - 1;
                } else if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }

            }
        }

        return -1;
    }

}
