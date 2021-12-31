/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author HongAnh
 */
public class shuffle {
   public static void main(String[] argv) throws Exception {
      String[] alpha = { "A", "E", "I", "O", "U" };
      List list;// ArrayList(alpha);
       list = new ArrayList(alpha);
      Collections.shuffle(list);
      System.out.println("list");
   }   
}
