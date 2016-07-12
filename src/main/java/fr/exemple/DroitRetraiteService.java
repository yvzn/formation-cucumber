package fr.exemple;

import java.time.Period;

public interface DroitRetraiteService {

    Period calculerAgeLegalDepartRetraite(final Individu individu);
}
