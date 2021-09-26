package hellocucumber;

import io.vavr.collection.List;
import io.vavr.collection.Stream;

public class Table {

    public static List<Table> generate(int nombreDeTables) {
        return List.ofAll(Stream
                .rangeClosed(1, nombreDeTables)
                .map(tableNumber -> new Table(tableNumber)));
    }

    public static enum Status {PRETE, OCCUPEE, LIBRE}

    public final int number;

    private Status status;
    public Table(int number) {
        if (number < 1)
            throw new IllegalArgumentException("le numéro de la table ne peut pas être inférieur à 1");
        this.number = number;
        this.status = Status.PRETE;
    }

    public Status getStatus() {
        return status;
    }
}