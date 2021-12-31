/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assment1;

/**
 *
 * @author Truong Dep Zai
 */
public class Employee {
    public String code , name,Email;
    public int age;
    public double salary;

    public Employee() {
    }

    public Employee(String code, String name, String Email, int age, double salary) {
        this.code = code;
        this.name = name;
        this.Email = Email;
        this.age = age;
        this.salary = salary;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
