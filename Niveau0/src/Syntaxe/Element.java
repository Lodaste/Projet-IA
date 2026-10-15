package Syntaxe;

public record Element(String mot, boolean VraiOuFaux)
{
    @Override
    public String toString()
    {
        return VraiOuFaux ? mot : "NON " + VraiOuFaux;
    }
}