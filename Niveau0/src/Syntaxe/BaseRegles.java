package Syntaxe;

import java.util.List;

public class BaseRegles 
{
    List<Regle> regles;

    public BaseRegles (List<Regle> regles)
    {
        this.regles = regles;
    }

    @Override 
    public String toString()
    {
        String result ="--Règles--\n\n";

        for (Regle regle : regles) 
        {
            result += regle.toString()+"\n";
        }

        return result += "\n--Règles--\n";
    }
    
    public List<Regle> getRegles()
    {
        return regles;
    }
}
