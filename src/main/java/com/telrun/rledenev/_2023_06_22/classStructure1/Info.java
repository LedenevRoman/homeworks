package com.telrun.rledenev._2023_06_22.classStructure1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Info {
    private Map<Position, List<String>> positionStringMap = new HashMap<>();

    public Map<Position, List<String>> getPositionStringMap() {
        return positionStringMap;
    }

    public void setPositionStringMap(Map<Position, List<String>> positionStringMap) {
        this.positionStringMap = positionStringMap;
    }

    public void addPosition(Position position) {
        positionStringMap.put(position, List.of("Some info for " + position.toString() + " position"));
    }

    public String checker(Employee employee) {
        return positionStringMap.get(employee.getPosition()).get(0);
    }

    public double avgSalary(Set<Employee> employees, Department department) {
        double sumOfSalary = 0;
        int countOfEmployees = 0;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment())) {
                sumOfSalary += employee.getSalary();
                countOfEmployees++;
            }
        }
        return sumOfSalary / countOfEmployees;
    }

    public Map<String, Double> maxSalary(Set<Employee> employees, Department department) {
        Map<String, Double> result = new HashMap<>();
        String nameOfEmployeeWithMaxSalary = "";
        double maxSalary = -1;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment()) && employee.getSalary() > maxSalary) {
                nameOfEmployeeWithMaxSalary = employee.getName();
                maxSalary = employee.getSalary();
            }
        }
        result.put(nameOfEmployeeWithMaxSalary, maxSalary);
        return result;
    }

    public Map<String, Double> minSalary(Set<Employee> employees, Department department) {
        Map<String, Double> result = new HashMap<>();
        String nameOfEmployeeWithMinSalary = "";
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (department.equals(employee.getDepartment()) && employee.getSalary() < minSalary) {
                nameOfEmployeeWithMinSalary = employee.getName();
                minSalary = employee.getSalary();
            }
        }
        result.put(nameOfEmployeeWithMinSalary, minSalary);
        return result;
    }

    public void getPromotion(Employee employee) {
        if (employee.getPosition().equals(Position.CEO)) {
            System.out.println("Can't get promotion to CEO");
        } else {
            Position[] positions = Position.values();
            int indexOfPosition = 0;
            for (int i = 0; i < positions.length; i++) {
                if (positions[i].equals(employee.getPosition())) {
                    indexOfPosition = i;
                    break;
                }
            }

            employee.setPosition(positions[indexOfPosition + 1]);
            employee.setSalary(employee.getSalary() * 1.25);
        }
    }
}
