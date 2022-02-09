package com.prem.easy;

public class Fact {
    public static void main(String[] args) {
        System.out.println(Fact(4));
    }

    public static int Fact(int n){
        if(n<=1){
            return 1;
        }
        return n*Fact(n-1);
    }
}
