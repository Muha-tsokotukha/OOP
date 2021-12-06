import java.util.Random;
import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays; 

public class gen {
    public static void main(String args[]){

        Vocabulary v = new Vocabulary(); // to read words from user input
        // sentences have toString method
        Random_sentence r1 = new Random_sentence(v); 
        System.out.println(r1);
        Sorted_sentence s2 = new Sorted_sentence(v);
        System.out.println(s2);
        Ordered_sentence o3 = new Ordered_sentence(v);
        System.out.println(o3);
    }

}



class Random_sentence{
    protected String sent;
    Random_sentence(){};
    Random_sentence(Vocabulary v){ 
        this.sent = "";
        int n = getRandomNumber(1, 4);
        while( n > 0 ){
            this.sent += (v.get_adj()).toLowerCase() + " "; // concatenates random words into 1 sentence
            n--; 
        }
        n = getRandomNumber(1, 3);
        this.sent += (v.get_noun()).toLowerCase() + " ";
        while( n > 0 ){
            this.sent += (v.get_verb()).toLowerCase() + " ";
            n--; 
        }
    }
    public String get_sentence(){
        return this.sent;
    }
    protected int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min); // used to determine size
    }
    @Override
    public String toString() {
        return this.sent;
    }
}

class Sorted_sentence extends Random_sentence{
    Sorted_sentence(Vocabulary v){
        super.sent = "";
        int size = getRandomNumber(3, 12);
        String[] temp = new String[size]; // used array to sort words, rest is more less same

        int n = getRandomNumber(1, size+1/2);
        int i = 0;
        while(i < n){
            temp[i] = v.get_adj();
            i++;
        }
        temp[i] = v.get_noun();
        
        i++;
        while(i < size){
            temp[i] = v.get_verb();
            i++;
        }
        Arrays.sort(temp);
        int j = 0;
        while( j < i ){
            super.sent += temp[j] + " ";
            j++;
        }
    }
}

class Ordered_sentence extends Random_sentence{

    Ordered_sentence(Vocabulary v){
        super.sent = "";
        int size = getRandomNumber(3, 12);
        String[] temp = new String[size]; // just to store words that have been morphed to uppercase and reversed

        int n = getRandomNumber(1, size+1/2);
        int i = 0;
        while(i < n){
            temp[i] = new StringBuilder(v.get_adj().toUpperCase()).reverse().toString();
            i++;
        }
        temp[i] = new StringBuilder(v.get_noun().toUpperCase()).reverse().toString();
        
        i++;
        while(i < size){
            temp[i] = new StringBuilder(v.get_verb().toUpperCase()).reverse().toString();
            i++;
        }
        int j = 0;
        while( j < i ){
            super.sent += temp[j] + " ";
            j++;
        }
    
    }
}

class Vocabulary{
    private  String[] noun = new String[100];
    private  String[] adj = new String[100];
    private  String[] verb = new String[100];
    int noun_size = 0;
    int adj_size = 0;
    int verb_size = 0;
    Vocabulary(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Amount of new words");
        int n = sc.nextInt();
        System.out.println("1 - noun\n2 - verb\n3 - adjective");
        this.noun_size = 0;
        this.adj_size = 0;
        this.verb_size = 0;
        
        for(int i =0; i < n; i++){
            int anv = sc.nextInt();
            String word = sc.next();
            if( anv == 1 && noun_size < 100 ){
                noun[noun_size] = word;
                noun_size++;
            }
            if( anv == 2 && verb_size < 100 ){
                verb[verb_size] = word;
                verb_size++;
            }
            if( anv == 3 && adj_size < 100 ){
                adj[adj_size] = word;
                adj_size++;
            }
        }
        sc.close();
    }
    public  String get_noun(){
        return noun[((int) ((Math.random() * (this.noun_size - 0)) + 0))];
    }
    
    public  String get_adj(){
        return adj[((int) ((Math.random() * (this.adj_size - 0)) + 0))];
    }
    public  String get_verb(){
        return verb[((int) ((Math.random() * (this.verb_size - 0)) + 0))];
    }
    
}