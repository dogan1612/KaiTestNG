package com.Java;

import java.util.*;

public class Frequency {
    public static void main(String[] args) {

        String sentence ="my my my home sweet home";
        frequency(sentence);
    }

    public static void frequency(String str){
        List list = new ArrayList(Arrays.asList(str.split(" ")));
        Set set = new HashSet(list);
        for (Object each:set) {
            System.out.print(each +"="+Collections.frequency(list, each)+" ");
        }
    }
}
