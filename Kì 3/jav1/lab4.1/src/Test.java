/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Truong Dep Zai
 */
public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.nhap();
        //cat1.print();
        System.out.println(cat1.getXeploai());
        
        Cat cat2 = new Cat("meo tam the", 2, 1);
        cat2.nhap();
        System.out.println(cat2.getXeploai());
    }
}
