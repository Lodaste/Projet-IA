package Syntaxe;

import java.util.ArrayList;
import java.util.List;

public class BaseFaits 
{
    List<Fait> faits;

    public BaseFaits(List<Fait> faits)
    {
        this.faits = faits;
    }

    public BaseFaits()
    {
        faits = new ArrayList<>();
    }

    public void add(Fait fait)
    {
        faits.addLast(fait);
    }

    public boolean contains(String mot)
    {
        for (Fait fait : faits) {
            if(fait.mot().equals(mot))
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
        String result = "---Base de faits---\n\n  ";
        for (Fait fait : faits) {
            result += fait.toString() + "\n  ";
        }
        return result += "\n---Base de faits---\n";
    }

}
