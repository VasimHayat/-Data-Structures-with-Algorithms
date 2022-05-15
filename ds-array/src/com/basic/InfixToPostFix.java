package com.basic;

import java.util.Stack;

public class InfixToPostFix {


    private int precedence(Character ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();  // removing "(" from stack
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }


    private String toPostFix(String infixStr) {
        StringBuilder postFixStr = new StringBuilder();
        Stack<Character> opStack = new Stack();
        int strLen = infixStr.length();

        for (int i = 0; i < strLen; i++) {
            char ch = infixStr.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postFixStr.append(ch);
            } else if (ch == '(') {
                opStack.push(ch);
            } else if (ch == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    postFixStr.append(opStack.pop());
                }
                  opStack.pop(); // removing "(" from stack
            } else {
                  while (!opStack.isEmpty() && precedence(ch)<=this.precedence(opStack.peek())){
                        postFixStr.append(opStack.pop());
                  }
                opStack.push(ch);
            }
        }

        while (!opStack.isEmpty()) {
            postFixStr.append(opStack.pop());
        }
        return postFixStr.toString();
    }


    public static void main(String[] args) {
          String str ="a+b*(c^d-e)^(f+g*h)-i";
          System.out.println(new InfixToPostFix().toPostFix(str));
          System.out.println(new InfixToPostFix().infixToPostfix(str));
    }
}
