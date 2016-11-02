# encoding: utf-8
# language: fr
Fonctionnalité: Contrôle du calcul de l'âge légal de départ

  Scénario: Affichage simple de la page
    Quand j'affiche la page /ageLegal dans le navigateur
    Alors le titre de la page est 'Demande Retraite'
    Et le bloc resultat est vide