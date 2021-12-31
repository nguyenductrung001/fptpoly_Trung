package Assignment;

// import java.util.Scanner;

/**
 * employee
 */
public class Employee {

    private String code;
    private String name;
    private String mail;
    private double salary;

    public Employee(String code, String name, String mail, double salary) {
        this.code = code;
        this.name = name;
        this.mail = mail;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // public int addEmployee() {
    // Scanner s = new Scanner(System.in);
    // String inName = null, inCode = null, inMail = null;
    // double inSalary = 0;
    // System.out.println("Nhap ten nhan vien (nhap \"q\" de thôi nhap)");
    // try {
    // inName = s.nextLine();
    // if (!inName.equalsIgnoreCase("q")) {
    // System.out.print("Ma nhan vien:");
    // inCode = s.nextLine();
    // System.out.print("Email:");
    // inMail = s.nextLine();
    // System.out.print("Luong:");
    // inSalary = Double.parseDouble(s.nextLine());
    // } else {
    // return -1;
    // }
    // } catch (Exception e) {
    // System.out.printf("Co loi xay ra: %s\n", e.getLocalizedMessage());
    // return 0;
    // }
    // setName(inName);
    // setCode(inCode);
    // setMail(inMail);
    // setSalary(inSalary);
    // return 1;
    // }
}
