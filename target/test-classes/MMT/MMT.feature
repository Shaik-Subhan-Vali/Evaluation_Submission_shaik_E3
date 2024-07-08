
@tag
Feature: Hotel Booking in MakeMyTrip web application

  @tag1
  Scenario: Validate the search and filter functionality
    Given User on the MakeMyTrip homepage
    When User click on Hotels field
    And Enters location "Munnar", dates "28 July" to "31 July", rooms "1", adults "2"
    And User clicked on apply
    And Apply price per night filter max "5000"
    And User click on Search
    Then User should see hotel search results
    
    @tag2
  Scenario: Validate the results and apply filters
    Given User on the Results page
    When  User clicked on breakfast include
    And User clicked on Rating 3.5+
    And User selected room view as mountain view
    And selected Hotel Blanket Hotel & Spa Munna
    And User added guest details
    And User clicked on Book this now
    Then Payment should be visible
    And  Hotel name is visible
    And  Booking date is visible
    