Feature: As a user i want to add a product to cart through Quick view
	...i want to add another product to cart and complete the place order
Scenario: Verify user able to place the order
	When I navigate to home page
	And Create an "testuser@gmail.com" user
	And Search a product
	When Add "2" product with "2" quantity to cart from quickview
	And Add "1" product with "1" quantity to cart from quickview
	And I navigate to shoppingcart
	And I navigate to checkoutpage
	And I Submit the order
	Then I should see the Order confirmation messsage
	
Scenario: Verify added review comments in order details
	When I navigate to home page
	And Login as "testuser@gmail.com" user
	And Add review comments in order details
	Then I should see the review comments

Scenario: Verify the product details in order details page
	When I navigate to home page
	And Login as "testuser@gmail.com" user
	And I open the order details
	Then I should see the product details in order details