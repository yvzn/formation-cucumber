# encoding: utf-8
# language: fr
Fonctionnalité: Contrôle de l'alimentation du collecteur

  Scénario: Individu né avant juillet 1951
    Soit un individu
    Et la date de naissance '01/01/1957'
    Quand j'appelle le service calcul âge légal de départ retraite
    Alors l'âge calculé est 60 ans et 0 mois