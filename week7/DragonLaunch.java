import java.util.Stack;
import java.util.Vector;

public class DragonLaunch {
    public static void main(String args[]){
        System.out.println(willDragonEatOrNot());

    }
    static String kidnap(Person p){
        return p.g.name();
    }   
    static boolean willDragonEatOrNot(){
        Person p2 = new Person(Gender.BOY);
        Person p1 = new Person(Gender.BOY);
        Person p3 = new Person(Gender.GIRL);
        Person p4 = new Person(Gender.GIRL);
        Vector<String> kidnapped = new Vector<String>();
        Stack<String> st = new Stack<String>();
        kidnapped.add(kidnap(p2));
        kidnapped.add(kidnap(p1));
        kidnapped.add(kidnap(p3));
        kidnapped.add(kidnap(p4));
        for(int i =0; i < kidnapped.size(); i++){
            if(  kidnapped.get(i) == "GIRL"  ){
                if( st.empty() == false && st.firstElement()=="BOY"  ){
                    st.pop();
                }
                else st.push("GIRL");
            }
            else st.push( kidnapped.get(i) );
        }

        return st.empty();
    } 

}

enum Gender{
    GIRL,
    BOY
}

class Person{
    Gender g;
    Person(Gender s){
        g = s;
    }
    @Override
    public String toString() {
        return g.name();
    }
}

