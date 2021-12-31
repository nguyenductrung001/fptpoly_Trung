/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datainputexample;

import java.io.Serializable;

public class Stock implements Serializable{
 private int id;
 private String desc;
 private double price;
 private int quantity;

 public Stock(int id, String desc, double price, int quantity) {
   this.id = id;
   this.desc = desc;
   this.price = price;
   this.quantity = quantity;
 }

 @Override
 public String toString() {
    return id + "-" + desc + "-" + price + "-" + quantity;
 } 
}
