package no.hvl.DAT109;

import java.util.ArrayList;

public class Grensesnitt {
    private Stigespill stigespill;
    private ArrayList<Spiller> spillere;

    public Grensesnitt(Stigespill stigespill){
        this.stigespill = stigespill;
    }

    public void start(){

        // ett eller annet input for dialog mot bruker
        // hvor mange spiller?

        // for loop
        Spiller s1 = new Spiller(1, "Sondre");
        spillere.add(s1);
        // legge til spillere


        stigespill.setup(spillere); //legger spillere inn i stigespillet
        stigespill.spill();

    }

}
