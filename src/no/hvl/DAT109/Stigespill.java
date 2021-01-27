package no.hvl.DAT109;

import java.io.IOException;
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
        System.out.println("Starter spill");


        while (vunnet == null) {
            spillRunde();
        }
    }


    public void spillRunde() {

        for (Spiller spiller : spillere) {
            System.out.println(spiller.getNavn() + " står i " + spiller.getPosisjon() + ", trykk enter for å trille");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String navn = spiller.getNavn();
            int spillerPos = spiller.getPosisjon();
            int trillet = terning.trillTerning();

            // Logikk for å trille 6, 3 ganger
            if (trillet == 6) {
                spiller.endrePos(6);
                trillet = terning.trillTerning();
                System.out.println(navn + " trillet " + trillet);
                if (trillet == 6) {
                    spiller.endrePos(6);
                    trillet = terning.trillTerning();
                    System.out.println(navn + " trillet " + trillet);
                    if (trillet == 6) {
                        spiller.setPos(0);
                        System.out.println("spiller " + navn + " trillet 6 ganger og rykker tilbake til 0");
                        break;
                    }
                }
            }

            System.out.println(navn + " trillet " + trillet);


            spillerPos = spiller.getPosisjon();

            if (!(spillerPos + trillet > 100)) {

                spiller.endrePos(trillet);
                spillerPos = spiller.getPosisjon();

                if (spillerPos == 100) {
                    this.vunnet = spiller;
                    System.out.println(navn + " vinner spillet!");
                    break;

                } else {

                    int endring = brett.getRuteVerdi(spillerPos);

                    if (endring < 0) {
                        System.out.println(spiller.getNavn() + " møtte på en slange på rute " + spillerPos + ", du rykker tilbake til " + brett.getNyPos(spillerPos) + "\n");

                        spiller.endrePos(brett.getRuteVerdi(spillerPos));
                    } else if (endring > 0) {
                        System.out.println(navn + " møtte på en stige " + spillerPos + ", du går fram til " + brett.getNyPos(spillerPos) + "\n");

                        spiller.endrePos(brett.getRuteVerdi(spillerPos));
                    } else {
                        spiller.endrePos(endring);
                        spillerPos = spiller.getPosisjon();
                        System.out.println(navn + " landet trygt på " + ((spillerPos)) + "\n");
                    }
                }

            } else {
                System.out.println(navn + " havnet utenfor brettet, og blir dermed stående");
            }
        }
    }
}



