import java.util.*;
public class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    public void raiseSalary(double percent){
        salary=salary+(salary*percent/100);
    }

    public void display(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(salary);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Employee e=new Employee("mahi",12,1000);
        e.display();
        int sal=sc.nextInt();
        e.raiseSalary(sal);
        e.display();
    }
}
