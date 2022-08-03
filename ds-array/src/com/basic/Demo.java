package com.basic;

import java.util.Arrays;
import java.util.Stack;

public class Demo {

    static int precedence(Character c){
        switch (c){
            case '^':return 4;
            case '/':return 3;
            case '*' :return 2;
            case '+':return 1;
            case '-':return 1;
            default:return -1;
        }
    }

     static String toPostFix(String infix){
        String postFixStr ="";
        Stack<Character> oprStack = new Stack<>();
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                postFixStr+=ch;
            }else if(ch =='('){
                oprStack.push(ch);
            }else if(ch == ')'){
                while (!oprStack.isEmpty() && oprStack.peek()!='('){
                    postFixStr+=oprStack.pop();
                }
                oprStack.pop();
            }else{
                while (!oprStack.isEmpty() && precedence(ch)<precedence(oprStack.peek())){
                    postFixStr+=oprStack.pop();
                }
                oprStack.push(ch);
            }
        }
        while (!oprStack.isEmpty()){
            postFixStr += oprStack.pop();
        }
        return postFixStr;
    }


    static String toInfix(String postFix){
        String infixStr ="";
        Stack<String > oprandStack = new Stack<>();

        for(int i=0;i<postFix.length();i++){
            Character ch = postFix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                oprandStack.push(ch.toString());
            }else {
                String ch1 = oprandStack.pop();
                String ch2 = oprandStack.pop();
                oprandStack.push("("+ch2+""+ch+""+ch1+")");
            }
        }
        while (!oprandStack.isEmpty()){
            infixStr+=oprandStack.pop();
        }
        return infixStr;
    }

    public static void countSort(int [] eleArray){
        int min = Arrays.stream(eleArray).min().orElse(0);
        int max = Arrays.stream(eleArray).max().orElse(Integer.MAX_VALUE);
        int range =  max-min+1;
        int countArray [] = new int[range];
        for(int ele:eleArray){
            countArray[ele-min]++;
        }
        for(int i=1;i<range;i++){
            countArray[i] = countArray[i-1]+countArray[i];
        }
        int sortedArray [] = new int[eleArray.length];

        for(int i=eleArray.length-1;i>=0;i--){
             int ele = eleArray[i];
             int pos = countArray[ele-min];
             int index = pos-1;
             sortedArray[index] = ele;
             countArray[ele-min]--;
        }

        for(int e :sortedArray){
            System.out.print(e+ " ");
        }
    }

   // 280,12,33,447



    public static void rCuntSort(int [] eleArray,int exp){
        int countArray [] = new int[10];
        for(int ele:eleArray){
            countArray[(ele/exp)%10]++;
        }
        for(int i=1;i<10;i++){
            countArray[i] = countArray[i-1]+countArray[i];
        }
        int sortedArray [] = new int[eleArray.length];

        for(int i=eleArray.length-1;i>=0;i--){
            int ele = eleArray[i];
            int pos = countArray[(ele/exp)%10];
            int index = pos-1;
            sortedArray[index] = ele;
            countArray[(ele/exp)%10]--;
        }
        for(int i=0;i<sortedArray.length;i++){
            eleArray[i] = sortedArray[i];
        }
    }

    public static void redixSort(int [] eleArray){
        int exp =1;
        int max = Arrays.stream(eleArray).max().orElse(Integer.MAX_VALUE);
        while (exp<= max){
            rCuntSort(eleArray,exp);
            exp = exp*10;
        }
        for(int e :eleArray){
            System.out.print(e+ " ");
        }
    }

    public static void main(String[] args) {
//        String strVal ="x+y(z^p-q)";
//        String postFixStr = toPostFix(strVal);
//        System.out.println(postFixStr);
//        System.out.println(toInfix("abcd^ef-gh*+^*+i-"));
        //countSort(new int[]{9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9});
       // redixSort(new int[]{12,62,234,9875,7});


        int [ ] arr = new int [ ] {90,200,30,55,600,300,400};

        int temp = 0;



        for (int i = 0; i < arr.length; i++)

        {

            for (int j = i+1; j < arr.length; j++)

            {

                if(arr[i] < arr[j])

                {

                    temp = arr[i];

                    arr[i] = arr[j];

                    arr[j] = temp;

                }

            }

        }

        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}
