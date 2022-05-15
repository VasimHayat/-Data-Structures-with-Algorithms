package com.demo;

public class RecursionDemo {



   // A[123]  B  C -1,2


    public static int  towerOfHanoi(int n,String source, String dest, String aux){
        if(n == 0){
            return  1;
        }
        int move1 =  towerOfHanoi(n-1,source,aux,dest);
        System.out.println(n +" moved from "+source+" to "+aux);
        int move2 = towerOfHanoi(n-1,aux,dest,source);
        System.out.println(n +" moved from "+aux+" to "+dest);
        return move1+move2+1;
    }

    public static  int fib(int num){
        if(num<=1){
            return num;
        }else{
            return fib(num-1)+  fib(num-2);
        }
    }

    public static int GCD(int num1, int num2){
        System.out.println(num1+" ----- "+num2);
        if(num1 == 0){
            return num2;
        }else if(num2 == 0){
            return  num1;
        }else if(num1 == num2){
            return num1;
        }else if(num1>num2){
            return GCD(num2,num1%num2);
        }else{
            return GCD(num1,num2%num1);
        }
    }

    public static void main(String[] args) {
         int limit = 12;
         for(int i=0;i<limit;i++){
             System.out.print(fib(i)+" ");
         }

         System.out.println(GCD(18,27));
        System.out.println(towerOfHanoi(3,"A","B","C"));
    }
}
