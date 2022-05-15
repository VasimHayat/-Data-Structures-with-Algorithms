package com.sort.serach;

public class InsertionSort {

    public int[] sort(int elements []){

        for(int i=1;i<elements.length;i++){
            int ele = elements[i];
            int j= i;
            while (j!=0 && elements[j-1]>ele){
                elements[j] = elements[j-1];
                j--;
            }
            elements[j]= ele;
        }

        return elements;
    }

    public static void main(String[] args) {
        int sorted[] = new InsertionSort().sort(new int[]{2, 1});
        for( int i :sorted){
            System.out.print( i);;
        }

    }
}
