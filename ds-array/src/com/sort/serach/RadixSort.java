package com.sort.serach;

import java.util.Arrays;

public class RadixSort {

// 121 200 014 013  451 74  -->
//  1    0   4   3    1   4
    private int [] countSor(int eleArray[], int exp){
        int countArray [] = new int[10];
        int returnArray []  = new int[eleArray.length];

        for(int e :eleArray){
           int digitVal =e/exp%10;//  (121/10) %10 = 2,  (121/100) %10 = 1
            countArray[digitVal]++;
        }
        for(int i =1;i<countArray.length;i++){
            countArray[i] = countArray[i]+countArray[i-1];
        }

        for(int i=eleArray.length-1;i>=0;i--){
             int ele = eleArray[i];
             int digitVal = ele/exp%10;
             int elePos = countArray[digitVal];
             returnArray[elePos-1] = ele;
             countArray[digitVal]--;
        }
        return returnArray;

    }

    public int [] sort(int eleArray[]){
         int exp =1;
         int max = Arrays.stream(eleArray).max().orElse(0);
         while (exp <= max){
             eleArray =  this.countSor(eleArray,exp);
             exp = exp*10;
         }
         return eleArray;
    }

    public static void main(String[] args) {
        int eleArray [] = {121, 200, 014, 013,  451, 74};
        System.out.println(Arrays.toString(new RadixSort().sort(eleArray)));
    }
}
