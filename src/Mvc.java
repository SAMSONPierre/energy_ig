public class Mvc {
    public Mvc(){
        // Création du modèle
        Model model = new Model();
        // Création du contrôleur
        Controler controler = new Controler(model);
        // Création de la vue
        View view = new View(model, controler);
        controler.setView(view);
        // Affichage de la vue
        view.setVisible(true);
    }
    public static void main(String[] args){
        Mvc t = new Mvc();
    }
}
