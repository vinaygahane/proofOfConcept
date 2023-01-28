package in.ineuron.main;

import in.ineuron.bean.Account;
import in.ineuron.bean.Employee;

public class TestApp {
    public static void main(String[] args) {
        Account account = new Account("abc123","Vin","savings");

        //constructor Injection
        Employee emp = new Employee("1","Vinay","Gad",account);
        emp.getEmployeeDetails();
    }
}
