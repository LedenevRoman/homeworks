package _2023_06_22.classStructure1;

import java.util.Set;

public class Company {
    private String name;
    private Set<Employee> employees;
    private Set<Department> departments;

    public Company(String name, Set<Employee> employees, Set<Department> departments) {
        this.name = name;
        this.employees = employees;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
