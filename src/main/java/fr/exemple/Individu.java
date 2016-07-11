package fr.exemple;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Individu {

    String nom;

    String prenom;

    LocalDate dateNaissance;
}
