package hellocucumber;

import io.vavr.collection.List;

public class Salle {

    private List<Table> tables = null;

    public Salle(int nombreDeTables) {
        if (nombreDeTables < 4 || nombreDeTables > 20)
            throw new IllegalArgumentException("le nombre de tables doit etre compris entre 4 et 20");
        this.tables = Table.generate(nombreDeTables);
    }

    public int getCapacity() {
        return tables.length();
    }

    public Salle affecter(int nombreDeConvives) {
        if (!canHandle(nombreDeConvives))
            throw new IllegalArgumentException("Trop de convives à affecter");
        selectPreteTable(nombreDeConvives).forEach(table -> table.affecter());
        return this;
    }

    private List<Table> selectPreteTable(int nombreDeConvives) {
        return onlyPrete().dropRight(onlyPrete().length() - nombreDeTables(nombreDeConvives));
    }

    boolean canHandle(int nombreDeConvives) {
        return nombreTablePrete() >= nombreDeTables(nombreDeConvives);
    }

    private int nombreDeTables(int nombreDeConvives) {
        return nombreDeConvives / 2 + nombreDeConvives % 2;
    }

    int nombreTablePrete() {
        return onlyPrete().length();
    }

    private List<Table> onlyPrete() {
        return tables.filter(table -> table.isPrete());
    }

    public int nombreTableOccupee() {
        return onlyOccupee().length();
    }

    private List<Table> onlyOccupee() {
        return tables.filter(table -> table.isOccupee());
    }
}
