
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Syntaxe.BaseFaits;
import Syntaxe.Fait;
import Syntaxe.Regle;
public class MoteurZERO
{
    public MoteurZERO(List<Regle> BR, BaseFaits BF) 
    {
        this.BR = BR;
        this.BF = BF;
    }

    List<Regle> BR;
    BaseFaits BF;

    BaseFaits demandables; // Faire un type propre


    public boolean VF (Fait f) {return BF.VF(f.mot());}

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
                        if(BF.contains(fait.mot()) && (VF(fait) != VA(fait.mot(), regle)) || (!BF.contains(fait.mot()))) 
                            declenchable = false;   
                    }       
                }

                if (declenchable)
                {
                    for (Fait fait : regle.consequent())  //Ajout des conséquents dans la base de fait
                    {
                        BF.add(fait);
                    }
                    
                    iterator.remove(); //retirer la règle courante si déclenchée

                    inference = true;
                    
                    ++ nbrInf;
                }

            }
        }

        System.out.println(BF.toString());

    }

    public void chainageArriere(Fait but)
    {
        demandables = new BaseFaits(faitsDemandables());
        if(demo(but))
            System.out.println("Le fait " + but.toString() + " est bien déductible"); 
        else
            System.out.println("Le fait " + but.toString() + " n'a pas pu être déduis");  
    }

    private boolean demo(Fait but)
    {
        boolean dem = false;

        //*Premier cas évident
        dem = BF.belongs(but); // Si le but est dans la BF -> vrai sinon faux

        //*Deuxième cas : rechercher si b détectible à partir de BR UNION BF
        for (Regle regle : BR) //pour tout r qui appartient à la BR
        {
            if (regle.belongsInConsequent(but)) // et b qui appartient aux Conséquents de la règle courante
            {
                //TANT que dem = faux : dem <-VERIF
                if(!dem)
                {
                    dem = verif(regle.antecedent());
                }
            }
        }

        //*Troisième cas : sinon : voir si b est demandable */
        if(!dem && demandables.contains(but.mot())) //-Si le but est dans les demandables
        {
            dem = question(but);
        }


        if(dem)
            BF.add(but);
        
        return dem;
    }


    private boolean verif(List<Fait> B)
    {
        
        boolean verite = true;

        for (Fait fait : B) 
        {
            if (verite)
            {
                verite = demo(fait);
            }
                
        }
        return verite;
    }
    // À déclarer une seule fois dans la classe
private static final Scanner scanner = new Scanner(System.in);

private boolean question(Fait but)
{
    while (true)
    {
        System.out.print("Quelle valeur apportez-vous au fait " + but.toString() + " ? Vrai (1) ou Faux (0) ? ");

        if (!scanner.hasNextLine())
        {
            System.out.println("Erreur lors de la demande, la valeur du fait a été attribuée à Faux");
            return false;
        }

        String saisie = scanner.nextLine().trim();

        switch (saisie.toLowerCase())
        {
            case "1": case "vrai": case "true":
                return true;
            case "0": case "faux": case "false":
                return false;
            default:
                System.out.println("Saisie invalide, merci de répondre par 1 ou 0.");
        }
    }
}

    public ArrayList<Fait> faitsDemandables() 
    {
        ArrayList<Fait> demandables = new ArrayList<>();
        boolean estConsequence = false;
        ArrayList<Fait> antecedents = new ArrayList<>();

        for(Regle regle : BR)
        {
            for (Fait fait : regle.antecedent())
            {
                antecedents.add(fait);
            }
        }

        for (Fait fait : antecedents) 
        {
            for(Regle regle : BR) 
            {
                if(regle.belongsInConsequent(fait) || BF.belongs(fait)) 
                estConsequence = true;
            }
            if(!estConsequence) 
                demandables.add(fait);
            estConsequence = false;
        }


        System.out.println("test DEM");
        for(Fait fait : demandables)
        {
            System.out.println(fait.toString());
        }
         System.out.println("test DEM");

        return demandables;
    }


}
