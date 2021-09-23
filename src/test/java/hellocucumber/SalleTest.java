package hellocucumber;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SalleTest {

    @Test(expected = IllegalArgumentException.class)
    public void tropPeuDeTableTest() {
        new Salle(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tropDeTableTest() {
        new Salle(21);
    }

    @Test
    public void tableConsistencyTest() {
        assertThat(new Salle(15).getCapacity()).isEqualTo(15);
    }

}