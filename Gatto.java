package test_java;

public final class Gatto extends Animale{
    private boolean diAppartamento;
    public Gatto(int anni, String nome, boolean diAppartamento){
        super(anni, nome);
        setDiAppartamento(diAppartamento);
    }
    public void setDiAppartamento(boolean diAppartamento) {
        this.diAppartamento = diAppartamento;
    }
    public boolean isDiAppartamento(){
        return diAppartamento;
    } 
    @Override 
    public void suono(){
        System.out.println("Miao, miao");
    }
    @Override 
    public void mangia(String cibo){
        System.out.println("Il gatto " + getNome() + " sta mangiando del " + cibo);
    }
    @Override
    public double calcolaFabbisognoCalorico() {
        double x = 70 * getAnni();
        if(isDiAppartamento()){
            x*=0.85;
        }
        if (x <= 0) {
            x = 50;
        }
        return x;
    }  
    @Override
    public double calcolaCostoGiornaliero() {
        return calcolaFabbisognoCalorico() / 1000.0*3.80;
    }
    @Override
    public double stimaCostoVeterinario() {
        double x = 40.0;
        if (!isDiAppartamento()) {
            x+= 15;
        }
        return x;
    }

}
