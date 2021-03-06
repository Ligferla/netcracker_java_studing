package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {

    public EmployeeImpl() {
        this.firstName = "";
        this.lastName = "";
        this.salary = 1000;
    }

    public void increaseSalary(int value) {
        this.salary += value;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getManagerName() {
        if (manager == null) {
            return "No manager";
        }
        return this.manager.getFirstName() + " " + this.manager.getLastName();
    }

    public int getSalary() {
        return this.salary;
    }

    public Employee getTopManager() {
        if (this.manager == null) {
            return this;
        }
        return this.manager.getTopManager();
    }
    private String firstName;
    private String lastName;
    private int salary;
    private Employee manager;
}