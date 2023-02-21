import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test{
    public static void main(String[] args){
        final Random r = new Random();
        
          
        String[] tt = {"maito", "voi", "kaakao", "kahvi", "pavut", "herneet", "porkkanat",
                "ananas", "kastike", "puuro", "murot", "leipä", "keksit", "pulla", 
                "suklaa", "salmiakki", "piimä", "vesi"};
        ArrayList<String> tuotteet = new ArrayList<>(Arrays.asList(tt));
        Collections.shuffle(tuotteet, r);
        
        System.out.println("Testataan luokkaa LuomuKauppalista...");
        
        LuomuKauppalista lk = new LuomuKauppalista();
        System.out.println("Olio luotu!");
        
        // varmistetaan perintä
        Kauppalista k = (Kauppalista) lk;
        
        int koko = r.nextInt(5) + 10;
        for (int i=0; i<koko; i++) {
            String tuote = tuotteet.remove(r.nextInt(tuotteet.size()));
            if (r.nextInt(2) == 1) {
                tuote = "luomu" + tuote;
            }
            System.out.println("Lisätään listalle " + tuote);
            k.lisaaTuote(tuote);
        }
        String tuote = "luomu" + tuotteet.get(0);
        System.out.println("Lisätään listalle " + tuote);
        k.lisaaTuote(tuote);
        
        System.out.println("Luomulistan tuotteet:");
        String lista = lk.annaLista();
        if(lista.endsWith("\n")) {
            lista = lista.substring(0, lista.length() - 1);
        }
        System.out.println(lista);
        
        
    }
}
class Kauppalista {
    private ArrayList<String> tuotteet;
    
    public Kauppalista() {
        tuotteet = new ArrayList<>();
    }
    
    public void lisaaTuote(String tuote) {
        tuotteet.add(tuote);
    }
    
    public String annaLista() {
        return String.join("\n", tuotteet);    
    }   
}

/*Oheisessa ohjelmassa on määritelty luokka Kauppalista. Kirjoita luokka LuomuKauppalista, joka perii luokan Kauppalista.

Luokalla tulee olla seuraavat ominaisuudet:

Konstruktori, jolla ei ole yhtään parametria
Ylikirjoitettu metodi annaLista(), joka hyödyntää yliluokan toteutusta. Metodi palauttaa merkkijonossa kaikki listalle lisätyt tuotteet, joissa esiintyy sana "luomu". Voit olettaa, että kaikki tuotteet on kirjoitettu kokonaan pienillä kirjaimilla. Tuotteet on erotettu toisistaan rivinvaihdoilla. Katso mallia esimerkkitulosteesta alla.
Esimerkki luokan käytöstä:

public static void main(String[] args) {
    LuomuKauppalista lista = new LuomuKauppalista();
    lista.lisaaTuote("porkkanat");
    lista.lisaaTuote("luomubanaanit");
    lista.lisaaTuote("ananas");
    lista.lisaaTuote("luomuvessapaperi");
    
    System.out.println(lista.annaLista());
}
Ohjelma tulostaa:

luomubanaanit
luomuvessapaperi*/


class LuomuKauppalista extends Kauppalista {

    public LuomuKauppalista(){

    }

    public void lisaaTuote(String tuote){
        if(tuote.contains("luomu")){
            super.lisaaTuote(tuote);
        }
    }
        

}