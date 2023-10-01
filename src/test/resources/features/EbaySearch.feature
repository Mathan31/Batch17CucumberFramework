@Complete
Feature: Ebay Search Validation

  Background: Precondition for all the scenario and scenario outline
    Given Navigate to Ebay Home Page

  @Smoke
  Scenario: Ebay Search with hardcoded value from step definition
    When Search the product and Selected the Catagory
    And Click on Submmit button
    Then User should see the search result
   

 
  @Sanity @Regression
  Scenario Outline: Ebay Search with multiple values from feature file using scenario outline
    When User can Search the multiple product as <productname> and Selected multiple Catagory as <productcatagory>
    And Click on Submmit button
    Then User should see the search result
    

    @Basic
    Examples: 
      | productname | productcatagory           |
      | Samsung     | Cell Phones & Accessories |
      | Java        | Books                     |
      | Cricket     | Sporting Goods            |

    @Advance
    Examples: 
      | productname          | productcatagory               |
      | T-shirt              | Clothing, Shoes & Accessories |
      | Running Shoe for men | Clothing, Shoes & Accessories |
      | Swimming             | Sporting Goods                |

  