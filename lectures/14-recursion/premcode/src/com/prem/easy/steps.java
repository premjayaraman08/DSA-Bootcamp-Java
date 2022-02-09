package com.prem.easy;

public class steps {
    public static void main(String[] args) {
        System.out.println(stepToZero(14));
        System.out.println(1/2);
    }

    public static int stepToZero(int num){
        int steps=0;
        return helper(num,steps);
    }

    public static int helper(int num,int steps){
        //base condition returning answer
        if(num==0){
            return steps;
        }
        if(num%2==0){
            return helper(num/2,steps+1);
        }
        return helper(num-1,steps+1);
    }


}
