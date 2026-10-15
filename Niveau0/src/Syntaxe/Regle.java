package Syntaxe;

import java.util.List;
import java.util.stream.Collectors;


public record Regle(String nom, List<Element> antecedent, List<Element> consequent) {
    @Override
    public String toString() {
        return nom + ": SI "
            + antecedent.stream().map(Element::toString).collect(Collectors.joining(" ET "))
            + " -> "
            + consequent.stream().map(Element::toString).collect(Collectors.joining(" ET "));
    }
}