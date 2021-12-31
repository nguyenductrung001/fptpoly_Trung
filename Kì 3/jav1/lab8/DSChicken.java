/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Truong Dep Zai
 */
public class DSChicken {

    ArrayList<chicken> lstCK = new ArrayList<>();

    public void init() {
        lstCK.add(new chicken("phuc", "white", 150));
        lstCK.add(new chicken("Hung", "black", 200));
        lstCK.add(new chicken("Long", "pink", 300));
        lstCK.add(new chicken("Hai", "red", 500));

    }

    public void outputChicken() {
        for (chicken x : lstCK) {
            x.xuat();
        }
    }

    public void findChicken() {
        double min, max;
        Scanner sc = new Scanner(System.in);
        System.out.print("moi ban nhap vao min!");
        min = sc.nextDouble();
        System.out.print("moi ban nhap vao max!");
        max = sc.nextDouble();
        System.out.println("danh sach ban muon tim la:");
        for (chicken x : lstCK) {
            if (x.getPrice() >= min && x.getPrice() <= max) {
                x.xuat();
            }
        }
    }
    public void sortChicken(){
        
        Comparator<chicken> com = new Comparator<chicken>() {
                    @Override
                    public int compare(chicken o1, chicken o2) {
                        Double d = o2.getPrice();
                        Double d1 = o1.getPrice();
                        return d.compareTo(d1);
                    }
                };
         Collections.sort(lstCK, com);
         System.out.println("Danh sach da sap xep!");
        for (int i = 0; i < lstCK.size(); i++) {
            System.out.println(lstCK.get(i));
            
        }
    
    }
    public void printMax(){
                Comparator<chicken> com = new Comparator<chicken>() {
                    @Override
                    public int compare(chicken o1, chicken o2) {
                        Double d = o2.getPrice();
                        Double d1 = o1.getPrice();
                        return d.compareTo(d1);
                    }
                };
                Collections.sort(lstCK,com);
                 if (lstCK.size() < 1) {
                for (int j = 0; j < lstCK.size(); j++) {
                System.out.println(lstCK.get(j));}
            } else {
                
                for (int j = 0; j < 1; j++) {
                    System.out.println(lstCK.get(j));
                    
                }
            } 
    }
}
//Lớp DSChicken:
//- 1 ArrayList <Chicken>
//- void init(): thêm 4 phần tử vào list
//- void outputChicken(): xuất thông tin các phần tử, xuất cả trạng thái
//- void findChicken(int min, int max): In các phần tử có price từ min đến max
//- void sortChicken(): sắp xếp các phần tử giảm dần theo price
//- void printMax(): In thông tin các phần tử có price lớn nhất
