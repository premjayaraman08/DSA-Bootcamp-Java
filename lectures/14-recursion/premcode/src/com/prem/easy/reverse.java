package com.prem.easy;

public class reverse {
    public static void main(String[] args) {
        System.out.println(reverseNum(1234));
    }

    public static int reverseNum(int num){
        int digits=(int)Math.log10(num)+1;
        return reverseHelper(num,digits);
    }

    public static int reverseHelper(int num,int digits){
        //base condition
        if(num%10==num){
            return num;//tbd
        }
        int rem=num%10;
        return rem*(int)Math.pow(10,digits-1)+reverseHelper(num/10,digits-1);
    }

//    public static void reverseNum(int num){
//        if(num==0){
//            return ;
//        }
//
//        //recurrence relation when o/p is initialized outside
//        output=output*10 + num%10;
//        reverseNum(num/10);
//    }
}
