/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author HongAnh
 */
public class RunnableTest {
 
   public static void main(String[] args) throws InterruptedException {
 
       System.out.println("Main thread running..");
 
       // Tạo một thread từ Runnable.
       Thread thread = new Thread(new RunnableDemo());
       Thread thread2 = new Thread(new RunnableDemo());
 
       thread.start();
       thread2.start();
        
       // Ngủ 5 giây.
       Thread.sleep(2000);
       
       System.out.println("Main thread stopped");
   }
}
