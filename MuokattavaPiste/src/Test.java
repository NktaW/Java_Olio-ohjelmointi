import java.util.Random;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
      
        System.out.println("Testataan luokkaa MuokattavaPiste...");
        for (int testi=1; testi<=3; testi++) {
            System.out.println("Testi " + testi);
            MuokattavaPiste mp = new MuokattavaPiste(r.nextInt(20), r.nextInt(20));
            System.out.println("Olio luotu!");
            
            System.out.println("Havainnointi:");
            System.out.println("x: " + mp.getX());
            System.out.println("y: " + mp.getY());
            
            System.out.println("Asetus: ");
            mp.setX(r.nextInt(20));
            mp.setY(r.nextInt(20));
            System.out.println("x: " + mp.getX());
            System.out.println("y: " + mp.getY());
            
            System.out.println("");
        } 
    }
}

class Piste {
    protected int x;
    protected int y;
    
    public Piste(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


/*Ohjelmassa on määritelty luokka Piste.

Kirjoita luokka MuokattavaPiste, joka perii luokan Piste. Luokalla tulee olla seuraavat ominaisuudet:

Konstruktori, joka saa parametriksi x:n ja y:n ja asettaa yliluokasta perittyjen attribuuttien arvot näiden mukaan
Havainnointimetodit getX ja getY
Asetusmetodi setX ja setY */

class MuokattavaPiste extends Piste {

    public MuokattavaPiste(int x, int y){
        super(x,y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
