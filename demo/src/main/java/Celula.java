public class Celula {
    private int fila;
    private int columna;
    private boolean estaVivo;
   
    public Celula() {
    }

    public Celula(int fila, int columna, boolean estaVivo) {
        this.fila = fila;
        this.columna = columna;
        this.estaVivo = estaVivo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    @Override
    public String toString() {
        return "Celula [fila=" + fila + ", columna=" + columna + ", estaVivo=" + estaVivo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + fila;
        result = prime * result + columna;
        result = prime * result + (estaVivo ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Celula other = (Celula) obj;
        if (fila != other.fila)
            return false;
        if (columna != other.columna)
            return false;
        if (estaVivo != other.estaVivo)
            return false;
        return true;
    }

    
}
