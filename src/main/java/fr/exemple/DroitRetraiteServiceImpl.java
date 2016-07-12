package fr.exemple;

import org.springframework.stereotype.Component;

import java.time.Period;

@Component
public class DroitRetraiteServiceImpl implements DroitRetraiteService {

    @Override
    public Period calculerAgeLegalDepartRetraite(Individu individu) {
        return Period.ZERO;
    }
}
