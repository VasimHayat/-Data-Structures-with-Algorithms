package com.basic;

public class ArrayDemoOne {

    public static void main(String[] args) {

//        int[] userIds = new int[10];
//
//        // Type one
//        for(int i=0;i<10;i++){
//            userIds[i] = i+1;
//        }

        // Tupe Two
//        int[] userIds =  {1,2,4,5,6,7,7,8,8,9,9};
//        for (int i = 0; i < userIds.length; i++) {
//            System.out.println(userIds[i]);
//        }


        DynamicArray dynamicArray = new DynamicArray(5);
        dynamicArray.insert(1);
        dynamicArray.insert(2);
        dynamicArray.insert(3);
        dynamicArray.insert(4);
        dynamicArray.insert(5);
System.out.println("##############");
        dynamicArray.print();
        dynamicArray.delete(2);

        System.out.println("##############");
        dynamicArray.print();


        dynamicArray.insert(6);
        dynamicArray.insert(7);
        dynamicArray.insert(8);

        System.out.println("##############");
        dynamicArray.print();

    }
}
