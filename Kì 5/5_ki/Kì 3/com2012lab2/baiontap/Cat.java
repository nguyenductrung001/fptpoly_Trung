/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baiontap;

import java.util.Scanner;

public class Cat {

    private String name;
    private int speed;

    public Cat() {
    }

    public Cat(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", speed=" + speed + '}';
    }

    public void run() {
        System.out.printf("tốc độ của cat là:" + speed);
    }

    public boolean catchRat(Rat rat) {
        if (speed == rat.getSpeed()) {
            return true;
        } else {
            return false;
        }
    }
    
    public  void eatRat (Rat food){
        if(catchRat(food)) {
            if(food.getWeight()<=5){
                System.out.println("Mum MUm hơi gầy");
            }else{
            System.out.println("Mum MUm ngon tuyệt");
        }
        } else{
            System.out.println("meo meo đói quá");
        } 
                    
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("mời bạn nhập name Cat:");
        name = sc.nextLine();
        System.out.println("mờ bạn nhập speed của Cat:");
        speed = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.println(toString());
    }
}
