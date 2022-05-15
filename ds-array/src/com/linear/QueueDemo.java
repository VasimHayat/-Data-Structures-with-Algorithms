package com.linear;

public class QueueDemo {

    public static void main(String[] args) {
        MQueue dsQueue = new MQueue(5);
        dsQueue.enqueue(10);
        dsQueue.enqueue(20);
        dsQueue.display();
        dsQueue.dequeue();
        dsQueue.enqueue(40);
        dsQueue.enqueue(50);
        dsQueue.enqueue(60);
        dsQueue.enqueue(70);
        dsQueue.dequeue();
        dsQueue.dequeue();
        dsQueue.enqueue(80);
        dsQueue.enqueue(90);
        dsQueue.display();
        dsQueue.dequeue();
        dsQueue.dequeue();
        dsQueue.dequeue();
        dsQueue.display();
        dsQueue.dequeue();
        dsQueue.dequeue();
        dsQueue.dequeue();
        dsQueue.display();
       // System.out.println(dsQueue.getFront() + "  @@@@@  " + dsQueue.getRear() + "   " + dsQueue.front + " ---> " + dsQueue.rear);


    }
}


class MQueue{

    int size;
    int front =-1;
    int rear=-1;
    int capacity;
    int eleArray [];


    public MQueue(int size){
        this.capacity = size;
        this.eleArray = new int[this.capacity];
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void dequeue(){
        if(this.isEmpty()){
            System.out.println("Overflow");
        }else{
            this.front = (this.front+1)%this.capacity;
            this.size--;
            if(this.isEmpty()){
                this.front =-1;
            }
        }
    }

    public void enqueue(int ele){
        if(this.isFull()){
            System.out.println("Overflow");
        }else{
            if(this.front == -1){
                this.front =0;
            }
            this.rear = (this.rear+1)%this.capacity;
            this.eleArray[this.rear] = ele;
            this.size++;
        }
    }

    public int peek(){
        if(this.isEmpty()){
            System.out.println("EMPTY");
            return -1;
        }else{
            int index = this.front%this.capacity;
            return this.eleArray[index];
        }
    }

    public void display(){
        System.out.println("############# DISPLAY  START ###################");
        for(int i=0;i<size;i++){
            int index = (this.front+i)%this.capacity;
            System.out.println(" ELEMENT "+this.eleArray[index]);
        }
        System.out.println("############# DISPLAY  END ###################");
    }

}



class DSQueue {

    int front = 0;
    int rear = 0;
    int eleArray[];
    int size;
    private int capacity;   // maximum capacity of the queue

    public DSQueue(int size) {
        this.eleArray = new int[size];
        this.capacity = size;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(int ele) {
        if (this.isFull()) {
            System.out.println("Overflow");
        } else {
//            if(this.front == -1){
//                this.front = 0;
//            }
            this.rear = (this.front + this.size) % this.capacity;
            this.eleArray[this.rear] = ele;
            this.size++;
        }
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            int ele = this.eleArray[this.front];
            this.eleArray[this.front] = 0; // Just for

//             if(this.front == this.rear){
//                 this.front = -1;
//                 this.rear = -1;
//             }else

            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return ele;
        }
    }

    public int getFront() {
        if (this.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            return this.eleArray[this.front];

        }
    }

    public int getRear() {
        if (this.isEmpty()) {
            System.out.println("Underflow");
            return -1;
        } else {
            return this.eleArray[this.rear];

        }
    }

    public void display() {
        System.out.println("############# DISPLAY  START ###################");
        for (int i = 0; i < this.size; i++) {
            int index = (this.front + i) % this.capacity;
            System.out.println("index " + index + " VALUE " + this.eleArray[index]);
        }
        System.out.println("############# DISPLAY  END ###################");
        // System.out.println(Arrays.toString(this.eleArray));
    }
}