import java.util.ArrayList;

import Syntaxe.Fait;
public class BaseFaits {
    ArrayList<Fait> faits;
    public BaseFaits(){
        faits= new ArrayList<>();
        faits.add(new Fait("il pleut",true));
    }
    
}