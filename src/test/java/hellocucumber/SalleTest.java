package hellocucumber;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void tablePreteTest() {
        assertThat(new Salle(5).estCePossibleDoccupper(9)).isTrue();
        assertThat(new Salle(5).estCePossibleDoccupper(10)).isTrue();
        assertThat(new Salle(5).estCePossibleDoccupper(11)).isFalse();
    }

    @Test
    public void affecterTest() {
        assertThat(new Salle(5).affecter(1).nombreTablePrete()).isEqualTo(4);
        assertThat(new Salle(5).affecter(5).nombreTablePrete()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tropAaffecterTest() {
        new Salle(5).affecter(11);
    }
}