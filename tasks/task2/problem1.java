import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class problem1 {
    public static void main(String args[]){
        Cat Boris = new Cat();
        // Boris.sound();
        Dog Sharik = new Dog();
        // Sharik.sound();

        Animal[] animals = new Animal[3];
        animals[0] = Boris;
        animals[1] = Sharik;
        animals[2] = new Cat("Orange");
        for(int i = 0; i < 3; i++){
            animals[i].sound();     // We can use same interface for different objects 
            animals[i].get_color();
        }
        System.out.println(Sharik.trainer_name);
    }
}

class Animal {
    String color;
    String trainer_name;
    Animal(String c) {
        this.color = c;
    }
    Animal() {
        this.color = "White";
    }
    
    public void sound(){
        System.out.println("Sound!");
    }
    public void get_color(){
        System.out.println(this.color);
    }
}

class Cat extends Animal {
    @Override
    public void sound(){
        System.out.println("Mew");
    }
    Cat(){
        this.color = "Black";
    }
    Cat(String c){
        super(c);  // refering to superclass(parent)
    }
}

class Dog extends Animal {
    @Override
    public void sound(){
        System.out.println("Ruff");
    }
    Dog(){
        this.color = "Yellow";
        super.trainer_name = "Mukhit";  // also to superclass(parent)
    }
    Dog(String c){
        super(c);
    }
}    
