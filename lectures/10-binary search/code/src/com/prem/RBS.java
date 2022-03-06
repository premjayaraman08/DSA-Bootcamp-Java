package com.prem;

public class RBS {
    public static void main(String[] args) {
        //find RBS
        //properties:
        // - has only one peak which is maximum
        // - on either side of peak its is sorted in asc, so search on either side

       // int[] nums= {15,17,19,20,21,1,6};
        int[] nums= {9,1,2,3,4,5,6};
        int target=6;
        int start=0;

        //Q : search in RBS
        //A :find peak, check on either side of the peak if peak is not target
        int peak = findPeakSimple(nums);

        System.out.println("Peak"+peak);

        //No peak do simple binary search
        if(peak==-1) {
            System.out.println("NO PEAK:" + BinarySearch(nums,target,0,nums.length-1));
        }

        if(target==nums[peak]){
            System.out.println("Fount target:"+peak);
            System.exit(0);;
        }

        int ans;
        //we have 2 ascending sub array on either side of pivot
        if(target>=nums[start]){ // ?? if target is > start element, must lie within peak since peak is maximum
            ans=BinarySearch(nums,target,0,peak-1);//search in sub array that is rotated
        }else {
            ans = BinarySearch(nums, target, peak+1,nums.length-1);//search in sub array that is NOT ROTATED
        }
        System.out.println("TARGET is on"+ ans);
    }

    private static int findPeakDuplicate(int[] nums){
        //goal is neglect duplicates on start and end

        int start=0;
        int end=nums.length-1;

        int mid;
        while(start<=end){
            mid=start+(end-start)/2;

            //Peak current means next element smaller
            if(end<mid &&  nums[mid]>nums[mid+1]){
                return mid;
            }

            //Peak previous if previous higher than current
            if(mid>start && nums[mid]<nums[mid-1]){ //4,5,10,1
                return mid-1;
            }


            //GOAL is find pivot
            //Properites start and end would always be less than pivot if pivot is random mid element

            //handle case when start, mid, end are equal
            if(nums[mid]==nums[start] && nums[mid]==nums[end]){
                //skip duplicates by incrementing both start/end pointers BUT wait did u check if start or end is pivot

                //check if start is pivot
                if(nums[start]>nums[start+1]){ //whye no mid checks since start=mid and end=mid
                    return start;
                }
                start++;

                if(nums[end]<nums[end-1]){
                    return mid-1;
                }
                end--;
            }else if(nums[start]<nums[mid] ||( nums[start]==nums[mid] || nums[mid]>nums[end])){
                //left side is sorted or equal to mid ,check pivot on right side
                //Q : why second condition check start = mid? //
                // assuming pivot on right subarray which is sorted.i.e end is less than mid so search right
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;
    }

    private static int findPeakSimple(int[] nums) {
        //Peak properties

        int start=0;
        int end=nums.length-1;

        while(start<=end) {
            int mid = start + (end - start) / 2;

            //case 1: mid > next element
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            //case 2: mid < previous element
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            //case 3: if start>=mid
            if (nums[start] >= nums[mid]) { //peak could be before mid
                end = mid - 1; //eg: [9,1,2,3,4,5,6]
            } else {
                //peak could be after mid
                start = mid + 1; //eg: [4,5,6,9,1,2,3]
            }
            //case 4: if start<mid
        }

        return -1;
    }

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int BinarySearch(int[] nums, int target, int start, int end) {
        while(start<=end){
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


    private static int findPivot(int[] nums) {
        //have 2 pointers, calculate mid
        int start=0;
        int end=nums.length-1;

        while (start<=end){
            int mid= start+(end-start)/2;

            //check mid neighbor for unique property
            if(mid<end && nums[mid]>nums[mid+1]){ //if mid > mid next
                return mid;
            }

            if(mid<start && nums[mid]<nums[mid-1]){
                return mid-1;
            }

            //if start>mid, items above mid can be eliminated
            //can it be equal it mid ?
            if(nums[start]>=nums[mid]){
                end=mid-1;// eg: [9,1,2,3,4,5]
            }else{
                start=mid+1; //eg: [3,4,5,9,1,2]
            }
        }
        return -1;
    }
}
