package hellocucumber;

import hellocucumber.Table.Status;
import io.vavr.collection.List;

import java.util.Map;

import static hellocucumber.Table.Status.OCCUPEE;

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
        if (!estCePossibleDoccupper(nombreDeConvives))
            throw new IllegalArgumentException("Trop de convives à affecter");
        selectTablePrete(nombreDeConvives).forEach(table -> table.affecter());
        return this;
    }

    public void liberer(int nombreDeConvives) {
        if (!estCePossibleDeLiberer(nombreDeConvives))
            throw new IllegalArgumentException("Trop de convives à libérer");
        selectTableOccupees(nombreDeConvives).forEach(table -> table.occuper());
    }

    private List<Table> selectTableOccupees(int nombreDeConvives) {
        return onlyOccupee().dropRight(onlyOccupee().length() - nombreDeTables(nombreDeConvives));
    }

    private List<Table> selectTablePrete(int nombreDeConvives) {
        return onlyPrete().dropRight(onlyPrete().length() - nombreDeTables(nombreDeConvives));
    }

    boolean estCePossibleDoccupper(int nombreDeConvives) {
        return nombreTablePrete() >= nombreDeTables(nombreDeConvives);
    }

    boolean estCePossibleDeLiberer(int nombreDeConvives) {
        return nombreTableOccupee() >= nombreDeTables(nombreDeConvives);
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
        return nombreTable(OCCUPEE);
    }

    private List<Table> onlyOccupee() {
        return tables.filter(table -> table.isOccupee());
    }

    public int nombreTable(Status status) {
        return only(status).length();
    }

    private List<Table> only(Status status) {
        return tables.filter(table -> table.isStatus(status));
    }
}
