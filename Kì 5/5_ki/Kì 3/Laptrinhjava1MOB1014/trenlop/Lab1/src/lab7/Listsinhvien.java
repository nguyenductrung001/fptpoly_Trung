package lab7;

import java.util.ArrayList;
import java.util.List;

public class Listsinhvien<T> implements InterfaceSinhvienFpoly{
    List<SinhvienFpoly> ls = new ArrayList<SinhvienFpoly>();
    
       public void nhap(T t) {
       ls.add((SinhvienFpoly) t);
    }
       
    @Override
    public void xuat() {
        for(SinhvienFpoly sv : ls)
         {
            sv.xuat();
         }
    }
    public void xuatlisthsg(){
         for(SinhvienFpoly sv : ls)
         {
             if(sv.getDiemTB()>=8)
             {
                 System.out.println("hoc sinh gioi :");
            sv.xuat();
             }
             }
             }

    @Override
    public double getDiemTB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nhap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}