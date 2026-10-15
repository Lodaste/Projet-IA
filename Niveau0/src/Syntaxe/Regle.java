package Syntaxe;

import java.util.List;
import java.util.stream.Collectors;


public record Regle(String nom, List<Fait> antecedent, List<Fait> consequent) {
    @Override
    public String toString() {
        return nom + ": SI "
            + antecedent.stream().map(Fait::toString).collect(Collectors.joining(" ET "))
            + " -> "
            + consequent.stream().map(Fait::toString).collect(Collectors.joining(" ET "));
    }
}