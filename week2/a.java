public class a{
    public static void main(String args[]){
    int x = 5;
    int y = 4;
    Rectangle r1 = new Rectangle(x, y);
    r1.s();
    r1.p();
    }
}

abstract class Shape{
    void s(){}
    void p(){}
}

class Rectangle extends Shape{  
    int a,b;  
    Rectangle(int x, int y){
        this.a = x;
        this.b = y;
    }
    void s(){
        System.out.println(this.a*this.b);
    }
    void p(){
        System.out.println( this.a * 2 + this.b * 2);
    }
}
