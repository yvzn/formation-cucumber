package fr.exemple;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@Component
public class DroitRetraiteServiceImpl implements DroitRetraiteService {

    private static final LocalDate PREMIER_JUILLET_1951 = LocalDate.of(1951, Month.JULY, 1);
    private static final LocalDate PREMIER_JANVIER_1952 = LocalDate.of(1952, Month.JANUARY, 1);
    private static final LocalDate PREMIER_JANVIER_1953 = PREMIER_JANVIER_1952.plusYears(1);
    private static final LocalDate PREMIER_JANVIER_1954 = PREMIER_JANVIER_1953.plusYears(1);
    private static final LocalDate PREMIER_JANVIER_1955 = PREMIER_JANVIER_1954.plusYears(1);

    @Override
    public Period calculerAgeLegalDepartRetraite(Individu individu) {
        if (individu.getDateNaissance().isBefore(PREMIER_JUILLET_1951))
            return Period.ofYears(60);
        else if (individu.getDateNaissance().isBefore(PREMIER_JANVIER_1952))
            return Period.of(60, 4, 0);
        else if (individu.getDateNaissance().isBefore(PREMIER_JANVIER_1953))
            return Period.of(60, 9, 0);
        else if (individu.getDateNaissance().isBefore(PREMIER_JANVIER_1954))
            return Period.of(61, 2, 0);
        else if (individu.getDateNaissance().isBefore(PREMIER_JANVIER_1955))
            return Period.of(61, 7, 0);
        else
            return Period.ofYears(62);
    }
}
