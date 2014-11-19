package com.skiplist;

/**
 * Created by davidtian on 11/5/14.
 */
public class SkipListRunner {
    public static void main(String... args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("READY!\n\n");

        SkipList newList = new SkipList();
//        System.out.println("=================");
//        System.out.println(newList);
        newList.insert(2);
//        System.out.println("added 2");
//        System.out.println(newList);
        newList.insert(2);
        newList.insert(10);
        newList.insert(2);
        newList.insert(1);
        newList.insert(7);
        System.out.println("=================");
        System.out.println(newList);
    }
}
