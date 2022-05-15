package com.sort.serach;

public class BinarySearch {

     int search(int eleArray[], int searchNum, int right, int left) {
        if (left >right) {
            System.out.println("Not a valid array");
            return -1;
        } else {
            int mid = (left+right)/2;
            if(eleArray[mid] == searchNum){
                return mid;
            }else if(eleArray[mid] > searchNum){
                  return this.search(eleArray,searchNum,mid-1,left);
            }else{
                return this.search(eleArray,searchNum,right,mid+1);
            }
        }
    }

    public static void main(String[] args) {
        int tempArray [] = {1,5,7,121,548};
        System.out.println(new BinarySearch().search(tempArray,5,tempArray.length-1,0));
    }
}