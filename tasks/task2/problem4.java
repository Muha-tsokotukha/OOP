import java.lang.Math;

public class problem4 {
    public static void main(String args[]){
        Position p1 = new Position(1, 4);
        Position p2 = new Position(3, 2);
        King k1 = new King("White");
        System.out.println(k1.isLegalMove(p1, p2));
        Queen q1 = new Queen("Black");
        System.out.println(q1.isLegalMove(p1, p2));
        Rook r1 = new Rook("White");
        System.out.println(r1.isLegalMove(p1, p2));
        Bishop b1 = new Bishop("Black");
        System.out.println(b1.isLegalMove(p1, p2));
        Knight n1 = new Knight("White");
        System.out.println(n1.isLegalMove(p1, p2));
        Pawn pn1 = new Pawn("White");
        System.out.println(pn1.isLegalMove(p1, p2));
    }
}

class Position {
    int x;
    int y;
    Position(int x,int y){
        this.x = x;
        this.y = y;
    }
}


abstract class Piece {
    public abstract boolean isLegalMove(Position a, Position b);    
}

class King extends Piece {
    String color;
    King(String s){
        this.color = s;
    }
    public boolean isLegalMove(Position a, Position b){
        if(  Math.max(a.x, b.x) - Math.min(a.x, b.x) == 0 && Math.max(a.y, b.y) - Math.min(a.y, b.y) == 0 )return false;
        if(  Math.max(a.x, b.x) - Math.min(a.x, b.x) > 1 )return false;
        if(  Math.max(a.y, b.y) - Math.min(a.y, b.y) > 1 )return false;
        return true;
    }
}

class Queen extends Piece {
    String color;
    Queen(String s){
        this.color = s;
    }
    public boolean isLegalMove(Position a, Position b){
        int q = a.x;
        int w = a.y;
        while( q > 0 ){
            if( q == b.x && w == b.y)return true;
            q--;
        }
        q = a.x;
        w = a.y;
        while( q < 9 ){
            if( q == b.x && w == b.y)return true;
            q++;
        }
        q = a.x;
        w = a.y;
        while( w < 9 ){
            if( q == b.x && w == b.y)return true;
            w++;
        }

        q = a.x;
        w = a.y;
        while( w > 0 ){
            if( q == b.x && w == b.y)return true;
            w--;
        }

        q = a.x;
        w = a.y;
        while( q > 0 && w > 0 ){
            if( q == b.x && w == b.y)return true;
            q--;w--;
        }
        q = a.x;
        w = a.y;
        while( q < 9 && w > 0 ){
            if( q == b.x && w == b.y)return true;
            q++;w--;
        }
        q = a.x;
        w = a.y;
        while( q > 0 && w < 9 ){
            if( q == b.x && w == b.y)return true;
            q--;w++;
        }
        q = a.x;
        w = a.y;
        while( q < 9 && w < 9 ){
            if( q == b.x && w == b.y)return true;
            q++;w++;
        }
        return false;
    }
}

class Rook extends Piece {
    String color; 
    Rook(String s ){
        this.color= s;
    }
    public boolean isLegalMove(Position a, Position b){
        int q = a.x;
        int w = a.y;
        while( q > 0 ){
            if( q == b.x && w == b.y)return true;
            q--;
        }
        q = a.x;
        w = a.y;
        while( q < 9 ){
            if( q == b.x && w == b.y)return true;
            q++;
        }
        q = a.x;
        w = a.y;
        while( w < 9 ){
            if( q == b.x && w == b.y)return true;
            w++;
        }

        q = a.x;
        w = a.y;
        while( w > 0 ){
            if( q == b.x && w == b.y)return true;
            w--;
        }
        return false;
    }
}

class Bishop extends Piece {
    String color ;
    Bishop(String s){
        this.color = s;
    }
    public boolean isLegalMove(Position a, Position b){
        int q = a.x;
        int w = a.y;
        while( q > 0 && w > 0 ){
            if( q == b.x && w == b.y)return true;
            q--;w--;
        }
        q = a.x;
        w = a.y;
        while( q < 9 && w > 0 ){
            if( q == b.x && w == b.y)return true;
            q++;w--;
        }
        q = a.x;
        w = a.y;
        while( q > 0 && w < 9 ){
            if( q == b.x && w == b.y)return true;
            q--;w++;
        }
        q = a.x;
        w = a.y;
        while( q < 9 && w < 9 ){
            if( q == b.x && w == b.y)return true;
            q++;w++;
        }
        return false;
    }
}

class Knight extends Piece {
    String color;
    Knight(String s){
        this.color = s;
    }
    public boolean isLegalMove(Position a, Position b){
        if( a.x + 2 == b.x  && a.y+1 == b.y  )return true;
        if( a.y + 2 == b.y  && a.x+1 == b.x  )return true;
        if( a.x + 2 == b.y  && a.y+1 == b.x  )return true;
        if( a.y + 2 == b.x  && a.x+1 == b.y  )return true;
        if( a.x - 2 == b.x  && a.y-1 == b.y  )return true;
        if( a.y - 2 == b.y  && a.x-1 == b.x  )return true;
        if( a.x - 2 == b.y  && a.y-1 == b.x  )return true;
        if( a.y - 2 == b.x  && a.x-1 == b.y  )return true;
        if( a.x + 2 == b.x  && a.y-1 == b.y  )return true;
        if( a.y + 2 == b.y  && a.x-1 == b.x  )return true;
        if( a.x + 2 == b.y  && a.y-1 == b.x  )return true;
        if( a.y + 2 == b.x  && a.x-1 == b.y  )return true;
        if( a.x - 2 == b.x  && a.y+1 == b.y  )return true;
        if( a.y - 2 == b.y  && a.x+1 == b.x  )return true;
        if( a.x - 2 == b.y  && a.y+1 == b.x  )return true;
        if( a.y - 2 == b.x  && a.x+1 == b.y  )return true;
        return false;
        
    }
}

class Pawn extends Piece {
    String color;
    Pawn(String s){
        this.color = s;
    }
    public boolean isLegalMove(Position a, Position b){
        if( (a.x == 2 && b.x == 4) && (a.x == 7 && b.x == 5)  )return true;
        if(  b.y != a.y  )return false;
        if(  Math.max(a.x , b.x) - Math.min(a.x, b.x) != 1    )return false;
        return true;
    }
}