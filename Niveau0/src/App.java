import java.util.List;

import Syntaxe.BaseFaits;
import Syntaxe.Fait;
import Syntaxe.Regle;

import java.util.LinkedList;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("\n\n---Chainage avant---\n\n");
        TestAvant0();
        System.out.println("\n\n---Chainage avant---\n\n");
        
        System.out.println("\n\n---Chainage arrière---\n\n");
        TestArriere0();
        System.out.println("\n\n---Chainage arrière---\n\n");
    } 
    
    static void TestAvant0()
    {
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


        MoteurZERO moteur = new MoteurZERO(BR, BF);

        System.out.println("---Fait initiaux--- \n  " + fait1.toString() + "\n  " + fait2.toString() + "\n  " + fait3.toString());
        System.out.println("---Liste des règles---");
        for (Regle regle : BR) {
            System.out.println("  " + regle.toString());
        }

        moteur.chainageAvant();
    }
    
    static void TestArriere0()
    {
        BaseFaits BF2 = new BaseFaits();
        
        //Fait faitCielGris = new Fait("Le ciel est gris");
        Fait faitCielBleu = new Fait("Le ciel est bleu", false);
        Fait faitSolMouille = new Fait("Le sol est mouillé");

        //BF2.add(faitCielGris);
        BF2.add(faitCielBleu);
        //BF2.add(faitSolMouille);


        List<Regle> BR2 = new LinkedList<>();
        
        // Regle regle1 = new Regle("R1", List.of(new Fait("Le ciel est gris")), List.of(new Fait("Temps pluvieux")));
        Regle regle1 = new Regle("R1", List.of(new Fait("Le ciel est bleu", false)), List.of(new Fait("Temps pluvieux")));
        // Regle regle2 = new Regle("R2", List.of(new Fait("Temps pluvieux"), new Fait("Il a plut hier")), List.of(new Fait("Il pleut")));
        Regle regle2 = new Regle("R2", List.of(new Fait("Temps pluvieux"), new Fait("Il a plut hier")), List.of(new Fait("Il fait sec", false)));
        Regle regle3 = new Regle("R3", List.of(new Fait("Le sol est mouillé")), List.of(new Fait("Il a plut hier")));
        
        BR2.add(regle1);
        BR2.add(regle2);
        BR2.add(regle3);
        MoteurZERO moteur2 = new MoteurZERO(BR2, BF2);

        Fait but = new Fait("Il fait sec", false);

        System.out.println("---Fait initiaux--- \n  " + faitCielBleu.toString() + "\n  " + faitSolMouille.toString());
        System.out.println("---Liste des règles---");
        System.out.println("  --> On veut prouver : " + but.toString());
        for (Regle regle : BR2) {
            System.out.println("  " + regle.toString());
        }
        //moteur2.chainageArriere(new Fait("Il pleut"));
        moteur2.chainageArriere(but);
    }
}
