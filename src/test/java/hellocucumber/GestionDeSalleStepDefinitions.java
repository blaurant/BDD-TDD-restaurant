package hellocucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class GestionDeSalleStepDefinitions {

    private Salle salle;
    private int nombreDeConvives;

    @Given("une salle contenant {int} tables")
    public void une_salle_contenant_tables(Integer nombreDeTablesDansLaSalle) {
        this.salle = new Salle(nombreDeTablesDansLaSalle);
    }

    @Given("{int} convives pour un repas")
    public void convives_pour_un_repas(Integer nombreDeConvices) {
        this.nombreDeConvives = nombreDeConvices;
    }

    @When("j'affecte des tables")
    public void j_affecte_des_tables() {
        this.salle = new Application().affecter(salle, nombreDeConvives);
    }

    @When("je libère les tables")
    public void je_libère_les_tables() {
        this.salle = new Application().liberer(salle, this.nombreDeConvives);
    }

    @When("je dresse les tables")
    public void je_dresse_les_tables() {
        this.salle = new Application().dresser(salle, this.nombreDeConvives);
    }

    @Then("le nombre de tables {string} est {int}")
    public void le_nombre_de_tables_est(String status, int nombreDeTablesOccupees) {
        assertEquals(nombreDeTablesOccupees, this.salle.nombreTable(Table.Status.valueOf(status)));
    }
}
