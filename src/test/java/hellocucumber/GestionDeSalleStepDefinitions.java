package hellocucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class GestionDeSalleStepDefinitions {

    private Salle salle;
    private int nombreDeConvices;

    @Given("une salle contenant {int} tables")
    public void une_salle_contenant_tables(Integer nombreDeTablesDansLaSalle) {
        this.salle = new Salle(nombreDeTablesDansLaSalle);
    }

    @Given("{int} convives pour un repas")
    public void convives_pour_un_repas(Integer nombreDeConvices) {
        this.nombreDeConvices = nombreDeConvices;
    }

    @When("j'affecte des tables")
    public void j_affecte_des_tables() {
        //this.salle.affecter(this.nombreDeConvices);
    }

    @Then("{int} tables sont occupés")
    public void tables_sont_occupés(Integer int1) {

        throw new io.cucumber.java.PendingException();
    }

    @Then("le nombre de tables disponible restante est {int}")
    public void le_nombre_de_tables_disponible_restante_est(Integer int1) {
        throw new io.cucumber.java.PendingException();
    }


}
