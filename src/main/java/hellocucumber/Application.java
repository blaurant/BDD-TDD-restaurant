package hellocucumber;

public class Application {

    public Salle affecter (Salle salle, int nombreDeConvives) {
        checkNotNull(salle, "Salle est nulle");
        checkPositif(nombreDeConvives, "nombre de convives est < 0");
        salle.affecter(nombreDeConvives);
        return salle;
    }

    public Salle liberer(Salle salle, Integer nombreDeConvives) {
        checkNotNull(salle, "Salle est nulle");
        checkPositif(nombreDeConvives, "nombre de convives est < 0");
        salle.liberer(nombreDeConvives);
        return salle;
    }

    private void checkPositif(int number, String err) {
        if (number<=0)
            throw new IllegalArgumentException(err);
    }

    private void checkNotNull(Object object, String s) {
        if (object == null)
            throw new IllegalArgumentException(s);
    }
}
