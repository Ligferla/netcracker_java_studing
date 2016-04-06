package ru.ncedu.java.tasks;

public class Main {

    public static void main(String[] args) {
        Employee emp = new EmployeeImpl();
        emp.increaseSalary(10);
        emp.setFirstName("Diana");
        emp.setLastName("Khammatova");
        
        Employee manager = new EmployeeImpl2();
        manager.setFirstName("Anton");
        manager.setLastName("Grigoriev");
        emp.setManager(manager);
        Employee superManager = new EmployeeImpl2();
        superManager.setFirstName("Dima");
        superManager.setLastName("Nikolaev");
        manager.setManager(superManager);
        
        Employee emp2 = emp.getTopManager();
        System.out.println(emp2.getFirstName());
    }

}
