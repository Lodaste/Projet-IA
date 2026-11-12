package Syntaxe;

import java.util.List;

public class BaseRegles 
{
    List<Regle> regles;

    @Override 
    public String toString()
    {
        String result ="---Règles---\n\n  ";

        for (Regle regle : regles) 
        {
            result += regle.toString()+"\n";
        }

        return result += "\n---Règles---\n";
    }
    
    
}
