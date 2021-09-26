package hellocucumber;

public class Application {

    public Salle affecter (Salle salle, int nombreDeConvives) {
        if (salle == null)
            throw new IllegalArgumentException("Salle est nulle");
        if (nombreDeConvives < 0)
            throw new IllegalArgumentException("nombre de convives est < 0");
        salle.affecter(nombreDeConvives);
        return salle;
    }
}
