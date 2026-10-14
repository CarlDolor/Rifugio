package test_java;
import java.util.*;
public class AnimaliDomestici{
    public static void main(String[] args) {
        List<Animale> animali = new ArrayList<>();
        animali.add(new Cane(7, "Coco", "Chihuhua"));
        animali.add(new Cane(15, "Pinoy", "non lo so"));
        animali.add(new Cane(6, "Mirto", "Negro"));
        animali.add(new Gatto(20, "Sbirulina", true));
        Collections.sort(animali);
        stampaReportNutrizionale(animali);
        stampaReportPerCostoDecrescente(animali);
    }


    public static void nutriTutti(List<Animale> aList, String cibo){
        for (Animale a : aList) {
            a.mangia(cibo);
        }    
    }
    public static double calcolaCostoTotaleGiornaliero(List<Animale> animali){
        double sum = 0;
        for (Animale a : animali) {
            sum += a.calcolaCostoGiornaliero();
        }
        return sum;
    }
    public static void stampaReportNutrizionale(List<Animale> animali){
        for (Animale a : animali) {
            System.out.println(a.toString() + " | Fabbisogno giornaliero: " + String.format("%.2f", a.calcolaFabbisognoCalorico()) + " | Costo giornaliero: " + String.format("%.2f", a.calcolaCostoGiornaliero()));
        }
        System.out.println("Costo totale di manetenimento animali domestici: " + calcolaCostoTotaleGiornaliero(animali));
    }
    public static double calcolaBudgetVeterinario(List<Animale> animali){
        double x = 0;
        for (Animale animale : animali) {
            x+= animale.stimaCostoVeterinario();
        }
        return x;
    }
    public static void addestraSePossibile(List<Animale> animali, String comando){
        for (Animale a : animali) {
            if (a instanceof Addestrabile animaleAddestrabile) {
                animaleAddestrabile.eseguiComando(comando);
            }
        }
    }
    public static void stampaReportPerCostoDecrescente(List<Animale> animali){
        animali.sort((a1, a2) -> Double.compare(a2.calcolaCostoGiornaliero(), a1.calcolaCostoGiornaliero()));
        stampaReportNutrizionale(animali);
    }
}
