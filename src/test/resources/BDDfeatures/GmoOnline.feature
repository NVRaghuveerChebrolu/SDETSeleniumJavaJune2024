Feature: Validate GMO Online App End to End flow


@GmoRegression
  Scenario: validate launch Of Gmo Online Application and verify the title
    Given User is on Gmo online page
    Then I validate the title
    When user click on Enter Gmo Online Button
    Then verify the title of Onlicatalogue Page
           
@GmoRegression        
  Scenario: validate place and order for sun glasses product
    Given User is on online catalogue page
    When user provide quantity for sun glasses product
    And usr click on Place An Order button
    Then verify the title of Place order page
    And veriy the unit prce and total price calculated
		
    