Feature: We can count the number of meetings people have
  Scenario: Person has meetings
    Given a person named "Matt"
    And person goes to meeting called "Standup" 
    And person goes to meeting called "Demo" 
    And person goes to meeting called "Retro" 
    Then person has 3 meetings
