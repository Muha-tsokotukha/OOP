public class Week5b{
	public static void task2(Student[] a,Student[] b){ // task2
		int cnt = 0;
		for(int i = 0; i < 3; i++){
			for(int j =0; j < 3; j++){
				if(a[i].getName() == b[j].getName())cnt++;
			}
			//System.out.println(b[i].getName());
		}
		System.out.println(cnt);
	}
	public static void main(String[] args) {
		Student[] group1 = new Student[3]; // task1
		Student[] group2 = new Student[3];
		Student s1 = new Student("Mukhit");
		Student s2 = new Student("Nassyr");
		Student s3 = new Student("Zhandos");
		Student s4 = new Student("Indira");
		Student s5 = new Student("Zhaisan");
		Student s6 = new Student("Zhandos");
		group1[0] = s1;
		group1[1] = s2;
		group1[2] = s3;
		group2[0] = s4;
		group2[1] = s5;
		group2[2] = s6;
		task2(group1, group2);
	}
}
class Course{
	private String name;
	private int credits;
	Course(String s, int i){
		this.credits=i;
		this.name = s;
	}
	int getCredits(){
		return this.credits;
	}
	String getTitle(){
		return this.name;
	}
}
class Faculty{  // task4 partially
	private String name;
	private Student[] studs;
	private int size;
	Faculty(String s, int i, Student[] ss){
		this.size = i;
		this.name = s;
		this.studs = ss;
	}
	String getFac(){
		return this.name;
	}
	int getStudentsCount(){
		return this.size;
	}
	void getStudents(){
		for(int i=0; i < this.size; i++) System.out.println(studs[i].getName());
	}
}
final class Student{ //task3
	private String name;
	public String id;
	private double gpa = 4;
	String specialty;
	private static int x;

	Student(String n){
		this.name = n;
	}

	public double getGPA(){return gpa;}
	public void setGPA(double gpa){
		this.gpa = gpa;	// gpa = 2;
	}

	// static void changeNumber(int s){ // a = x = 5
	// 	s = 10;
	// 	Student.x = 10;
	// }

	// static void changeName(Student s){ // s = s1
	// 	s.name = "Almas";
	// }

	public String getName(){
		return this.name;
	}

	public void printStudent(){
		System.out.println("Student: " + name);
		double gpa = 1;
		System.out.println(gpa);
	}
}
/*
TASK-1: Create two groups of students (2 arrays), and initialize them;
TASK-2: Create a static method that compares two student arrays, 
		and returns how many students from 2 have the same name;
TASK-3: Modify the Student to make it an immutable class;
TASK-4: Create the Classes Course and Faculty, 
		and demonstrate their relationships to the Student class like in the lecture slides.
*/