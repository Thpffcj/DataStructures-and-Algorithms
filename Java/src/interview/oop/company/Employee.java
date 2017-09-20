package interview.oop.company;

import java.util.List;
import java.util.Objects;

/**
 * Created by Thpffcj on 2017/9/19.
 */
public class Employee {

    static List<Employee> allEmployees;

    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name) {
        this(name, 0);
    }

    void doWork() {

    }

    void getPaid(BankEndPoint bank) {
        bank.payment(name, salary);
    }

    // Package private for logic in the package to control
    // when employees are loaded.
    static void loadAllEmployees() {
        // Loads all employees from database.
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(this.name, other.name)
                && Objects.equals(this.salary, other.salary);
    }

    @Override
    public String toString() {
        return "Employee [name=" + name
                + ", salary=" + salary + "]";
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

