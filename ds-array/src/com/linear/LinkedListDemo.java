package com.linear;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        DSLinkedList list = new DSLinkedList();
        list.insertAt(1);
        list.insertAt(2);
        list.display();
        list.deleteAt(1);
        list.display();
    }
}


class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}


class DSLinkedList{

    Node head;

    // insert at end
    public void insertAt(int data){
        Node n = new Node(data);

        if(this.head == null){
            this.head = n;
            return;
        }
        Node temp = this.head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
    }

    public void insertAtBegin(int data){
        Node n = new Node(data);

        if(this.head == null){
            this.head = n;
            return;
        }
        n.next = this.head;
        this.head = n;
    }

    public void insertAt(int data,int index){
      if(index == 0){
           this.insertAtBegin(data);
      }else{
          Node n = new Node(data);
          Node temp = this.head;

          for(int i=0;i<index-1;i++){
              if(temp.next == null && i != index-1){
                  System.out.println("Invalid index");
              }else{
                  temp = temp.next;
              }
          }
          n.next= temp.next;
          temp.next = n;

      }
    }

    // delete at first
    public int deleteLast(){
        if(this.head == null){
            System.out.println("Linked list is empty");
            return -1;
        }
        Node temp = this.head;
        while (temp.next != null && this.head.next.next !=null){
            temp = temp.next;
        }
        Node n = temp.next;
        temp.next = temp.next.next;
        return n.data;
    }

    public int deleteAtStart(){
        if(this.head == null){
            System.out.println("Linked list is empty");
            return -1;
        }
        Node temp = this.head;
        if(this.head.next != null){
            this.head = this.head.next;
        }
        temp.next = null;
        return temp.data;
    }

    public int deleteAt(int index){
        if(index == 0){
            return this.deleteAtStart();
        }else{
            Node temp = this.head;

//            while (temp.next != null){
//                temp = temp.next;
//            }

            for(int i=0;i<index-1;i++){
                if(temp.next == null && i != index-1){
                    System.out.println("Invalid index");
                }else{
                    temp = temp.next;
                }
            }
            Node deletedNode = temp.next;
            temp.next= deletedNode.next;
            return deletedNode.data;
        }
    }

    public void display(){
        Node n = this.head;
        System.out.println("DISPLAYY>>>>");
        while (n!=null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("DISPLAYY>>>>");
    }
}