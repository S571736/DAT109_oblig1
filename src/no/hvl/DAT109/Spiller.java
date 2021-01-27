package no.hvl.DAT109;

/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lynbø
 * @date 27.01.2021
 */
public class Spiller {

    int id;
    String navn;
    int posisjon;

    /**
     *
     * @param id spiller id
     * @param navn navnet på spilleren
     */
    public Spiller(int id, String navn){
        this.id = id;
        this.navn = navn;
        this.posisjon = 0;
    }

    /**
     *
     * @param nyPos nye posisjonen til spiller
     */
    public void endrePos(int nyPos){
        this.posisjon = nyPos;
    }


}
