package com.datastructures.queue;

import java.util.Stack;

public class TwoStacks implements Queue<Object>{

    private final Stack<Object> mLeftStack;
    private final Stack<Object> mRightStack;

    public TwoStacks() {
        mLeftStack = new Stack<Object>();
        mRightStack = new Stack<Object>();
    }

    @Override
    public Object get() {
        synchronized (this) {
            if (mRightStack.isEmpty()) {
                transfer();
            }

            synchronized (mRightStack) {
                return mRightStack.pop(); // or atomic pop, with no synchronized on mRightStack
            }
        }
    }

    @Override
    public void put(Object obj) {
        synchronized (this) {
            synchronized (mLeftStack) {
                mLeftStack.push(obj); // or atomic push, with no synchronized on mLeftStack
            }
        }
    }

    private void transfer() {
        synchronized (this) {
            while (!mLeftStack.isEmpty()) {
                mRightStack.push(mLeftStack.pop());
            }
        }
    }

    public void printStacks() {
        System.out.println("left stack is: " + mLeftStack.toString());
        System.out.println("right stack is: " + mRightStack.toString());
    }
}
