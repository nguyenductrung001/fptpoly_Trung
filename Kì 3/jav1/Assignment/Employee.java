package Assignment;

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

}
