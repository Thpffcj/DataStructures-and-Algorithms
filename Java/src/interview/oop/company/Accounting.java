package interview.oop.company;

/**
 * Created by Thpffcj on 2017/9/19.
 */
public class Accounting {

    BankEndPoint bank;

    void payAll() {
        Employee.loadAllEmployees();
        for (Employee employee : Employee.allEmployees) {
            employee.getPaid(bank);
        }
    }
}
