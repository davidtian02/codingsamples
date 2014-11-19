package com.datastructures.arraylist;

/**
 * Created by davidtian on 9/23/14.
 */
public class ArrayListRunner {

    public static void main(String... args) {
        System.out.println("=============== test 1 ===============");
        runTest1();
        System.out.println("=============== test 2 ===============");
        runTest2();
        System.out.println("=============== test 3 ===============");
        runTest3();
        System.out.println("=============== test 4 ===============");
        runTest4();
    }

    private static void runTest1() {
        SCArrayList<String> list = new SCArrayList<String>();
        System.out.println(list);
    }

    private static void runTest2() {
        SCArrayList<String> list = new SCArrayList<String>();
        list.add("wtf");
        list.add("hi?");
        list.add("how are you?");
        System.out.println(list);
    }

    private static void runTest3() {
        SCArrayList<String> list = new SCArrayList<String>();
        list.add("wtf");
        list.add("yes");
        list.add("okay");
        list.remove(2);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }

    private static void runTest4() {
        SCArrayList<String> list = new SCArrayList<String>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("no");
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("okay");
        System.out.println(list.get(1));
    }
}
