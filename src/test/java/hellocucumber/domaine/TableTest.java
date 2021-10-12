package hellocucumber.domaine;

import hellocucumber.domaine.Table;
import org.junit.Test;

import static hellocucumber.domaine.Table.Status.PRETE;
import static org.assertj.core.api.Assertions.assertThat;


public class TableTest {

    @Test(expected = IllegalArgumentException.class)
    public void tablePlusPetitQueUn() {
        new Table(0);
    }

    @Test
    public void tableConstruction() {
        assertThat(new Table(1).getStatus()).isEqualTo(PRETE);
    }

    @Test
    public void tableGeneration() {
        assertThat(Table.generate(1).length()).isEqualTo(1);
        assertThat(Table.generate(25).length()).isEqualTo(25);
    }
}
