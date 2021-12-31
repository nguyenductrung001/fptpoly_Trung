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
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
 
       int idx = 1;
 
//       for (int i = 0; i < 10; i++) {
// 
//           System.out.println("Main thread running " + idx++);
//           // Ngủ 2101 milli giây.
//           Thread.sleep(1101);
//       }
 
       HelloThread helloThread = new HelloThread();
       HelloThread helloThread2 = new HelloThread();
       
       //Thread threadRunable = new Thread(new RunnableDemo());
       // Chạy thread
       helloThread2.setPriority(10);
       
       //threadRunable.start();
  
       helloThread.start();
       helloThread2.start();
 
//       for (int i = 0; i < 3; i++) {
//           System.out.println("Main thread running " + idx++);
//           // Ngủ 2101 milli giây.
//           Thread.sleep(2101);
//       }
 
       System.out.println("==> Main thread stopped");
   }
    
}
