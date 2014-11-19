package com.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class ReversalRunner { 

    public static void main(String ... args) {
        runTestCase1();
    }

    public static List<?> reverse(List<?> input) {
        return null;
    }

    private static void runTestCase1() {
        LinkedList<String> sample = new LinkedList<String>();
        sample.add("one");
        sample.add("two");
        sample.add("three");
        List<?> result = reverse(sample);

    }

    private static boolean areListsEqual(List<?> a, List<?> b) {
        if (a != b || a == null || b == null || a.size() != b.size()) {
            return false;
        } else {
            for (int i=0; i<a.size(); i++) {
                Object temp1 = a.get(i), temp2 = b.get(i);
                if (temp1 != temp2 || (temp1 == null || temp2 == null)) {
                    return false;
                }
                if (!a.equals(b)) {
                    return false;
                }
            }
        }

        return true;
    }
}
