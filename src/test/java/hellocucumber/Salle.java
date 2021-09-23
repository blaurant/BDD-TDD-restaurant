package hellocucumber;

public class Salle {

    private int nombreDeTables;

    public Salle(int nombreDeTables) {
        if (nombreDeTables <4 || nombreDeTables >20)
            throw new IllegalArgumentException("le nombre de tables doit etre comprios entre 4 et 20");
        this.nombreDeTables = nombreDeTables;
    }

    public int getCapacity() {
        return nombreDeTables;
    }
}
