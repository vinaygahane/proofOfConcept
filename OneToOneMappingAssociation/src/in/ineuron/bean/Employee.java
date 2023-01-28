package in.ineuron.bean;



//Dependant object
public class Employee {
    private String eid;
    private String ename;
    private String eaddr;

    //HAS-A relationship
    Account account;

    public Employee(String eid, String ename, String eaddr, Account account) {
        this.eid = eid;
        this.ename = ename;
        this.eaddr = eaddr;
        this.account = account;
    }

    public void getEmployeeDetails(){
        System.out.println("Employee details are ::");
        System.out.println(eid);
        System.out.println(ename);
        System.out.println(eaddr);

        System.out.println("Account details are::");
        System.out.println(account.accName);
        System.out.println(account.accNo);
        System.out.println(account.accType);
    }
}
