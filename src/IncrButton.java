import javax.swing.JButton;

class IncrButton extends JButton {
    private int incr;		// Valeur de l'incrément
    IncrButton(String title, int incr) {
	// Constructeur avec titre
	super(title);
	// Initialisation de l'incrément
	this.incr = incr;
    }
    // Retourne la valeur d'incrément
    int getIncr() { return incr; }
}