import java.util.List;

import Syntaxe.BaseFaits;
import Syntaxe.Fait;
import Syntaxe.Regle;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* 
        //Test du moteur0
        Fait fait1 = new Fait("Il pleut", true);
        Fait fait2 = new Fait("Le ciel est gris", true);  
        Fait fait3 = new Fait("Il y a du vent", false);
        BaseFaits BF = new BaseFaits();
        BF.add(fait1);
        BF.add(fait2);
        BF.add(fait3);
    
        Regle regle1 = new Regle("R1", List.of(new Fait("Il pleut")), List.of(new Fait("Prendre un parapluie")));
        Regle regle2 = new Regle("R2", List.of(new Fait("Prendre un parapluie"), 
            new Fait("Il y a du vent", true)), List.of(new Fait("Le parapluie se retournera")));
        Regle regle3 = new Regle("R3", List.of(new Fait("Le ciel est gris")), List.of(new Fait("Il va pleuvoir")));
        Regle regle4 = new Regle("R4", List.of(new Fait("Il pleut")), List.of(new Fait("Il pleut", false)));
        List<Regle> BR = new LinkedList<>();
        BR.add(regle1);
        BR.add(regle2);
        BR.add(regle3);
        BR.add(regle4);
            System.out.println(regle1);
        System.out.println(regle2);

        
        MoteurZERO moteur = new MoteurZERO(BR, BF);

        System.out.println("---Fait initiaux--- \n  " + fait1.toString() + "\n  " + fait1.toString() + "\n  " + fait2.toString());
        System.out.println("---Liste des règles---");
        for (Regle regle : BR) {
            System.out.println("  " + regle.toString());
        }

        moteur.chainageAvant();
        */
        //-----------------------

        BaseFaits BF2 = new BaseFaits();
        BF2.add(new Fait("Le ciel est gris"));

        List<Regle> BR2 = new LinkedList<>();
        
        BR2.add(new Regle("R1", List.of(new Fait("Le ciel est gris")), List.of(new Fait("Temps pluvieux"))));
        BR2.add(new Regle("R2", List.of(new Fait("Temps pluvieux"), new Fait("Il a plut hier")), List.of(new Fait("Il pleut"))));
        BR2.add(new Regle("R3", List.of(new Fait("Le sol est mouillé")), List.of(new Fait("Il a plut hier"))));

        MoteurZERO moteur2 = new MoteurZERO(BR2, BF2);
        moteur2.chainageArriere(new Fait("Il pleut"));




    } //Modif inutile
    
}
