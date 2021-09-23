Feature: Gestion de salle
  La salle contient des tables qui peuvent être affectés, libérées ou dressées.

  Scenario: Affectation de table(s)
    Given une salle contenant 15 tables
    And 7 convives pour un repas
    When j'affecte des tables
    Then 4 tables sont occupés
    And le nombre de tables disponible restante est 11
