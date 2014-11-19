package com.datastructures.queue;

public class TwoStacksRunner {

    public interface Stack<T> {
        public void push(T obj);
        public T pop();
    }

    public static void main(String args[]) {
        runTestCase1();
    }

    private static void runTestCase1() {
        TwoStacks queue = new TwoStacks();
        queue.put(1);
        queue.put(3);
        queue.put(5);
        System.out.println(queue.get());
        queue.put(7);

        queue.printStacks();
    }

}
