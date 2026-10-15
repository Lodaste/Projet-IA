import java.util.ArrayList;
public class MoteurZERO extends Moteur{ 
    int nbInf = 0;
    boolean infAFaire = true;
    public MoteurZERO(Fait valBut, ArrayList<Fait> initBF, ArrayList<Regle> initBR){
        but = valBut;
        BF = initBF;
        BR = initBR;
    }

    public void chainageAvant(){
        if(BF.contains(but)){
            System.out.println("Le but est dans la base de faits initiale");
        }
        while(infAFaire){
            infAFaire = false;
            for(Regle r : BR){
                for(Fait faitAnt : r.antecedent()){
                    if(VA(faitAnt,r) && VF(faitAnt)){ //verifie si le fait est dans la base de faits et si il est un antecedent 
                        for(Fait faitCon : r.consequent()){
                            if(!BF.contains(faitCon)){ //Au plus une fois 
                                BF.add(faitCon);
                                infAFaire = true;
                                ++nbInf;
                            }
                        }
                    }
                }
            }
            if(BF.contains(but)){
                System.out.println("Le but est validé");
                infAFaire = false;
            }
        }
        if(!BF.contains(but)){
            System.out.println("Le but n'est pas validé");
        }
        infAFaire = true; // pour relancer avec un autre chainage
    }

    public void chainageArriere(){
        if(BF.contains(but)){
            System.out.println("But validé");
        }
        else{
            //parcourt les règles pour trouver un consequent(une partie au moins) qui correspond au but actuel
            for(Regle r : BR){
                for(Fait faitCon : r.consequent()){
                    if(faitCon.equals(but)){
                        //pour appliquer la regle faut trouver les antecedents (arbre du TD)
                        for(Fait faitAnt : r.antecedent()){
                            if(!BF.contains(faitAnt)){
                                but = faitAnt;//l'antecedent manquant devient le nouveau "sous but"
                                chainageArriere();//appel recursif avec sous but
                            }
                        }
                    }
                }
            }
        }
    }


}
