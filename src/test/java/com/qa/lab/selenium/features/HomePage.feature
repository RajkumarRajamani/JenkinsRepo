#Author: rajkumar
@jenkins-github
Feature: Freshwork Homepage is develope

  @tag2
  Scenario Outline: User should be able to launch FreshWork Homepage
    Given user opens the application by hitting url in chrome browser
    When homepage is displayed

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
