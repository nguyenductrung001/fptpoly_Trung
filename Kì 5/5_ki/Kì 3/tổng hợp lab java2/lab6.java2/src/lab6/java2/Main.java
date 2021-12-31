/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.java2;

/**
 *
 * @author Truong Dep Zai
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new OldThread());
        t1.start();
        t1.join();
        Thread t2 = new Thread(new EvenThread());
        t2.start();
    }
}
