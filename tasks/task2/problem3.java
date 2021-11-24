import java.util.Vector;

public class problem3 {
    public static void main(String args[]){
        Person p1 = new Person("Nassyr");
        Person p2 = new Person("Nassyr");
        System.out.println(p1.equals(p2)); 
        
        Employee e1 = new Employee("Mukhit",100000,2020, "20bd");
        Employee e2 = new Employee("Kenes",100000,2020, "20bd");
        System.out.println(e1.equals(e2)); // true
        System.out.println(e1);

        Manager m1 = new Manager(e1);
        System.out.println(m1);
        m1.addEmployee(e2);
        m1.employeesUnder();
    }
}


class Person{
    String name;
    double hCode;
    Person(String name ){
        this.name = name;
        this.hCode = 0;
        int i = 0;
        while(i < name.length()){
            this.hCode += (int)name.charAt(i)*i;
            i++;
        }
    }
    Person(){
        this.name = "";
    }
    public String toString(){
        return name;
    }
    public boolean equals(Person a){
        return a.hCode == this.hCode;
    }
}

class Employee extends Person {
    protected double salary;
    protected int year;
    protected String insuranceNumber;

    Employee(){
        super();
    }
    Employee(String s, double sal, int y, String ins){
        super(s);
        this.salary = sal;
        this.year = y;
        this.insuranceNumber = ins;
    }
    public String getName(){
        return name;
    }
    protected String getInsuranceNumber(){
        return this.insuranceNumber;
    }
    public int getYear(){
        return this.year;
    }
    @Override
    public String toString() {
        return name+" "+String.valueOf(this.year);
    }
    public boolean equals(Employee a){
        return  ( this.salary == a.salary && a.hCode == super.hCode);
    }
}

class Manager extends Employee {
    boolean bonus;
    Employee man ;
    Vector<Employee> v = new Vector<Employee>();
    
    public void addEmployee(Employee e){
        v.add(e);
    }
    public void employeesUnder(){
        for(int i =0; i < v.size(); i++)System.out.println(v.elementAt(i));
        if( v.size() == 0  )System.out.println("No employees");    
    }
    Manager(){
        super();
    }
    Manager(Employee e){
        this.man = e;
        this.bonus = false;
    }
    @Override
    public String toString() {
        return man.name + ", has bonus: "+ String.valueOf(bonus);    
    }
    public boolean equals(Manager m) {
        return (m.bonus == this.bonus && m.salary == salary && m.hCode == hCode);
    }
}