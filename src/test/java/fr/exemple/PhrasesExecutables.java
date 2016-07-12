package fr.exemple;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Soit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = AppConfig.class)
public class PhrasesExecutables {

    @Autowired
    private DroitRetraiteService droitRetraiteService;

    private Individu individu;

    private Period ageLegalDepartRetraite;

    @Soit("^un individu$")
    public void un_individu() throws Throwable {
        this.individu = new Individu();
    }

    @Soit("^la date de naissance '(\\d+)/(\\d+)/(\\d+)'$")
    public void la_date_de_naissance(int jj, int mm, int aaaa) throws Throwable {
        this.individu.setDateNaissance(LocalDate.of(aaaa, mm, jj));
    }

    @Quand("^j'appelle le service calcul âge légal de départ retraite$")
    public void j_appelle_le_service_calcul_âge_légal_de_départ_retraite() throws Throwable {
        ageLegalDepartRetraite = droitRetraiteService.calculerAgeLegalDepartRetraite(this.individu);
    }

    @Alors("^l'âge calculé est (\\d+) ans et (\\d+) mois$")
    public void l_âge_calculé_est_ans_et_mois(int aa, int mm) throws Throwable {
        assertThat(ageLegalDepartRetraite).isEqualTo(Period.of(aa, mm, 0));
    }
}
