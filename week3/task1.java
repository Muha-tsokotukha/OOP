public class task1{
    public static void main(String args[]){
        Student s1 = new Student("Mukhit", "IT", 3.71f );
        Student s2 = new Student("Rauan", "MKM", 3.5f );
        Student s3 = new Student("Nasir", "FEOGI", 2.9f );
        s1.ShowInfo();
        s2.ShowInfo();
        s3.ShowInfo();
        s1.updateGPA(4.0f);
        s1.ShowInfo();
        System.out.println(Student.ShowUniversity());
        System.out.println(Student.ShowNumberOfStudents());
    }
}

class Student{
    private static String university = "KBTU";
    private static int cnt_studs = 0;
    
    private long id;
    private String name;
    private String faculty;
    private float gpa;
    
    Student(String s, String f, float x){
        cnt_studs++;
        this.gpa = x;
        this.name = s;
        this.faculty = f;
        this.id = generateId();
    }

    private int generateId(){
        int x = 100*cnt_studs + cnt_studs*2-1;
        return x;
    }  

    public static int ShowNumberOfStudents(){
        return cnt_studs;
    }

    public static String ShowUniversity(){
        return university;
    }

    public void ShowInfo(){
        System.out.println(this.name);
        System.out.println(this.faculty);
        System.out.println(this.id);
        System.out.println(this.gpa);
    }
    public void updateGPA(float x){
        this.gpa = x;
    } 

}