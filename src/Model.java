import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    private int value;		// Données du modèle
    Model(int value) { this.value = value; }
    Model() { this(0); }
    void incrValue(int incr) { value += incr; }
    int getValue() { return value; }

    /**
     * 
     * @param path
     * @return a new board created with the info within the file path
     * @throws IOException
     */
    public static Board readLevel(String path) throws IOException{
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        // Declaring a string variable
        String st;
        st = br.readLine();
        int height = Character.getNumericValue(st.charAt(0));
        int width = Character.getNumericValue(st.charAt(2));
        char type = st.charAt(4);
        Board res = new Board(height,width,type);
        int i=0;
        int j=0;
        
        while((st = br.readLine()) != null){
            Pattern pattern = Pattern.compile( "(\\.|W|S|L) ([0-9] )*", Pattern.DOTALL );      
            Matcher matcher = pattern.matcher( st );
            while ( matcher.find() ) {
                String tileValue = matcher.group(0);
                char tileType = tileValue.charAt(0);
                List<Integer> tileOutput = new ArrayList<Integer>();
                if(tileValue.length() > 1){
                    for(int i2 = 1;i2<tileValue.length();i2++){
                        if(tileValue.charAt(i2) != ' '){
                            tileOutput.add(Character.getNumericValue(tileValue.charAt(i2)));
                        }
                    }
                }
                res.getMap()[i][j] = new Tile(tileType, tileOutput);
                j++;
            }     
            i++;
            j=0;
        }
        
        return res;
        
    }
    
}
