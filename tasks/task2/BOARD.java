import java.lang.Math;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;


public class BOARD {
    public static void main(String args[]){
        Piece[][] board = new Piece[8][8];
        board[0][0] = new Rook("wR");
        board[0][1] = new Knight("wN");
        board[0][2] = new Bishop("wB");
        board[0][3] = new Queen("wQ");
        board[0][4] = new King("wK");
        board[0][5] = new Bishop("wB");
        board[0][6] = new Knight("wN");
        board[0][7] = new Rook("wR");
        for(int i = 0; i < 8; i++)board[1][i] = new Pawn("w");

        board[7][0] = new Rook("bR");
        board[7][1] = new Knight("bN");
        board[7][2] = new Bishop("bB");
        board[7][3] = new Queen("bQ");
        board[7][4] = new King("bK");
        board[7][5] = new Bishop("bB");
        board[7][6] = new Knight("bN");
        board[7][7] = new Rook("bR");
        for(int i = 0; i < 8; i++)board[6][i] = new Pawn("b");
        Scanner scn = new Scanner(System.in);
        while(true){

            Position p1 = new Position(scn.nextInt(), scn.nextInt());
            Position p2 = new Position(scn.nextInt(), scn.nextInt());
            if(  board[p1.x][p1.y].isLegalMove(p1, p2)   ){
                board[p2.x][p2.y] = board[p1.x][p1.y];
                board[p1.x][p1.y] = null;
            }
            for(int i =0; i < 8; i++){
                for(int j =0; j < 8;j++){
                    if(board[i][j] != null)
                    System.out.print(board[i][j]);
                    else System.out.print("*");
                    System.out.print(" ");
                }
                System.out.print('\n');
            }
            
        }
        
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
    @Override
    public String toString() {
        return color;
    }
}

class Queen extends Piece {
    @Override
    public String toString() {
        return color;
    }
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
    @Override
    public String toString() {
        return color;
    }
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
    @Override
    public String toString() {
        return color;
    }
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
    @Override
    public String toString() {
        return color;
    }
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
    @Override
    public String toString() {
        return color;
    }
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