package no.hvl.DAT109;

public class Stigespill {

    public Stigespill() {
        Brett brett = new Brett();
        Spiller s1 = new Spiller(1, "Sondre");
        Terning terning = new Terning();
        boolean vunnet = false;
        // private Spiller vunnet;

    }


    public void setup() {
        // antall spillere? sysout
//
        // oppretter spillere // for loop

        // starter brett

    }

    public void spill() {
    }

    public boolean spillRunde(Brett brett, Spiller spiller, Terning terning, Boolean vunnet) {
        String navn = spiller.getNavn();


        spiller.endrePos(terning.trillTerning());
        int spillerPos = spiller.getPosisjon();

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

        if (spillerPos >= 100) {
            vunnet = true;
        }
        return vunnet;
    }

    // public boolean harVunnet(Spiller a) {
    //pos = 100
}



}
