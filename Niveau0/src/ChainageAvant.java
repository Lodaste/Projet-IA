import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Syntaxe.Fait;
import Syntaxe.Regle;

public class ChainageAvant 
{
    List<Regle> BR;

    Map<String, Boolean> BF = new HashMap<>();

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


    boolean inference = true;

    int nbrInf = 0;

    public void IDK()
    {
        while (inference)
        {
            inference = false;

            for (Regle regle : BR) 
            {
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
                    
                    BR.remove(regle); //retirer la règle déjà utilisée

                    inference = true;
                    
                    ++ nbrInf;
                }

            }
        }
    }
}

