Feature: Alert handles

  Background:
    Given User on Alert UI

  @alert1
  Scenario: Accept alert
    Then User accept the alert

  @alert2
  Scenario Outline: Alert accept/dismiss
    When User "<action>" the alert
    Then User should able to see the message as "<message>"
    Examples:
      | action  | message                                     |
      | accept  | You clicked OK, confirm returned true.      |
      | dismiss | You clicked Cancel, confirm returned false. |
  @alert3
  Scenario:
    When user click on prompt and send the "demo" message
    Then user should able to see the "demo" message
