package com.basic;

import java.util.Stack;

public class PostFixToInfix {

    public String toInFix(String postFixStr){
        Stack<String > oprStack = new Stack<>();

        for(int i=0;i<postFixStr.length();i++){
            Character ch = postFixStr.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                oprStack.push(ch+"");
            }else{
                String s1 = oprStack.pop();
                String s2 = oprStack.pop();
                oprStack.push("("+s2+ch+s1+")");
            }
        }
        return oprStack.pop();
    }

    public int evaluatePostFix(String postFixStr){
        Stack<Integer> oprStack = new Stack<>();

        for(int i=0;i<postFixStr.length();i++){
            Character ch = postFixStr.charAt(i);
            if(Character.isLetter(ch)){
                System.out.println("Can  evaluate expreson...");
                break;
            }else if(Character.isDigit(ch)){
                oprStack.push(Character.getNumericValue(ch));
            }else{
                int i1 = oprStack.pop();
                int i2 = oprStack.pop();
                switch (ch){
                    case '^':
                        oprStack.push( (int) Math.pow(i2,i1));
                        break;
                    case '*':
                        oprStack.push(i2*i1);
                        break;
                    case '/':
                        oprStack.push(i2/i1);
                        break;
                    case '+':
                        oprStack.push(i2+i1);
                        break;
                    case '-':
                        oprStack.push(i2-i1);
                        break;
                }
            }
        }
        return oprStack.pop();
    }

    public static void main(String[] args) {
        System.out.println(  new PostFixToInfix().toInFix("23+4*5/"));
        System.out.println(  new PostFixToInfix().evaluatePostFix("23+4*5/"));

    }
}
