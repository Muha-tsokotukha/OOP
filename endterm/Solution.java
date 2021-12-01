import java.util.Scanner;
/* 
Enter your code here. 
Create all the necessary classes and methods as per the requirements. 
*/
// START of your code

class InvalidMapException extends Exception{
    public InvalidMapException(String message){
        super(message);
    }
}

class Position{
    private int x;
    private int y;
    Position(int a,int b){
        this.x = a;
        this.y = b;
    }
    public void setX(int a){
        this.x = a;
    }
    public void setY(int a){
        this.y = a;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean equals(Position p){
        return ( p.getX() == this.x && p.getY() == this.y  );
    }
    @Override
    public String toString() {
        return "("+this.x + "," + this.y+")";
    }
}


class Map{
    private char[][] map_map;
    private int size;

    public char[][] getMap_map() {
        return map_map;
    }

    Map(Scanner input) throws  InvalidMapException {
        this.size = input.nextInt();
        if( this.size == 0 )throw new InvalidMapException("Map size can not be zero");

        this.map_map = new char[this.size][this.size];

        for(int i=0; i < this.size; i++ ){
            for(int j =0; j < this.size; j++){
            this.map_map[i][j] = input.next().charAt(0);
            if((this.map_map[i][j] == 'P' ||this.map_map[i][j] == '0' ||this.map_map[i][j] == '1') == false)
                throw new InvalidMapException("Not enough map elements");
            }
        }
    }

    public int getSize(){
        return this.size;
    }
    public char getValueAt(int a,int b){
        return map_map[a][b];
    }
    public void print(){
        //
        for (char[] chars : map_map) {
            for (int j = 0; j < map_map.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}



interface Player {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
    public void setMap(Map m);
    public Position getPosition();
}

class MyPlayer implements Player {
    private Map myMap;
    private Position pos_player;
    @Override
    public void setMap(Map m){
        this.myMap = m;
    }
    @Override
    public void moveUp(){
        if( pos_player.getY() - 1 >=0 && myMap.getMap_map()[pos_player.getY() - 1][pos_player.getX()] != '1' ){
            myMap.getMap_map()[pos_player.getY() - 1][pos_player.getX()] = 'P';
            myMap.getMap_map()[pos_player.getY()][pos_player.getX()] = '0';
            pos_player.setY(pos_player.getY() - 1);
        }
    }
    @Override
    public void moveDown(){
        if( pos_player.getY() + 1 < myMap.getSize() && myMap.getMap_map()[pos_player.getY() + 1][pos_player.getX()] != '1' ){
            myMap.getMap_map()[pos_player.getY() + 1][pos_player.getX()] = 'P';
            myMap.getMap_map()[pos_player.getY()][pos_player.getX()] = '0';
            pos_player.setY(pos_player.getY() + 1);
        }
    }
    @Override
    public void moveRight(){
        if( pos_player.getX() + 1 < myMap.getSize() && myMap.getMap_map()[pos_player.getY() ][pos_player.getX()+1] != '1' ){
            myMap.getMap_map()[pos_player.getY() ][pos_player.getX()+1] = 'P';
            myMap.getMap_map()[pos_player.getY()][pos_player.getX()] = '0';
            pos_player.setX(pos_player.getX() + 1);
        }
    }
    @Override
    public void moveLeft(){
        if( pos_player.getX() - 1 >= 0 && myMap.getMap_map()[pos_player.getY() ][pos_player.getX()-1] != '1' ){
            myMap.getMap_map()[pos_player.getY() ][pos_player.getX()-1] = 'P';
            myMap.getMap_map()[pos_player.getY()][pos_player.getX()] = '0';
            pos_player.setX(pos_player.getX() - 1);

        }
    }
    @Override
    public Position getPosition(){
        for(int i = 0; i < myMap.getMap_map().length; i++){
            for(int j = 0; j < myMap.getMap_map().length; j++){
                if(myMap.getMap_map()[i][j] == 'P'){
                    pos_player = new Position(j, i);
                }
            }
        }
        return pos_player;
    }
}


class Game {
    private Map mm;
    private Player p1;
    Game(Map m){
        this.mm = m;
    }
    public void setMap(Map m){
        this.mm = m;
    }
    public void addPlayer(Player p){
        this.p1 = p;
        p1.setMap(this.mm);
        p1.getPosition();
    }
}


// END of your code.
/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points for implementing some classes completely and correctly, 
even if other classes are complete but still may not work properly.
*/
public class Solution{

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        
        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());
            
            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));            
        }
        
        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);		
                System.out.println(map.getValueAt(size/2, size/2)); 
            }
            catch(Exception e){}
        }
        
        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());  
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }
        
        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }
        
        // Checking the Game class and all of its components
        else if(className.equals("Game")){
            
            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
	}
}