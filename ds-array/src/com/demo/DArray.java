package com.demo;

public class DArray {

    int size = 0;//  actual no of item in Array
    int capacity = 10;// Capacity of current Array
    private int [] _arr;

    public DArray(){
        this._arr = new int[this.capacity];
    }
    public DArray(int capacity){
        this.capacity = capacity;
        this._arr = new int[this.capacity];
    }

    public void insert(int ele){
         if(this.size == this.capacity){
            this.growArray();
         }
         this._arr[this.size] = ele;
         this.size++;
    }

    public void update(int ele, int index) throws Exception {
        if(index >= this.size){
            throw new Exception("Index out of bound exception");
        }
        this._arr[this.size] = ele;
        this.size++;
    }

    private void growArray(){
        int newCapacity = this.capacity+10;
        int [] tempEleArray = new int[newCapacity];
        for(int i=0;i<this.capacity;i++){
            tempEleArray[i] = this._arr[i];
        }
        this.capacity= newCapacity;
        this._arr = tempEleArray;
    }



}
