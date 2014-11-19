package com.puzzles.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class DictionaryData {
    public static DictionaryData sInstance;
    private static String[] sPrimitiveData = new String[]{
            "hello",
            "hell",
            "help",
            "goodbye",
            "okay",
            "gogo",
            "power rangers!"
    };
    private List<String> sData = new ArrayList<String>();

    public static DictionaryData getInstance(){
        if (sInstance == null) {
            sInstance = DictionaryDataFactory.create();
            for (String s : sPrimitiveData) {
                sInstance.sData.add(s);
            }
        }
        return sInstance;
    }

    public List<String> getData() {
        return sData;
    }

    static class DictionaryDataFactory {
        public static DictionaryData create() {
            return new DictionaryData();
        }
    }
}
