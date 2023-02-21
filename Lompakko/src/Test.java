import java.util.Random;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
        
          
        
        double[] desit = {0.25, 0.5, 0.75, 0.99, 0.65, 0.30};
        System.out.println("Testataan luokkaa ParempiLompakko...");
        
        ParempiLompakko pl = new ParempiLompakko(r.nextInt(100) + 1);
        
        // testataan, että perintä toimii
        Lompakko lompakko = (Lompakko) pl;
        
        System.out.println("Olio luotu!");
        
        System.out.println("Rahaa nyt: " + pl.getRahaa());
        
        double rahat = r.nextInt(100) + 1 + desit[r.nextInt(desit.length)];
        System.out.println("Lisätään " + rahat);
        pl.lisaaRahaa(rahat);
        
        System.out.println("Rahaa nyt: " + pl.getRahaa());
        
        int eurot = r.nextInt(100) + 1;
        int sentit = r.nextInt(99) + 1;
        System.out.println("Lisätään " + eurot + " euroa ja " + sentit + " senttiä");
        pl.lisaaRahaa(eurot, sentit);
        
        System.out.println("Rahaa nyt: " + pl.getRahaa());
        
        eurot = r.nextInt(100) + 1;
        sentit = r.nextInt(99) + 1;
        
        String lisays = eurot + "." + sentit;
        
        System.out.println("Lisätään \"" + lisays + "\"");
        pl.lisaaRahaa(lisays);
        
        System.out.println("Rahaa nyt: " + pl.getRahaa());
    }
}

class Lompakko {
    protected double rahaa;

    public Lompakko(double rahaa) {
        this.rahaa = rahaa;
    }
    
    public void lisaaRahaa(double rahamaara) {
        rahaa += rahamaara;
    }
    
    public double getRahaa() {
        return rahaa;
    }
}

/* Ohjelmassa on määritelty luokka Lompakko, jolla on konstruktorin ja saldon havainnointimetodin lisäksi metodi lisaaRahaa(double rahat), jolla lompakkoon voi lisätä rahaa.

Kirjoita luokka ParempiLompakko, joka perii luokan Lompakko. Uudella luokalla on konstruktorin lisäksi kaksi ylikuormitettua uutta versiota metodista lisaaRahaa:

lisaaRahaa(int eurot, int sentit), joka saa erikseen lisättävät eurot ja sentit
lisaaRahaa(String rahamäärä), joka saa rahamäärän merkkijonona.  */

class ParempiLompakko  extends Lompakko{

    public ParempiLompakko(double rahaa){
        super(rahaa);
    }    

    public void lisaaRahaa(int eurot, int sentit){
        Double eur = eurot + .0;
        Double snt = sentit / 100.0;

        super.lisaaRahaa(eur + snt);
    }

    public void lisaaRahaa(String rahamaara){
        Double raha = 0.0;
        //raha += Integer.valueOf(rahamaara);
        //super.lisaaRahaa(raha);
        String massi = "";
        massi = rahamaara.replace("", "");
        //System.out.println(massi);
        raha = Double.valueOf(massi);
        super.lisaaRahaa(raha);
        
    }


}