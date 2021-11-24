import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

public class problem2 {
    static public void main(String args[]){
        Cylinder c1 = new Cylinder(5,5);
        System.out.println(c1.volume());

        Sphere s1 = new Sphere(5);
        System.out.println(s1.volume());
        
        Cube k1 = new Cube(5);
        System.out.println(k1.volume());
        
        double[] v = c1.get_sides();
        for(int i =0; i < v.length; i++){
            System.out.println(v[i]);
        }

    }     
}

abstract class solid_shape { 
    public abstract double volume(); // we have to to implement this methods in child classes 
    public abstract double surface_area(); // and return type, everything must be same
    public abstract double[] get_sides();
}


class Cube extends solid_shape {
    protected double side;
    Cube(){
        this.side = 0;
    }
    Cube(double x){
        this.side = x;
    }
    public double volume(){
        return this.side*this.side*this.side;
    }
    public double surface_area(){
        return 6*this.side*this.side;
    }

    public double[] get_sides(){
        double[] v = {this.side};
        return v;
    }

}


class Sphere extends solid_shape {
    protected double r;
    Sphere(double r){
        this.r = r;
    }
    Sphere(){
        this.r = 0;
    }
    
    public double volume(){
        return 3.14*1.333*this.r*this.r*this.r; 
    }

    public double surface_area(){
        return 4*3.14*this.r*this.r;
    }

    public double[] get_sides(){
        double[] v = {this.r};
        return v;
    }
}



class Cylinder extends solid_shape {
    protected double r;
    protected double h; 
    Cylinder(double r, double h){
        this.r = r;
        this.h = h;
    }
    Cylinder(){
        this.r = 0;
        this.h = 0;
    }

    public double volume(){
        return 3.14*this.r*this.r*h;
    } 
    public double surface_area(){
        return 6.28*this.r*(this.h+this.r);
    }
    public double[] get_sides(){
        double[] v = {this.r, this.h};
        return v;
    }
}