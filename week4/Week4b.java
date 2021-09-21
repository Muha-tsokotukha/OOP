public class Week4b{
	public static void main(String[] args) {
		Student s1 = new Student();
        s1.name = "Almas";

        s1.add_class("Math");
        s1.add_class("Physics");
        s1.add_class("PE");
        s1.add_class("Art");
        s1.add_class("OOP");
        s1.add_class("Data Structures");
        // s1.add_class("asdfdsfs");  // full
        s1.attends();
        Student s2 = new Student();
        s2.add_class( "Math" );
        s2.name = "Sanzhar";
        University U1 = new University("KBTU");
        U1.passed_student(s1, "Math");
        U1.passed_student(s2, "Computer Science");
        U1.get_studs();
	}
}

class Student{
	public String name;
	public String id;
	private double gpa;
	String specialty;

    private boolean need_for_dormitory;
    private String[] classes   = new String[6];
    private int i = 0;
	Student(){}

    public void dorm(boolean needs){
        need_for_dormitory = needs;
    }

    public void add_class(String s){
        if(  i <  6 ) classes[i++] = s;
        else System.out.println("Full"); 
    }
    public void attends(){
        int j = 0;
        while(  j < i ){
            System.out.println(classes[j]);
            j++;
        }
    }

	public double getGPA(){return gpa;}
	public void setGPA(double g){gpa = g;}

    public boolean needs_dorm(){
        return need_for_dormitory;
    }
}

class University{
    private String name;
    private String[] department = new String[2];
    
    private Student[] studs = new Student[20];
    private int i = 0;
    University(String n){
        name = n;
        department[0] = "Math";
        department[1] = "Computer Science";
    }
    
    public void passed_student(Student s,  String dept  ){
        if( i < 20 && ( department[0] == dept || department[1] == dept   )  ){
            studs[i] = s;
            i++;
        }
    }

    public void get_studs(){
        int j = 0;
        while( j < i)
        System.out.println(studs[j++].name);
    }

    public String get_name(){
        return name;
    } 
    

}




/*
TASK-1: Add at least 2 more data fields with different access modifiers
TASK-2: Add at least 2 more methods with different access modifiers
TASK-3: Create a class University that includes Student as a data field (group of students, if possible)
*/