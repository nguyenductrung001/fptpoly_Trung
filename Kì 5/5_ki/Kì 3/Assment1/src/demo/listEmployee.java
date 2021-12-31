/**
 * ListEmployee
 */

import java.util.ArrayList;

public class listEmployee {
    private ArrayList<Employee> employees;

    public listEmployee() {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void updateEmployee(int index, Employee employee) {
        this.employees.set(index, employee);

    }

    public void removeEmployee(int index) {
        this.employees.remove(index);
    }
}