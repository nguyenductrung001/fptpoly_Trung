/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;


public class bai1 {
    public static void main(String[] args) {
         listSV<sinhvienIT> lsIT = new listSV<sinhvienIT>();
         sinhvienIT svIT = new sinhvienIT();
         svIT.nhap();
         lsIT.nhapSvTolist(svIT);
         lsIT.xuatlistsv();
         lsIT.xuatlisthsg();
         
          listSV<sinhvienBIZ> lsBIZ = new listSV<sinhvienBIZ>();
         sinhvienBIZ svBIZ = new sinhvienBIZ();
         svBIZ.nhap();
         lsBIZ.nhapSvTolist(svBIZ);
         lsBIZ.xuatlistsv();
         lsBIZ.xuatlisthsg();
    }
}
