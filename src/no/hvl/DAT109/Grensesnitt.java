package no.hvl.DAT109;

public class Grensesnitt {
    private Stigespill stigespill;

    public Grensesnitt(Stigespill stigespill){
        this.stigespill = stigespill;
    }

    public void start(){

        // ett eller annet input for dialog mot bruker
        // hvor mange spiller?

        // for loop
        // legge til spillere

        stigespill.setup(); //(spillere)
        stigespill.spill();

    }

}
