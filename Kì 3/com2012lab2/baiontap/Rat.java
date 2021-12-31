/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baiontap;

import java.util.Scanner;

/**
 *
 * @author Truong Dep Zai
 */
public class Rat {

    private String name;
    private int weight, speed;

    public Rat() {
    }

    public Rat(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Rat{" + "name=" + name + ", weight=" + weight + ", speed=" + speed + '}';
    }

    public void run() {
        System.out.println("chuột chay với tốc độ:" + speed);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("mời bạn nhập name Rat:");
        name = sc.nextLine();
        System.out.println("Mời bạn nhập weight:");
        weight = Integer.parseInt(sc.nextLine());
        System.out.println("mời bạn nhập speed:");
        speed = Integer.parseInt(sc.nextLine());
    }
    public void xuat(){
        System.out.println(toString());
    }
}
