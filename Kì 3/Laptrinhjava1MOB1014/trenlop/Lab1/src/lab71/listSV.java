/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.util.ArrayList;
import java.util.List;

public class listSV<T> {
    List<sinhvienpoly> ls = (List<sinhvienpoly>) new ArrayList<T>();
    public void nhapSvTolist(T t)
    {
    ls.add((sinhvienpoly) t);
    }
    public void xuatlistsv(){
         for(sinhvienpoly sv : ls)
         {
            sv.xuat();
         }
             }
    public void xuatlisthsg(){
         for(sinhvienpoly sv : ls)
         {
             if(sv.getdiemTB()>=8)
             {
                 System.out.println("hoc sinh gioi :");
            sv.xuat();
             }
             }
             }
}
