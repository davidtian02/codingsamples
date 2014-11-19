package com.puzzles.autocomplete;

import java.util.List;

public class AutoCompleteCalculator {

    private final Node<Character> mRoot;

    public AutoCompleteCalculator(List<String> data) {
        Node<Character> root = new Node<Character>(null);
        for (String s : data) {
            Node<Character> temp = root;
            for (char c : s.toCharArray()) {
                List<Node<Character>> children = temp.getChildren();
                if (children == null) {
                    temp.initChildren();
                    temp = addNewNode(temp, c);
                } else {
                    boolean foundLetter = false;
                    for (Node<Character> node : children) {
                        if (node.mValue.equals(c)) {
                            temp = node;
                            foundLetter = true;
                            break;
                        }
                    }
                    if (!foundLetter) { // this means that we're branching off to a new word
                        temp = addNewNode(temp, c);
                    }
                }
            }
            if (temp.getChildren() != null) { // this means we have word(s) in the dictionary of which includes this word.
                temp.getChildren().add(new Node<Character>(null));
            }
        }

        mRoot = root;
    }

    public int calculateAutoCompletedLetters(String word) {
        if (word == null) {
            return 0;
        }

        int autoCompleteableCharacters = 0;
        Node<Character> temp = mRoot;
        for (char c : word.toCharArray()) {
            List<Node<Character>> children = temp.getChildren();
            if (children == null) {
                break;
            } else if (children.size() == 1) {
                if (children.get(0).mValue.equals(c)) {
                    autoCompleteableCharacters++;
                } else { // you actually just wanna end it here
                    return autoCompleteableCharacters;
                }

                temp = children.get(0);
            } else {
                boolean found = false;
                for (Node<Character> node : children) {
                    if (node.mValue.equals(c)) {
                        temp = node;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            }
        }
        return autoCompleteableCharacters;
    }

    private Node<Character> addNewNode(Node<Character> temp, char c) {
        Node<Character> newNode = new Node<Character>(c);
        temp.getChildren().add(newNode);
        temp = newNode;
        return temp;
    }

}
