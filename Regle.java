import java.util.List;
import java.util.stream.Collectors;

record Regle(String nom, List<Fait> antecedent, List<Fait> consequent)
{
    @Override 
    public String toString()
    {
        String result = nom + ": SI ";
        result += antecedent.stream().map(Fait::toString).collect(Collectors.joining(" ET "));
        result += " -> ";
        result += consequent.stream().map(Fait::toString).collect(Collectors.joining(" ET "));
        return result;
    }
}