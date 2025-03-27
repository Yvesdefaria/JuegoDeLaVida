package daw;


public class Celula {


    private boolean estaVivo;


    public Celula() {
    }


    public Celula(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }


    public boolean isEstaVivo() {
        return estaVivo;
    }


    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }


    @Override
    public String toString() {
        return "Celula [estaVivo=" + estaVivo + "]";
    }


}

