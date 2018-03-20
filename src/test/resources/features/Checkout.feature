Feature: Check out

# This is the end to end checkout scenario for different products 
Scenario Outline: Verify correct error message displayed on checkout with incorrect payment details 
Given I am at Home Page
When I search a "<Product>"
And I select a "<Product>"
And The correct "<product_Price>" is displayed on the product page
And I add the product to basket
And I add a "<personalized_Message>" to the product in the basket
And I select a "<Packaging>" method
And Delivery "<deliveryCharge>" is applied
And Packaging "<packagingCharge>" is applied
And The correct "<Product_Price>" is displayed on the basket page
And Proceed to checkout page
And Entered Customer details at checkout page
And Entered delivery details at checkout page
And Entered incorrect payment details and checkout
Then Error message "<error_msg>" is displayed at checkout Page
Examples:
|Product	|product_Price	|personalized_Message	|Packaging	|deliveryCharge	|packagingCharge	|Product_Price| error_msg|
|Two Nights for the Price of One Hotel Break	|£99	|Gift For Special person	|eVoucher	|£0.00	|£0.00	|£99.00|The card number is not valid, please check the details and try again.|
|Afternoon Tea for Two at Tylney Hall					|£54	|Gift For Special person	|eVoucher	|£0.00	|£0.00	|£54.00|The card number is not valid, please check the details and try again.|


# Same Check out scenario is splitted into below three scenarioes to make it pretty and simple
Scenario Outline: Verify correct product price displayed at product page
Given I am at Home Page
When I search a "<Product>"
And I select a "<Product>"
Then The correct "<product_Price>" is displayed on the product page
Examples:
|Product	|product_Price	|
|Two Nights for the Price of One Hotel Break	|£99	|


Scenario Outline: Verify displayed product price and charges applied are correct at bag page
Given I have a "<Product>" added in bag
When I add a "<personalized_Message>" to the product in the basket
And I select a "<Packaging>" method
Then Delivery "<deliveryCharge>" is applied
Then Packaging "<packagingCharge>" is applied
Then The correct "<Product_Price>" is displayed on the basket page
Examples:
|Product	|personalized_Message	|Packaging	|deliveryCharge	|packagingCharge	|Product_Price|
|Two Nights for the Price of One Hotel Break	|Gift For Special person	|eVoucher	|£0.00	|£0.00	|£99.00|


Scenario Outline: Verify correct error message displayed on checkout with incorrect card details
Given I have a "<Product>" added in bag
When I add a "<personalized_Message>" to the product in the basket
And I select a "<Packaging>" method
And Proceed to checkout page
And Entered Customer details at checkout page
And Entered delivery details at checkout page
And Entered incorrect payment details and checkout
Then Error message "<error_msg>" is displayed at checkout Page
Examples:
|Product	|personalized_Message	|Packaging	| error_msg|
|Two Nights for the Price of One Hotel Break	|Gift For Special person	|eVoucher	|The card number is not valid, please check the details and try again.|