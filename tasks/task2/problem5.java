import java.util.Vector;
import java.util.Scanner;

public class problem5 {
    public static void main(String args[]){
        
        Vector<Person> people = new Vector<Person>();
        int x;
        Scanner myObj = new Scanner(System.in);
        while(true){
            x = myObj.nextInt();
            if( x== 1 ){
                for(int i = 0; i < people.size();i++)System.out.println(people.elementAt(i));
            }
            else if(x == 2){
                x = myObj.nextInt();
                if( x == 1)
                    people.add(new Person(myObj.nextLine(),myObj.nextLine() ));
                else if(x == 2)
                    people.add(new Student(myObj.nextLine(),myObj.nextLine(),myObj.nextLine(), myObj.nextInt(),myObj.nextDouble()  ));
                else people.add(new Staff(myObj.nextLine(),myObj.nextLine(),myObj.nextLine(), myObj.nextDouble()  ));
            }
            if(x == 0)break;
        }
        myObj.close();
    } 
}

class Person {
    protected String name;
    protected String address;
    Person(String name, String address){
        this.name = name;
        this.address = address;
    }
    Person(){}

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address ){
        this.address = address;
    }
    @Override
    public String toString() {
        return name + " " + address;
    }
}

class Student extends Person {
    protected String program;
    protected int year;
    protected double fee;

    Student(String name, String address, String program, int year, double fee ){
        super.name = name;
        super.address = address;
        this.program = program;
        this.year = year;
        this.fee = fee;
    }
    public String getProgram(){
        return this.program;
    }
    public void setProgram(String program){
        this.program = program;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public double getFee(){
        return this.fee;
    }
    public void setFee(double fee){
        this.fee = fee;
    }

    @Override
    public String toString() {
        return super.name + " " + super.address + '\n' + this.program + " " + String.valueOf(year) + " " + String.valueOf(fee);
    }
}

class Staff extends Person {
    protected String school;
    protected double pay;
    Staff(String name, String address, String school, double pay){
        super.name = name;
        super.address = address;
        this.school = school;
        this.pay = pay;
    }
    public String getSchool(){
        return school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public double getPay(){
        return this.pay;
    }
    public void setPay(double pay){
        this.pay = pay;
    }
    @Override
    public String toString() {
        return super.name + " " + super.address + '\n' + this.school + " " + String.valueOf(pay);
    }
}