package _2023_06_13;

import java.util.*;

//Создание и компоновка классов
public class CT3 {
    /**
     * 1:
     * Создайте класс Employee, содержащий информацию о сотрудниках в виде Map<Integer, String>,
     * где ключом является идентификатор сотрудника, а значением - его имя.
     * Создайте метод printEmployees(), который будет перебирать и выводить
     * информацию о сотрудниках.
     */

    /**
     * 2:
     * Создайте класс ProductCatalog, содержащий информацию о продуктах в виде Set<String>.
     * Реализуйте метод sortAndPrintCatalog(), который будет перебирать и сортировать
     * информацию о продуктах в алфавитном порядке, используя цикл for-each и Comparable,
     * и выводить отсортированный каталог на экран.
     */

    public static void main(String[] args) {
        new Employee(1, "Ivan");
        new Employee(2, "Petr");
        Employee employee = new Employee(3, "Sidr");

        employee.printEmployees();

        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.addProduct("Pizza")
                .addProduct("Cookies")
                .addProduct("Chocolate")
                .addProduct("Beer");

        productCatalog.sortAndPrintCatalog();
    }
}

class Employee {
    private int id;
    private String name;

    private static final Map<Integer,String> EMPLOYEES = new HashMap<>();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        EMPLOYEES.put(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printEmployees() {
        EMPLOYEES.forEach((id, name) -> System.out.println("ID: " + id + ", Name: " + name));
    }

}

class ProductCatalog {
    private static final Set<String> PRODUCT_CATALOG = new HashSet<>();

    public ProductCatalog addProduct(String name) {
        PRODUCT_CATALOG.add(name);
        return this;
    }

    public void sortAndPrintCatalog() {
        PRODUCT_CATALOG.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
}