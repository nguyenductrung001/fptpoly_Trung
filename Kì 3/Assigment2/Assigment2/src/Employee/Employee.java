package Employee;

import java.io.Serializable;

import java.io.Serializable;

/**
 *
 * @author user-ma
 */
public class Employee implements Serializable {

    private String code;
    private String name;
    private int age;
    private String email;
    private Double salary;

    public Employee() {
    }

    public Employee(String code, String name, int age, String email, Double salary) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
