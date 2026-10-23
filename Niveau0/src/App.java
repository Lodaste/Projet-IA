import java.util.List;
import java.util.Map;

import Syntaxe.BaseFaits;
import Syntaxe.Fait;
import Syntaxe.Regle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        //Test du moteur0
        Fait fait1 = new Fait("Il pleut", true);
        Fait fait2 = new Fait("Le ciel est gris", true);  
        Fait fait3 = new Fait("Il y a du vent", false);
        BaseFaits BF = new BaseFaits();
        BF.add(fait1);
        BF.add(fait2);
        BF.add(fait3);
    
        Regle regle1 = new Regle("R1", List.of(new Fait("Il pleut", true)), List.of(new Fait("Prendre un parapluie", true)));
        Regle regle2 = new Regle("R2", List.of(new Fait("Prendre un parapluie", true), 
            new Fait("Il y a du vent", true)), List.of(new Fait("Le parapluie se retournera", true)));
        Regle regle3 = new Regle("R3", List.of(new Fait("Le ciel est gris", true)), List.of(new Fait("Il va pleuvoir", true)));
        Regle regle4 = new Regle("R4", List.of(new Fait("Il pleut", true)), List.of(new Fait("Il pleut", false)));
        List<Regle> BR = new LinkedList<>();
        BR.add(regle1);
        BR.add(regle2);
        BR.add(regle3);
        //BR.add(regle4);
            System.out.println(regle1);
        System.out.println(regle2);

        
        MoteurZERO moteur = new MoteurZERO(BR, BF);

        System.out.println("---Fait initiaux--- \n  " + fait1.toString() + "\n  " + fait1.toString() + "\n  " + fait2.toString());
        System.out.println("---Liste des règles---");
        for (Regle regle : BR) {
            System.out.println("  " + regle.toString());
        }

        moteur.chainageAvant();

        
        //moteur.chainageArriere();
    } //Modif inutile
    
}
