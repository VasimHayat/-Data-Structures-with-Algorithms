package com.assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearchDemo {
    private static Scanner scanner = new Scanner(System.in);
    private String msgStr1 = "Enter the length of the array";
    private String msgStr2 = "Enter the element of the array";
    private String msgStr3 = "Enter the key value";


    private Integer getUserInput(String displayMsg) {
        if (displayMsg != null) {
            System.out.println(displayMsg);
        }
        return scanner.nextInt();
    }

    private int[] getAndFillElements() {
        int noOfEle = this.getUserInput(msgStr1);
        System.out.println(this.msgStr2);
        int elementArray[] = new int[noOfEle];
        for (var i = 0; i < elementArray.length; i++) {
            elementArray[i] = this.getUserInput(null);
        }
        return elementArray;
    }


    private ArrayList linearSearch(int eleArray[],int searchKey){
          ArrayList<Integer> outIndexList = new ArrayList<>();
          for (int i=0;i<eleArray.length;i++){
              System.out.print(eleArray[i]+"["+i+"] ");
              if(searchKey ==  eleArray[i]){
                  outIndexList.add(i);
              }
          }
          return outIndexList;
    }

    private void initApp() {
        int eleArray [] = this.getAndFillElements();
        int searchKey = this.getUserInput(msgStr3);
        ArrayList outArray = this.linearSearch(eleArray,searchKey);

        if(outArray.isEmpty()){
            System.out.print("\nOutput : No Such Key exists !");
        }else{
            System.out.print("\nOutput :  index - ");
            outArray.forEach(e ->{
                System.out.print(e +" ");
            });
        }

    }


    public static void main(String[] args) {
        new LinearSearchDemo().initApp();
    }

}
