package test_java;

public final class Cane extends Animale implements Addestrabile{
    private String razza;
    public Cane(int anni, String nome, String razza){
        super(anni, nome);
        setRazza(razza);
    }
    public void setRazza(String razza) {
        if (razza == null || razza.trim().isEmpty()) {
            throw new IllegalArgumentException("Razza non valida");
        }
        this.razza = razza.trim();
    }
    public String getRazza() {
        return razza;
    }
    @Override 
    public String toString(){   

        return super.toString() + " | Razza: " + razza;
    }
    @Override 
    public void suono(){
        System.out.println("Woof, woof");
    }
    @Override 
    public void mangia(String cibo){
        System.out.println("Il cane " + getNome() + " sta mangiando del " + cibo);
    }
    @Override 
    public double calcolaFabbisognoCalorico(){
        double x = 100 * super.getAnni();
        if (getRazza().equalsIgnoreCase("Chihuahua")) {
            x *= 0.8;
        }else{
            x*= 1.2;
        }
        return x;
    }

    @Override 
    public double calcolaCostoGiornaliero(){
        return calcolaFabbisognoCalorico() / 1000.0 * 2.5;
    }
    @Override 
    public double stimaCostoVeterinario() {
        double x = 50.0;
        if (getAnni() > 10) {
            x+=20;
        } 
        return x;
    }
    @Override 
    public void eseguiComando(String comando){
        System.out.println("Il cane " + getNome() + " esegue il comando: " + comando);
    }
}
