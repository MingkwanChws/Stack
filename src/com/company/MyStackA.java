package com.company;

public class MyStackA {
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int t = 0;

    public void push(double d) {
        if (isFull()) System.out.println("Stack Overflow");
        else stack[t++] = d;
    }

    public double pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
        return stack[--t];
    }

    public double top() {
        return stack[t - 1];
    }

    public boolean isFull() {
        return t == MAX_SIZE;
    }

    public boolean isEmpty() {
        return t == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        while (t > 1) {
            sb.append(stack[--t]);
            sb.append(",");
        }
        t--;
        if (t == 0) sb.append(stack[t]);
        sb.append("]");
        return sb.toString();
    }
}
