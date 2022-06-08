@primeNumberTests

Feature: Validating primeNumbers API
  @getListOfPrimeNumbers97
  Scenario: Returning a list of prime Numbers including 97
    Given I provide the value "97"
    When I retrieve the list of prime numbers
    Then the numbers are returned with a 200 response
    And the "number" in response body is "97"
    And the size of numbers in the list is 25

  @getListOfPrimeNumbers11
  Scenario: Returning a list of prime Numbers including 11
    Given I provide the value "11"
    When I retrieve the list of prime numbers
    Then the numbers are returned with a 200 response
    And the "number" in response body is "11"
    And the size of numbers in the list is 5

  @notPassingAPathParam
  Scenario: Not passing a value
    Given I provide the value ""
    When I retrieve the list of prime numbers
    Then the numbers are returned with a 404 response
    And the "error" in response body is "Not Found"

  @passingStringAsAParameter
  Scenario: Passing string value
    Given I provide the value "hello"
    When I retrieve the list of prime numbers
    Then the numbers are returned with a 400 response
    And the "error" in response body is "Bad Request"