Feature: Gestion de salle
  La salle contient des tables qui peuvent être affectés, libérées ou dressées.

  Scenario: Affectation de table(s)
    Given une salle contenant 15 tables
    And 7 convives pour un repas
    When j'affecte des tables
    Then le nombre de tables "OCCUPEE" est 4
    And le nombre de tables "PRETE" est 11

  Scenario: Liberation de table(s)
    Given une salle contenant 15 tables
    And 7 convives pour un repas
    And j'affecte des tables
    When je libère les tables
    And le nombre de tables "PRETE" est 11
    And le nombre de tables "OCCUPEE" est 0
    And le nombre de tables "SALE" est 4

  Scenario: Liberation de table(s)
    Given une salle contenant 15 tables
    And 7 convives pour un repas
    And j'affecte des tables
    And je libère les tables
    When je dresse les tables
    And le nombre de tables "PRETE" est 15
    And le nombre de tables "OCCUPEE" est 0
    And le nombre de tables "SALE" est 0
