package test_java;
import java.util.ArrayList;
import java.util.List;

public abstract class Animale implements Comparable<Animale>{
    private int anni;
    private String nome;
    private List<String> vaccini = new ArrayList<>();
    public Animale(int anni, String nome){
        setNome(nome);
        setAnni(anni);
    }
    //Getters
    public int getAnni() {
        return anni;
    }
    public String getNome() {
        return nome;
    }
    public List<String> getVaccini() {
        List<String> v = new ArrayList<>();
        v = List.copyOf(vaccini);
        return v;
    }
    //Setters
    public void setAnni(int anni) {
        if (anni < 0) {
            throw new IllegalArgumentException("Eta' non valida");
        }
        this.anni = anni;
    }
    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome non valido");
        }
        this.nome = nome.trim();
    }
    public void aggiungiVaccino(String vaccino){
        if (vaccino == null || vaccino.trim().isEmpty()) {
            throw new IllegalArgumentException("Vaccino non valido");
        }
        vaccini.add(vaccino.trim());
    }
    @Override
    public String toString() {

        return "Nome: " + nome + " | Eta': " + anni;
    }
    @Override 
    public int compareTo(Animale other){
        return Integer.compare(this.getAnni(), other.getAnni());
    }


    public abstract void suono();
    public abstract void mangia(String cibo);  
    public abstract double calcolaFabbisognoCalorico();
    public abstract double calcolaCostoGiornaliero(); 
    public abstract double stimaCostoVeterinario();
}