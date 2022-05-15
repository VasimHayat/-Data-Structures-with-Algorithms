package com.assignment1;

import java.util.Scanner;

public class ArrayDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static int MAX_INPUT_LIMIT = 50;
    private static int SKIP_VAL = -99;

    private String msgStr1 = "Enter no. of element in the Array(less than or equal to 50)";
    private String msgStr2 = "Enter Value of the Array(Please do not enter -99 as an input)";
    private String msgStr3 = "The Final Array is";
    private int elementArray[];


    private Integer getUserInput(String displayMsg) {
        if (displayMsg != null) {
            System.out.println(displayMsg);
        }
        return scanner.nextInt();
    }

    private int validateAndModifyVal(int numVal) {
        return numVal > 5 && numVal % 2 == 0 ? this.SKIP_VAL : numVal;
    }

    private boolean getAndFillEle() {
        boolean isError = false;
        for (var i = 0; i < this.elementArray.length; i++) {
            int numVal = this.getUserInput(null);
            if (numVal == SKIP_VAL) {
                isError = true;
                System.out.println("Error: " + this.SKIP_VAL + " Invalid value");
                break;
            } else {
                this.elementArray[i] = this.validateAndModifyVal(numVal);
            }
        }
        return isError;
    }

    private void displayArray() {
        System.out.println(this.msgStr3);
        for (int ele : this.elementArray) {
            System.out.println(ele);
        }
    }

    private void initApp() {
        int noOfEle = this.getUserInput(msgStr1);
        if (noOfEle > 50) {
            System.out.println("Error: invalid no of items !");
        } else {
            this.elementArray = new int[noOfEle];
            System.out.println(this.msgStr2);
            if (!this.getAndFillEle()) {
                this.displayArray();
            }
        }
    }

    public static void main(String[] args) {
        new ArrayDemo().initApp();
    }
}
