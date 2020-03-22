Feature: Reduced price data

  Scenario Outline: Verify Reduced price data when vehicle has been reduced by no more than 20%.
    Given reduce the car price "<percentage>" of original car price
    Given I navigate to vehicle detail page
    When I select the Toyota Avensis car
    Then I should see Car price after reduced price
#    ex: Reduced by £200 was £2,875
    Then I should see data "Reduced by £reduced_percentage_price was original price"
    And I should see a link
    When I click link
    Then I should see historic price changes made to this vehicle.

    Examples:
      | percentage |
      | 0%         |
      | 19.99%     |
      | 20%        |

  Scenario Outline: Verify Reduced price data when vehicle has been reduced by more than 20%.
    Given reduce the car price "<percentage>" of original car price
    Given I navigate to vehicle detail page
    When I select the Toyota Avensis car
    Then I should see only original car price

    Examples:
      | percentage |
      | 20.1%      |
      | 21%        |
      | 50%        |
      | 75%        |
      | 100%       |

  Scenario: Verify privacy policy page/link
    When I click Email dealer button positioned below the dealer phone number
    Then I should see Link to Standard privacy policy
    When I click Standard privacy policy link
    Then privacy policy page should appear

  Scenario Outline: Dealer contact form with valid data
    When I click Email dealer button positioned below the dealer phone number
    Given I enter name as "<Name>"
    Given I enter email as "<Email>"
    Given I enter CC email as "<Cc_Email>"
    Given I enter Telephone Number as "<Telephone_Number>"
    Given I enter Message as "<Message>"
    When I click SEND button
    Then I should see email sent successfully

    Examples:
      | Name     | Email         | Cc_Email       | Telephone_Number | Message     |
      | testName | test@test.com | test1@test.com | 01234567890      | testMessage |
      | testName | test@test.com |                |                  |             |
      | testName | test@test.com | test1          |                  |             |

  Scenario Outline: Dealer contact form with invalid data
    When I click Email dealer button positioned below the dealer phone number
    Given I enter name as "<Name>"
    Given I enter email as "<Email>"
    Given I enter CC email as "<Cc_Email>"
    Given I enter Telephone Number as "<Telephone_Number>"
    Given I enter Message as "<Message>"
    When I click SEND button
    Then I should see "<ErrorMessage>"

    Examples:
      | Name     | Email         | Cc_Email       | Telephone_Number | Message      | ErrorMessage                   |
      |          |               |                |                  |              | Please enter Name and Email id |
      |          | test@test.com | test1@test.com | 01234567891      | testMessage1 | Please enter Name              |
      | testName |               | test2@test.com | 01234567892      | testMessage2 | Please enter Email id          |
      | testName | invalidEmail  | test3@test.com | 01234567893      | testMessage3 | Please enter valid Email id    |



