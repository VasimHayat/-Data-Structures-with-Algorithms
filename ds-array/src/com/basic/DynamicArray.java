package com.basic;

public class DynamicArray {
    private int size = 0; // actual no of item in array
    private int capacity; // capacity of current array
    private int[] arr;

    DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
    }

    void insert(int ele) {
        if (this.size == capacity) {
        this.growArray();
        }
        this.arr[this.size] = ele;
        this.size++;
    }

    private void growArray() {
        int[] tempArray = new int[this.capacity * 2];
        this.capacity = this.capacity * 2;
        for (int i = 0; i < this.arr.length; i++) {
            tempArray[i] = this.arr[i];
        }
        this.arr = tempArray;
    }

    public int delete(int index){
        int delEle = this.arr[index];
        for(var i=index;i<this.size;i++){
            if(i+1 == this.size){
                this.arr[i] = 0;
                continue;
            }
            this.arr[i]= this.arr[i+1];
        }
        this.size--;
        return delEle;
    }

    public void print(){

        System.out.println("SIZE");
        for(int i=0;i<this.size;i++){
            System.out.println(this.arr[i]);
        }

        System.out.println("cAP");
        for(int i=0;i<this.capacity;i++){
            System.out.println(this.arr[i]);
        }
    }
}
