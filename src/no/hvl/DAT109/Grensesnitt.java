package no.hvl.DAT109;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lyngbø
 * @date 27.01.2021
 */
public class Grensesnitt {
    private Stigespill stigespill;
    private ArrayList<Spiller> spillere;

    /**
     * @param stigespill Spillet
     */
    public Grensesnitt(Stigespill stigespill) {
        this.stigespill = stigespill;
        this.spillere = new ArrayList<Spiller>(4);
    }

    /**
     * Start programmet
     */
    public void start() {

        System.out.println("Hvor mange spillere ønsker du? (2-4)");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        // Look at this magnificent recursive call that does not work!!!
        if (i < 2 || i > 4) {
            start();
        } else {

            for (int j = 0; j < i; j++) {
                System.out.println("Skriv inn navn på spiller " + (j + 1));
                String navn = scanner.next();
                Spiller s = new Spiller(j, navn);
                spillere.add(s);
            }


            stigespill.setup(spillere); //legger spillere inn i stigespillet
            stigespill.spill();

        }
    }

}
