package no.hvl.DAT109;


/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lyngbø
 * @version 1.0
 */
public class Terning {

    private int range = ((6-1) + 1);
    private int verdi;

    public Terning(){
        this.verdi = 0;
    }


    /**
     * @return verdi the value shown on the dice
     */
    public int getVerdi(){
        return verdi;
    }

    /**
     * method to change the value of the dice
     * @return verdi terningens verdi
     */
    public int trillTerning(){
        verdi = (int)(Math.random() * range) + 1;
        return verdi;
    }
}
