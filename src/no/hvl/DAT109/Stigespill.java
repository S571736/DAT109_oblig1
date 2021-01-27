package no.hvl.DAT109;

import java.util.ArrayList;

public class Stigespill {

    public ArrayList<Spiller> spillere;
    private Spiller vunnet;
    private Brett brett;
    private Terning terning;

    public Stigespill() {
        this.brett = new Brett();
        this.spillere = new ArrayList<Spiller>();
        this.terning = new Terning();
        this.vunnet = null;

    }


    public void setup(ArrayList<Spiller> spillere) {
        this.spillere = spillere;
    }

    public void spill() {
        while (vunnet == null) {
            spillRunde();
        }
    }

    public void spillRunde() {

        for (Spiller spiller : spillere) {
            String navn = spiller.getNavn();
            int spillerPos = spiller.getPosisjon();
            int trillet = terning.trillTerning();

            if (!(spillerPos + trillet > 100)) {

                spiller.endrePos(trillet);

                if (spillerPos == 100) {
                    this.vunnet = spiller;
                    System.out.println(navn + " vinner spillet!");

                } else {

                    int endring = brett.getRuteVerdi(spiller.getPosisjon());

                    if (endring < 0) {
                        System.out.println(spiller.getNavn() + " møtte på en slange, du rykker tilbake til " + brett.getNyPos(spillerPos));
                        spiller.endrePos(brett.getNyPos(spillerPos));
                    } else if (endring > 0) {
                        System.out.println(navn + " møtte på en stige, du går fram til " + brett.getNyPos(spillerPos));
                        spiller.endrePos(brett.getNyPos(spillerPos));
                    } else {
                        System.out.println(navn + "Du landet trygt på " + spillerPos);
                    }
                }

            } else {
                System.out.println(navn + " havnet utenfor brettet, og blir dermed stående");
            }
        }
    }


}
