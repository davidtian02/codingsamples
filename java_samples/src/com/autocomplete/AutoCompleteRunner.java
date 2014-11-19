package com.autocomplete;

public class AutoCompleteRunner {

    public static void main(String[] args) {
        runTestCase1();
        runTestCase2();
        runTestCase3();
    }

    private static void runTestCase1() {
        AutoCompleteCalculator autoCompleteCalculator = new AutoCompleteCalculator(DictionaryData.getInstance().getData());
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters(null) == 0);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("") == 0);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("a") == 0);
        System.out.println("Test 1 passed.");
    }

    private static void runTestCase2() {
        AutoCompleteCalculator autoCompleteCalculator = new AutoCompleteCalculator(DictionaryData.getInstance().getData());
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("hello") == 2);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("help") == 2);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("hell") == 2);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("go") == 1);
        System.out.println("Test 2 passed.");
    }

    private static void runTestCase3() {
        AutoCompleteCalculator autoCompleteCalculator = new AutoCompleteCalculator(DictionaryData.getInstance().getData());
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("he") == 1);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("glorious") == 0);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("ko") == 0);
        assertTrue(autoCompleteCalculator.calculateAutoCompletedLetters("*") == 0);
        System.out.println("Test 3 passed.");
    }

    private static void assertTrue(boolean assertion) {
        if (!assertion) {
            throw new RuntimeException("Your test failed");
        }
    }
}
