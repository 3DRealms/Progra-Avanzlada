package model;

public class Punto {
    private char tipo;
    private int orden;
    private Punto siguiente;

    public Punto() {
    }

    public Punto(char value, int index, Punto next) {
        this.tipo = value;
        this.orden = index;
        this.siguiente = next;
    }

    public char getTipo() {
        return tipo;
    }

    public int getOrden() {
        return orden;
    }

    public Punto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Punto ahead) {
        this.siguiente = ahead;
    }

    public boolean hasNext() {
        return getSiguiente() != null;
    }

    public void use() {
        this.tipo = 'U';
    }

    public boolean isControl() {
        return tipo == 'C';
    }

    public boolean isNotUsed() {
        return tipo != 'U';
    }

    public boolean isLed() {
        return tipo == 'L';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Punto node = (Punto) o;

        if (tipo != node.tipo) {
            return false;
        }
        if (orden != node.orden) {
            return false;
        }
        return !(siguiente != null ? !siguiente.equals(node.siguiente) : node.siguiente != null);
    }

    @Override
    public int hashCode() {
        int result = (int) tipo;
        result = 31 * result + orden;
        result = 31 * result + (siguiente != null ? siguiente.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return tipo + "(" + orden + ")";
    }
}