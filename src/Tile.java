import java.util.List;

public class Tile {
    private char type;
    private List<Integer> output;
    private boolean alight;

    public Tile(char type, List<Integer> output){
        this.type = type;
        this.output = output;
    }
    public String toString(){
        return " type : " + this.type + " output : " + output.toString() + " alight : " + this.alight; 
    }
}
