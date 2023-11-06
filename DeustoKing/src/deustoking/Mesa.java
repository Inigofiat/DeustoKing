package deustoking;

public class Mesa {
	private int numeroMesa;
    private int capacidad;
    private boolean ocupada;

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.ocupada = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void marcarComoOcupada() {
        ocupada = true;
    }

    public void marcarComoDesocupada() {
        ocupada = false;
    }

    @Override
    public String toString() {
        return "Mesa #" + numeroMesa + " (Capacidad: " + capacidad + ", Ocupada: " + (ocupada ? "Sí" : "No") + ")";
    }

}
