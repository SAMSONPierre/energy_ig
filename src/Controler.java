import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Controler implements ActionListener{
    Model model;		// Modèle contenant les données 
    View view;			// Vue des données
    Controler(Model model) { this.model = model; }
    void setView(View view) { this.view = view; }
    // Action sur reception d'un événement
    public void actionPerformed(ActionEvent event) {
	// Bouton émetteur de l'événement
	IncrButton button = (IncrButton) event.getSource();
	// Mise à jour des données
	model.incrValue(button.getIncr());
	// Force la vue à être conforme aux données
	view.update();
    }
}
