/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;


abstract class sinhvienpoly {
    private String hoten;
    private String ngang;
    
    abstract public double getdiemTB();
    abstract public void nhap();

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgang() {
        return ngang;
    }

    public void setNgang(String ngang) {
        this.ngang = ngang;
    }
    
 //   
    
    public void xuat(){
        System.out.printf("SVPoly: Ho Ten: %s; Ngang: %s; Hoc luc: %s",
                this.hoten, this.ngang, this.gethocluc() );
        System.out.println("");
    }
    public String gethocluc(){
        String xeploai="";
        if(this.getdiemTB()<5){
              xeploai = "Yeu";
        }
        else if(this.getdiemTB() <6.5){
              xeploai= "TB";
        }
        else if(this.getdiemTB() <8){
              xeploai= "kha";
        }
        else {
              xeploai= "gioi";
        }
        return xeploai;
    };
}
