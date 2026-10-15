import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        //Test du moteur0
        Fait fait1 = new Fait("Il pleut", true);
        Fait fait2 = new Fait("Il fait chaud", false);
        Fait fait3 = new Fait("Il neige", true);    
        Fait fait4 = new Fait("Il y a du vent", false);
        Fait fait5 = new Fait("Il y a du soleil", true);
        Regle regle1 = new Regle("R1", List.of(fait1), List.of(fait2));
        Regle regle2 = new Regle("R2", List.of(fait2,fait3), List.of(fait4));
        System.out.println(regle1);
        System.out.println(regle2);

        MoteurZERO moteur = new MoteurZERO(fait5, new ArrayList<>(List.of(fait1, fait3)), new ArrayList<>(List.of(regle1, regle2)));
        moteur.chainageAvant();
        moteur.chainageArriere();
    }
}
