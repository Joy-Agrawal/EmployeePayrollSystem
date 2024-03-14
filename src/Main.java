import java.util.ArrayList;
import java.util.Scanner;
//this project does not use Database Connection;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name ,int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee[name = "+name+", id = "+id+", salary = "+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{

    private ArrayList<Employee> employeeList;
    private int idCount = 0;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        this.employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee toRemove = null;
        for (Employee employee :
                employeeList) {
            if(employee.getId() == id){
                toRemove = employee;
                break;
            }
        }
        if(toRemove != null){
            employeeList.remove(toRemove);
        }
        else{
            System.out.println("Employee Not Exists");
        }
    }

    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
    public void displayEmp(int id){
        Employee toDisplay = null;
        for (Employee employee :
                employeeList) {
            if(employee.getId() == id){
                toDisplay = employee;
                break;
            }
        }
        if(toDisplay != null){
            System.out.println(toDisplay);
        }
        else{
            System.out.println("Employee Not Exists");
        }
    }
    public void addFullTimeEmployee(Scanner sc){
        String name;
        int id;
        double salary;
        System.out.println("Please enter the name of the employee");
        name = sc.nextLine();
        id = ++idCount;
        System.out.println("Please enter the salary for the employee");
        salary = sc.nextDouble();
        Employee emp = new FullTimeEmployee(name,id,salary);
        employeeList.add(emp);
    }
    public void addPartTimeEmployee(Scanner sc){
        String name;
        int id;
        int hoursWorked;
        double hourlySalary;
        System.out.println("Please enter the name of the employee");
        name = sc.nextLine();
        id = ++idCount;
        System.out.println("Please enter the Hours worked for the employee");
        hoursWorked = sc.nextInt();
        System.out.println("Please enter the salary for the employee");
        hourlySalary = sc.nextDouble();
        Employee emp = new PartTimeEmployee(name,id,hoursWorked,hourlySalary);
        employeeList.add(emp);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();
        int choice = sc.nextInt();
        while(choice != 0){
            System.out.println("Enter your choice please");
            System.out.println("1.Add A Full Time Employee");
            System.out.println("2.Add A PartTime Employee");
            System.out.println("3.Find Employee Details");
            System.out.println("4.Display All Emplyoees");
            System.out.println("5.Remove any Employee");
            System.out.println("0.Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    payrollSystem.addFullTimeEmployee(sc);
                    break;
                case 2:
                    payrollSystem.addPartTimeEmployee(sc);
                    break;
                case 3:
                    System.out.println("Enter the id of the Employee");
                    int id = sc.nextInt();
                    payrollSystem.displayEmp(id);
                    break;
                case 4:
                    payrollSystem.displayEmployees();
                    break;
                case 5:
                    System.out.println("Enter the id of the Employee");
                    id = sc.nextInt();
                    payrollSystem.removeEmployee(id);
                    break;
                case 0:
                    System.out.println("Hope You Enjoyed using our software");
                    break;
                default:
                    System.out.println("please enter a valid choice");
                    break;
            }
        }
//        System.out.println("Enter your choice");
//        FullTimeEmployee emp1 = new FullTimeEmployee("Paras",1,70000.0);
//        PartTimeEmployee emp2 = new PartTimeEmployee("yogesh",2,15,1000);
//        payrollSystem.addEmployee(emp1);
//        payrollSystem.addEmployee(emp2);
//        System.out.println("Initial Employee Details : ");
//        payrollSystem.displayEmployees();
//        System.out.println("Removing Employees");
//        payrollSystem.removeEmployee(2);
//        System.out.println("Remaining Employee Details : ");
//        payrollSystem.displayEmployees();

    }
}