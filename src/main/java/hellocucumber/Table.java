package hellocucumber;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

import static hellocucumber.Table.Status.*;

public class Table {

    public static List<Table> generate(int nombreDeTables) {
        return List.ofAll(Stream
                .rangeClosed(1, nombreDeTables)
                .map(tableNumber -> new Table(tableNumber)));
    }

    public enum Status {PRETE, OCCUPEE, SALE;}
    public final int number;

    private Status status;
    public Table(int number) {
        if (number < 1)
            throw new IllegalArgumentException("le numéro de la table ne peut pas être inférieur à 1");
        this.number = number;
        this.status = PRETE;
    }

    public Status getStatus() {
        return status;
    }

    public void affecter() {
        this.status = OCCUPEE;
    }

    public void liberer() {
        this.status = SALE;
    }

    public void dreser() {
        this.status = PRETE;
    }

    boolean isPrete() {
        return isStatus(PRETE);
    }

    boolean isOccupee() {
        return isStatus(OCCUPEE);
    }

    boolean isSale() {
        return isStatus(SALE);
    }

    boolean isStatus(Status status) {
        return getStatus().equals(status);
    }
}
