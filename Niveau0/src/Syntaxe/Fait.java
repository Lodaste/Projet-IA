package Syntaxe;

public record Fait(String mot, boolean VraiOuFaux)
{
    @Override
    public String toString()
    {
        return VraiOuFaux ? mot : "NON " + mot;
    }

    public Fait(String mot)
    {
        this(mot, true);
    }
}