package hellocucumber;

import io.vavr.collection.List;

public class Salle {

    private List<Table> tables = null;

    public Salle(int nombreDeTables) {
        if (nombreDeTables < 4 || nombreDeTables > 20)
            throw new IllegalArgumentException("le nombre de tables doit etre comprios entre 4 et 20");
        this.tables = Table.generate(nombreDeTables);
    }

    public int getCapacity() {
        return tables.length();
    }

    public void affecter(int nombreDeConvices) {
        //this.tables.affecter(nombreDeConvices);
    }
}
