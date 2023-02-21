import java.util.Random;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
        
        System.out.println("Testataan luokkaa Pelaaja...");
       
        Pelaaja pel = new Pelaaja(11, "Sakari Koivunen");
        
        System.out.println("Pelaajaolio luotu!");
        
        try {
            Field numero = pel.getClass().getDeclaredField("numero");
            boolean numeroPrivate = numero.getModifiers() == 2;
            System.out.println("Numero on yksityinen: " + numeroPrivate);
        } catch (Exception e) {
            System.out.println("Attribuuttia numero ei ole määritelty");
        }
        
        try {
            Field nimi = pel.getClass().getDeclaredField("nimi");
            boolean nimiPrivate = nimi.getModifiers() == 2;
            System.out.println("Nimi on yksityinen: " + nimiPrivate);
        } catch (Exception e) {
            System.out.println("Attribuuttia nimi ei ole määritelty");
        }
        
        System.out.println("Testataan havainnointimetodeja...");
        System.out.println("Nimi: " + pel.getNimi());
        System.out.println("Numero: " + pel.getNumero());
        
        System.out.println("Testataan asetusmetodeja...");
        pel.setNimi("Teemu Seläke");
        pel.setNumero(8);
        System.out.println("Nimi: " + pel.getNimi());
        System.out.println("Numero: " + pel.getNumero());
        
        
//-----------------------------------------------------------------
        
       System.out.println("Testataan luokkaa Joukkue...");
       
       Joukkue j = new Joukkue("TyPS");
       
       System.out.println("Joukkueolio luotu!");
       
       try {
           Field nimi = j.getClass().getDeclaredField("nimi");
           boolean nimiPrivate = nimi.getModifiers() == 2;
           System.out.println("Nimi on yksityinen: " + nimiPrivate);
       } catch (Exception e) {
           System.out.println("Attribuuttia nimi ei ole määritelty");
       }
              
       System.out.println("Testataan havainnointimetodeja...");
       System.out.println("Nimi: " + j.getNimi());
       
       System.out.println("Testataan asetusmetodeja...");
       j.setNimi("Yliopiston palloiluseura");
       System.out.println("Nimi: " + j.getNimi());
      
       System.out.println("Lisätään pelaajia joukkueeseen...");
       Pelaaja p1 = new Pelaaja(10, "Jari Litmakainen");
       Pelaaja p2 = new Pelaaja(11, "Sakari Koivunen");
       
       
       j.lisaaPelaaja(p1);
       j.lisaaPelaaja(p2);
       
       System.out.println("Pelaajat lisätty!");
       System.out.println("Tulostetaan pelaajat:");
       j.tulostaPelaajat();
       
       Pelaaja p3 = new Pelaaja(8, "Teemu Seläke");
       j.lisaaPelaaja(p3);
       System.out.println("Pelaajat lisätty!");
       System.out.println("Tulostetaan pelaajat:");
       j.tulostaPelaajat();

//-----------------------------------------------------------
       System.out.println("Testataan luokkaa Ottelu...");
       
       Joukkue j1 = new Joukkue("TyPS");
       Joukkue j2 = new Joukkue("YlPa");
       
       Ottelu ottelu = new Ottelu(j1, j2);
       System.out.println("Otteluolio luotu!");
       
       for (String fname : new String[] {"joukkue1", "joukkue2", "maalit1", "maalit2"}) {
           try {
               Field fld = ottelu.getClass().getDeclaredField(fname);
               boolean isPrivate = fld.getModifiers() == 2;
               System.out.println(fname + " on yksityinen: " + isPrivate);
           } catch (Exception e) {
               System.out.println("Attribuuttia " + fname + " ei ole määritelty");
           }
       }
       
       System.out.println("Avaustilanne: ");
       ottelu.tulostaTilanne();
       
       System.out.println("Lisätään maaleja...");
       
       ottelu.lisaaMaali(j1);
       ottelu.tulostaTilanne();
       
       ottelu.lisaaMaali(j2);
       ottelu.tulostaTilanne();
       
       ottelu.lisaaMaali(j1);
       ottelu.tulostaTilanne();
       
       ottelu.lisaaMaali(j1);
       ottelu.tulostaTilanne();
       
       ottelu.lisaaMaali(j2);
       ottelu.tulostaTilanne();






       
    }
}


/*Aloitetaan jalkapallo-ottelun toteuttaminen Pelaaja-luokasta.

Kirjoita siis luokka Pelaaja, jolla on seuraavat ominaisuudet:

Attribuutti numero (kokonaisluku)
Attribuutti nimi (merkkijono)
Konstruktori, joka saa numeron ja nimen parametreiksi ja asettaa attribuuttien arvot
Havainnointimetodit numerolle ja nimelle (nimeä muodossa getNimi)
Asetusmetodit numerolle ja nimelle (nimeä muodossa setNimi)
Huom! Tuttuun tapaan luokka ei saa olla julkinen - älä siis käytä määrittelyssä määrettä public. */

//Luodaan luokka pelaaja.
class Pelaaja {
    //Lisätään luokkaan pelaaja attribuutit numero(kokonaisluku) ja nimi(merkkijono).
    private int numero;
    private String nimi;

    //Luodaan konstruktori joka muodostaa "pelaaja" olion. Konstruktorille luodaan parametrit int numero, String nimi.
    public Pelaaja(int numero, String nimi){
        this.numero = numero;
        this.nimi = nimi;
    }

    //Luodaan havannointimetodit, eli "getterit".

    public int getNumero(){
        return this.numero;
    }

    public String getNimi(){
        return this.nimi;
    }


    //Luodaan asetusmetodit, eli "setterit".
    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setNimi(String nimi){
        this.nimi = nimi;
    }
}


/*Jatketaan toteutusta toteuttamalla luokka, joka mallintaa yhtä joukkuetta.

Kirjoita siis (ei-julkinen) luokka Joukkue, jolla on seuraavat ominaisuudet:

Attribuutti nimi (merkkijono)
Jokin attribuutti, johon säilötään pelaajat
Konstruktori, joka saa parametrikseen nimen
Asetus- ja havainnointimetodit nimelle
Metodi lisaaPelaaja(Pelaaja p), joka lisää yhden pelaajan joukkueeseen
Metodi tulostaPelaajat(), joka tulostaa pelaajat lisäysjärjestyksessä alla näkyvän esimerkin mukaisest (ensin siis numero, sitten nimi)i:
 

Esimerkkitulostus pelaajista:

10. Jari Litmakainen
11. Sakari Koivunen */



class Joukkue {
    private ArrayList<String> pelaajaLista = new ArrayList<>();
    private String nimi;
    private HashMap<Integer,String> map = new HashMap<Integer, String>();
    private ArrayList<String> uusiLista = new ArrayList<>();

    public Joukkue(String nimi){
        this.nimi = nimi;
    }
    
    public String getNimi(){
        return this.nimi;
    }

    public void setNimi(String nimi){
        this.nimi = nimi;
    }

    public void lisaaPelaaja(Pelaaja p){
        map.put(p.getNumero(), p.getNimi());
    }

    public void tulostaPelaajat(){

        for(int pelaajat : map.keySet()){
            //System.out.println(Integer.toString(pelaajat) + " " + map.get(pelaajat) + "PELAAJAT!!!");
            if(!pelaajaLista.contains(map.get(pelaajat))){
                pelaajaLista.add(Integer.toString(pelaajat) + ". " + map.get(pelaajat));
            }
        }

        for(String pelaaja : pelaajaLista){
            if(!uusiLista.contains(pelaaja)){
                uusiLista.add(pelaaja);
            }
        }
        
        for(String i : uusiLista){
            System.out.println(i);
        }

    }
        
}


/*Kirjoitetaan lopuksi luokka, jolla mallinnetaan yhtä jalkapallo-ottelua.

Kirjoita siis (ei-julkinen) luokka Ottelu, jolla on seuraavat piirteet:

Attribuutit joukkue1 ja joukkue2, joiden tyyppit on Joukkue
Kokonaislukutyyppiset attribuutit maalit1 ja maalit2
Konstruktori, joka saa parametrikseen joukkueet 1 ja 2 (mutta ei maalimääriä)
Metodi void lisaaMaali(Joukkue joukkue), joka kasvattaa annetun joukkueen maalimäärää yhdellä
Metodi tulostaTilanne(), joka tulostaa pelitilanteen alla olevan esimerkin mukaisessa muodossa;

Esimerkkitulostus kutsutttaessa metodia tulostaTlianne:

TyPS - YlPa: 1 - 0 */


class Ottelu {
    private Joukkue joukkue1;
    private Joukkue joukkue2;

    private int maalit1;
    private int maalit2;

    public Ottelu(Joukkue joukkue1, Joukkue joukkue2){
        this.joukkue1 = joukkue1;
        this.joukkue2 = joukkue2;

    }



    public void lisaaMaali(Joukkue joukkue){
        if(joukkue.equals(joukkue1)){
            maalit1 += 1;
        }
        if(joukkue.equals(joukkue2)){
            maalit2 +=1;
        }
    }

    public void tulostaTilanne(){

        System.out.println(joukkue1.getNimi() + " - " + joukkue2.getNimi() + ": " + maalit1 + " - " + maalit2);
    }


}