package com.Java;

// FIND THE BIGGEST NUMBER IN AN ARRAY

public class FindMax {
    public static void main(String[] args) {
        int[] array = {1,-50,453, 3};
        System.out.println( findMax(array) );

    }

    public static int findMax(int[] array){
        int max = array[0];
        for(int i: array){
            if(i> max)
                max = i;
        }
        return max;
    }
}
