import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Syntaxe.Fait;
import Syntaxe.Regle;
public class MoteurZERO
{
    public MoteurZERO(List<Regle> BR, Map<String, Boolean> BF) 
    {
        this.BR = BR;
        this.BF = BF;
    }
    List<Regle> BR;
    Map<String, Boolean> BF;

    public boolean VF (Fait f) {return BF.get(f.mot());}

    public boolean VA (String mot, Regle r)
    {
        for (Fait f : r.antecedent()) //Chercher le mot dans les antécédants de la règle
        {
            if (f.mot().equals(mot)) 
                return f.VraiOuFaux(); //Retourner sa valeur
        }
        throw new IllegalArgumentException("Mot absent : " + mot); //Si aucun mot n'est trouvé ce n'est pas normal
    }

    public boolean VC (String mot, Regle r)
    {
        for (Fait f : r.consequent()) //Chercher le mot dans les conséquents de la règle
        {
            if (f.mot().equals(mot)) 
                return f.VraiOuFaux(); //Retourner sa valeur
        }
        throw new IllegalArgumentException("Mot absent : " + mot); //Si aucun mot n'est trouvé ce n'est pas normal
    }

    boolean inference;
    int nbrInf;

    public void chainageAvant()
    {
        inference = true;
        nbrInf = 0;
        Regle regle;
        while (inference)
        {
            inference = false;
            Iterator<Regle> iterator = BR.iterator(); //Utilisation Iterator car possible suppression d'une règle de la BR plus tard

            while (iterator.hasNext()) 
            {
                regle = iterator.next();
                boolean declenchable = true; //règle déclenchable ?

                for (Fait fait : regle.antecedent()) 
                {
                    if (declenchable) 
                    {
                        if(BF.containsKey(fait.mot()) && (VF(fait) != VA(fait.mot(), regle)) || (!BF.containsKey(fait.mot())))
                            declenchable = false;   
                    }       
                }

                if (declenchable)
                {
                    for (Fait fait : regle.consequent())  //Ajout des conséquents dans la base de fait
                    {
                        BF.put(fait.mot(), fait.VraiOuFaux());
                    }
                    
                    iterator.remove(); //retirer la règle courante si déclenchée

                    inference = true;
                    
                    ++ nbrInf;
                }

            }
        }

        for (Map.Entry<String, Boolean> entry : BF.entrySet()) {
        System.out.println("Clé : " + entry.getKey() + " | Valeur : " + entry.getValue());
        }

    }
}
