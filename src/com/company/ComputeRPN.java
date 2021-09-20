package com.company;

import java.util.Scanner;

public class ComputeRPN {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter Postfix : ");
//        String input = sc.nextLine();
//
//        System.out.println("Answer >> " + calRpn(input));
//    }

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
}
