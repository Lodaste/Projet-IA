package Syntaxe;

import java.util.ArrayList;
import java.util.List;

public class BaseFaits 
{
    List<Fait> faits;
    TypeBF type;

    public BaseFaits(List<Fait> faits, TypeBF type)
    {
        this.faits = faits;
        this.type = type;
    }

    public BaseFaits(TypeBF type)
    {
        faits = new ArrayList<>();
        this.type = type;
    }

    public void add(Fait fait)
    {
        faits.addLast(fait);
    }

    public boolean contains(String mot) //retourne Vrai si le mot est dans dans la base de fait
    {
        for (Fait fait : faits) {
            if(fait.mot().equals(mot))
                return true;
        }
        return false;
    }

    public boolean belongs(Fait but)
    {
        for (Fait fait : faits) 
        {
            if(fait.mot().equals(but.mot()) && fait.VraiOuFaux() == but.VraiOuFaux())
                return true;
        }
        return false;
    }

    public boolean VF (String mot)
    {
        for (Fait fait : faits) {
            if(fait.mot().equals(mot))
                return fait.VraiOuFaux();
        }
        return false;
    }

    @Override 
    public String toString()
    {
        String typeS ="";
        if (type == TypeBF.FAIT_INITIAUX) 
            typeS = "Fait initiaux";
        else if (type == TypeBF.DEMANDABLES)
            typeS = "Demandables";
        else
            typeS = "Erreur Type";
            
        
            

        String result = "---"+typeS+"---\n\n  ";
        for (Fait fait : faits) {
            result += fait.toString() + "\n  ";
        }
        return result += "\n---"+typeS+"---\n";
    }

    public List<Fait> getFaits()
    {
        return faits;
    }

}
