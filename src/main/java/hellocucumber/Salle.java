package hellocucumber;

import hellocucumber.Table.Status;
import io.vavr.collection.List;
import io.vavr.collection.Traversable;

import java.util.Map;

import static hellocucumber.Table.Status.*;

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

    public Salle liberer(int nombreDeConvives) {
        if (!estCePossibleDeLiberer(nombreDeConvives))
            throw new IllegalArgumentException("Trop de convives à libérer");
        selectTableOccupees(nombreDeConvives).forEach(table -> table.liberer());
        return this;
    }


    public Salle dresser(int nombreDeConvives) {
        if (!estCePossibleDeDresser(nombreDeConvives))
            throw new IllegalArgumentException("Trop de convives à dresser");
        selectTableSales(nombreDeConvives).forEach(table -> table.dreser());
        return this;
    }

    private List<Table> selectTableOccupees(int nombreDeConvives) {
        return onlyOccupee().dropRight(onlyOccupee().length() - nombreDeTables(nombreDeConvives));
    }

    private List<Table> selectTablePrete(int nombreDeConvives) {
        return onlyPrete().dropRight(onlyPrete().length() - nombreDeTables(nombreDeConvives));
    }

    private List<Table> selectTableSales(int nombreDeConvives) {
        return onlySale().dropRight(onlySale().length() - nombreDeTables(nombreDeConvives));
    }

    boolean estCePossibleDoccupper(int nombreDeConvives) {
        return nombreTablePrete() >= nombreDeTables(nombreDeConvives);
    }


    boolean estCePossibleDeLiberer(int nombreDeConvives) {
        return nombreTableOccupee() >= nombreDeTables(nombreDeConvives);
    }

    private boolean estCePossibleDeDresser(int nombreDeConvives) {
        return nombreTableSale() >= nombreDeTables(nombreDeConvives);
    }

    private int nombreDeTables(int nombreDeConvives) {
        return nombreDeConvives / 2 + nombreDeConvives % 2;
    }

    private List<Table> onlyPrete() {
        return tables.filter(table -> table.isPrete());
    }
    private List<Table> onlySale() {
        return tables.filter(table -> table.isSale());
    }

    int nombreTablePrete() {
        return nombreTable(PRETE);
    }

    public int nombreTableOccupee() {
        return nombreTable(OCCUPEE);
    }

    public int nombreTableSale() {
        return nombreTable(SALE);
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
