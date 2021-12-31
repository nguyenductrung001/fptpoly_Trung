/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baiontap;


public class GameRatandCat {
    public static void main(String[] args) {
        Cat meo = new Cat("tom", 15);
        Rat chuot = new Rat("jerry", 3, 15);
        // cho mèo bắt chuột
        meo.catchRat(chuot);
        meo.eatRat(chuot);
    }
}
