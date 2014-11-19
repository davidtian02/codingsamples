package com.puzzles.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public T mValue;
    public List<Node<T>> mChildren;
    public Node(T value) {
        mValue = value;
    }

    public List<Node<T>> getChildren() {
        return mChildren;
    }

    public void initChildren() {
        mChildren = new ArrayList<Node<T>>();
    }
}
