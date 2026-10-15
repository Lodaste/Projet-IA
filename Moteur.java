import java.util.ArrayList;

public abstract class Moteur {
    ArrayList<Fait> BF;
    ArrayList<Regle> BR;
    ArrayList<Fait> demandables;
    Fait but;

    public boolean VF(Fait f){
        return BF.contains(f) ? f.VraiOuFaux() : false; // On renvoie la valeur du fait ou faux si pas dans la base
    }
    public boolean VA(Fait fait, Regle regle){
        return regle.antecedent().contains(fait) ? fait.VraiOuFaux() : false; // On renvoie la valeur du fait ou faux si pas antecedent
    }
    public boolean VC(Fait fait, Regle regle){
        return regle.consequent().contains(fait) ? fait.VraiOuFaux() : false; // On renvoie la valeur du fait ou faux si pas consequent
    }
}