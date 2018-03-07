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
class JavaException {

    public static void main(String args[]) {
        try {
            int d = 1;
            int n = 20;
            int fraction = n / d;
            int g[] = {
                1
            };
            g[0] = 100;
        } /*catch(Exception e){
  	System.out.println("In the catch clock due to Exception = "+e);
  }*/ catch (ArithmeticException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("In the catch clock due to Exception = " + e);
        } finally {
            System.out.println("Inside the finally block");
        }
        System.out.println("End Of Main");
    }
}
