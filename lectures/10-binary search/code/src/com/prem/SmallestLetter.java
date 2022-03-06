package com.prem;

public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char target = 'f';

        System.out.println(nextGreatestLetter(letters,target));


    }

    public static char smallest(char[] letters,char target){

        int start=0;
        int end=letters.length-1;

        //run loop until 2 pointers cross each other
        while(start<=end){
            int mid=start+(end-start)/2;

            if(target>=letters[mid]){ //search right side
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        //after they have crossed each other start should be in right position.
        // ie.smallest number greater than targe
        //if no more elements come back to 1st letter , use module of length of char letters
        return letters[start%letters.length];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
}
