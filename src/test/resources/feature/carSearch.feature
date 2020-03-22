Feature: Car search

  @car
  Scenario: Car Search
    When I enter post code as "OX144RY"
    And I select "Ford" from make drop box
    And I click on search button
    Then I verify the url as "https://www.motors.co.uk/search/car/"
    Then I found the results as "32,369"
    When I click on  model from filter options
    And I select model as "Galaxy"
    And I click on Update button
    Then I found the results as "611"
    When I selected to see full details of results 1
    Then I should see the make as "FORD"
    Then I should see the model as "GALAXY"
    Then I should see the variant as "2.0 TDCi 150 Titanium 5dr"
    Then I should see the title as "2016 (16) 2.0 TDCi 150 Titanium 5dr"
    When I click on dealer details tab
    Then I should see vehicle distance as "21 miles from OX144RY"




