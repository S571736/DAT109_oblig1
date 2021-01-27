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

    public Spiller(int id, String navn){
        this.id = id;
        this.navn = navn;
        this.posisjon = 0;
    }

    public void endrePos(int endring){
        this.posisjon += endring;
    }
}
