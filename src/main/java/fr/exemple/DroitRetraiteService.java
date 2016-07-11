package fr.exemple;

import java.time.LocalDate;

public interface DroitRetraiteService {

    LocalDate calculerAgeLegalDepartRetraite(final Individu individu);
}
