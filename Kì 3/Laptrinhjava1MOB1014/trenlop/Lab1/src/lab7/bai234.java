package lab7;
/**
 * bai234
 */
public class bai234 {

    public static void main(String[] args) {
        Listsinhvien<SinhvienIT> lsIt = new Listsinhvien<>();
        SinhvienIT it = new SinhvienIT();
        it.nhap();
        lsIt.nhap(it);
        lsIt.xuat();
        lsIt.xuatlisthsg();
        
        Listsinhvien<SinhvienBiz> lsBIZ= new Listsinhvien<>();
        SinhvienBiz BIZ = new SinhvienBiz();
        BIZ.nhap();
        lsBIZ.nhap(BIZ);
        lsBIZ.xuat();
        lsBIZ.xuatlisthsg();
    }
}