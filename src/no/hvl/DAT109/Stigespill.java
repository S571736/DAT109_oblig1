package no.hvl.DAT109;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lyngbø
 * @date 27.01.2021
 *
 *
 */
public class Stigespill {

    public ArrayList<Spiller> spillere;
    private Spiller vinner;
    private Brett brett;
    private Terning terning;

    public Stigespill() {
        this.brett = new Brett();
        this.spillere = new ArrayList<Spiller>();
        this.terning = new Terning();
        this.vinner = null;

    }

    /**
     *
     * @param spillere legger inn spillere i listen
     */
    public void setup(ArrayList<Spiller> spillere) {
        this.spillere = spillere;
    }

    /**
     * hoved metoden for spillet
     */
    public void spill() {
        System.out.println("Starter spill");


        while (vinner == null) {
            spillRunde();
        }
    }

    /**
     * Hver spillrunde
     */
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
                System.out.println(navn + " trillet " + trillet + ", går fram til " + spiller.getPosisjon());
                trillet = terning.trillTerning();
                if (trillet == 6) {
                    spiller.endrePos(6);
                    System.out.println(navn + " trillet " + trillet);
                    trillet = terning.trillTerning();
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
                    this.vinner = spiller;
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



