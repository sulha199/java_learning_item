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
class Outer_Demo {
    // private variable of the outer class

    private int num = 175;

    // inner class
    public class Inner_Demo {

        public int getNum() {
            System.out.println("This is the getnum method of the inner class");
            return num;
        }
    }
}

class My_class2 {

    public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo outer = new Outer_Demo();

        // Instantiating the inner class
        Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}
