/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_java2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Truong Dep Zai
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student sv1 = new Student();
        sv1.name = "trung";
        sv1.major = "CNTT";
        sv1.marks = 7.0;
        map.put(sv1.name, sv1);
        
        Student sv2 = new Student();
        sv2.name = "sơn";
        sv2.major = "udpm";
        sv2.marks = 7.0;
        map.put(sv2.name, sv2);
        
        Student sv3 = new Student();
        sv3.name = "hai";
        sv3.major = "mkt";
        sv3.marks = 7.0;
        map.put(sv3.name, sv3);
        
       

        Set<String> keys = map.keySet();
        for (String name : keys) {
            Student sv = map.get(name);
            System.out.println(">Họ và tên: " + sv.name);
            System.out.println(">Học lực: " + sv.getGrade());
        }
    }
}
