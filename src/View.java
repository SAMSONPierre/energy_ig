import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class View extends JFrame{
    final int width  = 500;	// Largeur de la fenêtre
    final int height = 500;	// Hauteur de la fenêtre
    Model model;		// Modèle contenant les données
    // extract images 

    
    View(Model model, Controler controler) {
        // Constructeur avec titre
        super("energy");
        // Initialisation du modèle
        this.model = model;
        // Dimension de la fenêtre
        setSize(width, height);
        // Action à faire lorsque la fenêtre est fermée.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(menu());
        
       
    }

    JPanel menu(){
        // Création des deux Boutons écoutés par le contrôleur
        JButton playButton = new JButton("play");
        JButton exitButton = new JButton("exit");

        playButton.addActionListener((event) -> {
            try {
                this.setContentPane(level());
                getContentPane().revalidate();
                getContentPane().repaint();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Mise en place des éléments dans un panneau
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout());
        mainPanel.add(playButton);
        mainPanel.add(exitButton);
        return mainPanel;
    }

    JPanel level() throws IOException{
        JPanel levelPanel = new JPanel();
        Board level = Model.readLevel("./levels/level1.nrg");
        int height = level.getHeight();
        int width = level.getWidth();
        levelPanel.setLayout(new GridLayout(height,width));
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                Tile t = level.getMap()[i][j];
                CustomJButton jb = new CustomJButton(i,j,t);
                jb.addActionListener((event)->{
                    System.out.println(t.toString());
                });
                levelPanel.add(jb);
            }
        }

        return levelPanel;
    }
    // Mise à jour de l'affichage à partir des données du modèle
    void update() {
	    
    }

    public class CustomJButton extends JButton{
		private int posx;
		private int posy;
        private Tile t;
		
		public CustomJButton(int x,int y,Tile t) {
			this.posx = x;
			this.posy = y;
            this.t = t;
			
			
		}
		
		public int getPosX() {
			return posx;
		}
		public int getPosY() {
			return posy;
		}

        @Override
		protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	    }
    }
	
}