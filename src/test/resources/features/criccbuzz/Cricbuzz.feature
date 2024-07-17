Feature: Login to cricbuzz

  @cricket
  Scenario Outline: Get the "<country>" cricket players names
    Given user logins to cricbuzz
    When user select "<country>"
    Examples:
      | country |
      | India   |

    @frame
    Scenario: frame handling
      Given user login to frames website
      Then user should able to see the "Page" message in ui
      And switch the frame to Left

