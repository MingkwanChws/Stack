package com.company;

import java.util.Stack;
import java.util.Scanner;

public class Main {

    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        String result = new String("");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                int number = 0;
                number = number * 10 + (int) (c - '0'); //'0' = 48  example: p = '1' = 49
                c = exp.charAt(i);
                result = result + " " + c;
            } else if (c == '(')
                stack.push(c);


            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result = result + " " + stack.pop();

                stack.pop();
            } else {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())) {

                    result = result + " " + stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result = result + " " + stack.pop();
        }
        return result;
    }


    public static double calRpn(String post) {
        MyStackA st = new MyStackA();
        for (int i = 0; i < post.length(); i++) {

            char p = post.charAt(i);

            if (p == ' ') continue; // Exit loop
            else if (Character.isDigit(p)) {
                int number = 0;
                while (Character.isDigit(p)) {
                    number = number * 10 + (int) (p - '0'); //'0' = 48  example: p = '1' = 49
                    i++;
                    p = post.charAt(i);
                }
                i--;
                //push
                st.push(number);
            }
            //pop
            else {
                double n1 = st.pop();
                double n2 = st.pop();

                switch (p) {
                    case '*':
                        st.push(n2 * n1);
                        break;

                    case '/':
                        st.push(n2 / n1);
                        break;

                    case '+':
                        st.push(n2 + n1);
                        break;

                    case '-':
                        st.push(n2 - n1);
                        break;
                }
            }
        }
        return st.pop();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===Enter Infix===");
        String input = sc.nextLine();
        //String exp = "5 + 3 * 6 / ( 7 + 1 - 2 * 3 )";
        System.out.println("=== Postfix ===" + infixToPostfix(input));
        System.out.println("ANSWER >>> " + calRpn(infixToPostfix(input)));
    }
}


