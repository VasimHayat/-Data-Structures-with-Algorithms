package com.basic;

import java.util.ArrayList;
import java.util.List;

public class StackDemo {

    public static void main(String[] args) {
        ArrayStack s1 = new ArrayStack(3);
        s1.push(2);
        s1.push(4);
        s1.display();
        System.out.println(s1.peek());

        System.out.println("############");
        DAStack ds1 = new DAStack();
        ds1.push(1);
        ds1.push(2);
        ds1.display();
        ds1.pop();
        ds1.push(3);
        ds1.display();
    }
}


class DAStack{

    private List<Integer> itemList = new ArrayList<>();

    public void push(int ele){
        this.itemList.add(ele);
    }

    public int size(){
        return this.itemList.size();
    }

    public Integer pop(){
        if(this.itemList.isEmpty()){
            System.out.println("Underfllow");
            return -1;
        }else {
            int _size = this.size();
            Integer ele = this.itemList.get(_size-1);
            this.itemList.remove(_size-1);
            return ele;
        }
    }


    public void display(){
        this.itemList.forEach(e ->System.out.println(e));
    }
}

class ArrayStack {
    private int top = -1;
    private int[] elements;
    private int size;

    public ArrayStack(int size) {
        this.size = size;
        this.elements = new int[this.size];
    }

    public void push(int ele) {
        if (this.top == this.size - 1) {
            System.out.println("Overflow error...");
        } else {
            this.top = this.top + 1;
            this.elements[this.top] = ele;
        }
    }

    public boolean isEmpty() {
        return this.top < 0;
    }

    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            this.top--;
            return this.elements[this.top + 1];
        }
    }

    public void display() {
        if (!this.isEmpty()) {
            for (int i = 0; i <= this.top; i++) {
                System.out.println(this.elements[i]);
            }
        }
    }

    public int peek() {
        return this.isEmpty() ? -1 : this.elements[this.top];
    }

}