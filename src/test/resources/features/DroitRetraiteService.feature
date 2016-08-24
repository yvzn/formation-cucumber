# encoding: utf-8
# language: fr
Fonctionnalité: Contrôle de l'alimentation du collecteur

  Scénario: Individu né avant juillet 1951
    Soit un individu
    Et la date de naissance '01/01/1951'
    Quand j'appelle le service calcul âge légal de départ retraite
    Alors l'âge calculé est 60 ans et 0 mois

  Scénario: Individu né entre juillet et decembre 1951
    Soit un individu
    Et la date de naissance '01/09/1951'
    Quand j'appelle le service calcul âge légal de départ retraite
    Alors l'âge calculé est 60 ans et 4 mois

  Plan du scénario: <nom du scenario>
    Soit un individu
    Et la date de naissance '<date>'
    Quand j'appelle le service calcul âge légal de départ retraite
    Alors l'âge calculé est <ans> ans et <mois> mois
    Exemples:
      | nom du scenario                            | date       | ans | mois |
      | individu né avant juillet 1951             | 01/01/1951 | 60  | 0    |
      | individu né entre juillet et decembre 1951 | 01/09/1951 | 60  | 4    |
      | individu né en 1952                        | 01/01/1952 | 60  | 9    |
      | individu né en 1953                        | 01/01/1953 | 61  | 2    |
      | individu né en 1954                        | 01/01/1954 | 61  | 7    |
      | individu après 1955                        | 01/01/1955 | 62  | 0    |
