package fr.exemple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class DroitRetraiteServiceImplTest {

    @Autowired
    private DroitRetraiteServiceImpl droitRetraiteService;

    @Test
    public void individuNeAvantJuillet1951() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1951, Month.JANUARY, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.ofYears(60));
    }

    @Test
    public void individuNeEntreJuilletEtDecembre1951() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1951, Month.SEPTEMBER, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(60, 4, 0));
    }

    @Test
    public void individuNeEn1952() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1952, Month.JANUARY, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(60, 9, 0));
    }

    @Test
    public void individuNeEn1953() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1953, Month.JANUARY, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(61, 2, 0));
    }

    @Test
    public void individuNeEn1954() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1954, Month.JANUARY, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(61, 7, 0));
    }

    @Test
    public void individuNeApres1955() throws Exception {
        Individu individu = new Individu();
        individu.setDateNaissance(LocalDate.of(1955, Month.JANUARY, 1));

        LocalDate ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(individu);

        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(62, 0, 0));
    }
}