package no.hvl.DAT109;

/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lyngbø
 * @date 27.01.2021
 */
public class Brett {

    int[][] eksempelBrett;


    public Brett() {
        //legger ikkje inn noe spesielle verdier i tabellen, fordi ork
        this.eksempelBrett = new int[][]
                {{0, 0, 0, 5, 0, 0, 20, 0, 0, 0},
                {0, 0, -10, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }

    public int getRuteVerdi(int x){
        int j = (x / 10); // 1
        int k = (x % 10)-1; // 1
        int l = eksempelBrett[j][k];
        return l; // stige / slange
    }

    public int getNyPos(int x){
       return x + getRuteVerdi(x);
    }


}
