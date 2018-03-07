/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Shulha_U3218
 */
class LambdaGenericFI {

    public static void main(String args[]) {

        Integer iArray[] = new Integer[20];
        for (int i = 0; i < iArray.length; i++) {
            iArray[i] = i;
        }

        FunctionalInterfaceGeneric<Boolean, Integer> numbers = (y) -> y % 2 == 0;
        for (Integer temp : iArray) {
            if (numbers.oneParameter(temp)) {
                System.out.print(temp + " ");
            }
        }
        System.out.println();

        numbers = (y) -> y % 2 != 0;
        for (Integer temp : iArray) {
            if (numbers.oneParameter(temp)) {
                System.out.print(temp + " ");
            }
        }
        System.out.println("\n");

        FunctionalInterfaceGeneric<String, Integer[]> evenString = (x) -> {
            String s = "";
            for (Integer temp : x) {
                if (temp % 2 == 0) {
                    s += temp + " ";
                }
            }
            return s;
        };
        System.out.println(evenString.oneParameter(iArray));

        FunctionalInterfaceGeneric<String, Integer[]> oddString = (x) -> {
            String s = "";
            for (Integer temp : x) {
                if (temp % 2 != 0) {
                    s += temp + " ";
                }
            }
            return s;
        };

        System.out.println(oddString.oneParameter(iArray));
    }
}

interface FunctionalInterfaceGeneric<T, A> {

    T oneParameter(A param1);
}
