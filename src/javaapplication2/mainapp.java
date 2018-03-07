/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;

/**
 *
 * @author Shulha_U3218
 */
public class mainapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Creating a generic ArrayList
        ArrayList arlTest = new ArrayList();
        //Size of arrayList
        System.out.println("Size of ArrayList at creation: " + arlTest.size());
        //Lets add some elements to it
        arlTest.add("D");
        arlTest.add("U");
        arlTest.add("K");
        arlTest.add("E");

        //Recheck the size after adding elements
        System.out.println("Size of ArrayList after adding elements: " + arlTest.size());

        //Display all contents of ArrayList
        System.out.println("List of all elements: " + arlTest);

        //Remove some elements from the list
        arlTest.remove("D");
        System.out.println("See contents after removing one element: " + arlTest);

        //Remove element by index
        arlTest.remove(2);
        System.out.println("See contents after removing element by index: " + arlTest);

        //Check size after removing elements
        System.out.println("Size of arrayList after removing elements: " + arlTest.size());
        System.out.println("List of all elements after removing elements: " + arlTest);

        //Check if the list contains "K"
        System.out.println(arlTest.contains("K"));

    }

}
