package com.sort.serach;

import java.util.Arrays;

public class CountSort {

    // 9 6 3 5 3 4 3 9 6 4 6 5 8 9 9
    public int [] sort(int [] eleArray){

        int min = Arrays.stream(eleArray).min().orElse(0); // 3
        int max = Arrays.stream(eleArray).max().orElse(Integer.MAX_VALUE); // 9
        int range = max-min;// 6

        int count []= new int[range+1]; // Index Array

         for(int el:eleArray){
             count[el-min]++; // index
         }
        for(int i=1;i<count.length;i++){
            count[i] = count[i]+count[i-1]; // updating index refrence
        }

//        for(int j=0;j<count.length;j++){
//            System.out.println(" COUNT "+ j +" VALUE "+count[j]);
//        }

        int returnArr [] = new int[eleArray.length];
         for(int i=eleArray.length-1;i>=0;i--){
               int ele = eleArray[i];
               int elePos = count[ele-min];
               returnArr[elePos-1] = ele;
               count[ele-min]--;
         }

         System.out.println(Arrays.toString(returnArr));

      return returnArr;
    }

    public static void main(String[] args) {
        new CountSort().sort(new int[]{9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9});
    }
}
