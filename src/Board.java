import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board{
    private int height;
    private int width;
    private Tile[][] map;
    private char type;
    public Board(){}
    public Board(int height, int width, char type){
        this.height = height;
        this.width = width;
        this.type = type;
        this.map = new Tile[height][width];
    }
    public String toString(){
        return "height : " + this.height + " width : " + this.width + " type : " + this.type; 
    }
    
    public Tile[][] getMap(){
        return this.map;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }
}

