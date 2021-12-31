package lab7;

/**
 * SinhvienFpoly
 */
abstract class SinhvienFpoly {

    private String name;
    private String major;

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    abstract public Double getDiemTB();

    abstract public void nhap();

    public void xuat() {
        System.out.printf("%s, nganh: %s, học luc: %s\n", this.name.toUpperCase(), this.major, this.getHocluc());
    }

    public String getHocluc() {
        if (this.getDiemTB() < 5) {
            return "Yeu";
        } else if (this.getDiemTB() < 6.5) {
            return "Trung binh";
        } else if (this.getDiemTB() < 7.5) {
            return "Kha";
        } else if (this.getDiemTB() < 9) {
            return "Gioi";
        } else {
            return "Xuat sac";
        }
    }
}