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
                {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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
        int j, k, l;
        if(x > 9){
        j = (x / 10);
        k = (x % 10)-1;
        if(k < 0){
            k = 0;
        }
        l = eksempelBrett[j][k];
        }

        else{ // 0-9
            j = 0;
            l = eksempelBrett[j][x];

        }
        return l; // stige / slange
    }

    public int getNyPos(int x){
       return x + getRuteVerdi(x);
    }


}
