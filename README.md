# Selenium-project-
Test Scenarios:

 

1. Login validations

 

Test 1: Verify "standard_user" & "performance_glitch_user” is able to do successful login and land on home page and do logout.

 

Test 2: Verify "locked_out_user" login fails and assert error on login screen.

 

2. Items sort order validations

 

Test 1: Verify default sort order.

-        Login into the website if not already logged in.

-        Verify the items are in default sort order.

 

Test2: Verify user to able to change sort order.

-        Login into the website if not already logged in.

-        Sort the items by price high to low.

-        Verify the items are sorted by price high to low.

 

3. Add items to cart and complete order

 

Test 1: Verify items in cart are retained in cart after logout.

-        Login into the website if not already logged in.

-        Add random 3 items to cart.

-        Logout of the app and login again

-        Navigate to cart and verify previously added items are in cart.

 

Test 2: Verify user can place order.

-        Login into the website if not already logged in.

-        Add 2 items to cart (a highest and lowest)

-        Navigate to checkout information page.

-        Verify input field validations are working for all 3 form fields.

-        Navigate to checkout overview page.

-        Verify total price and place order.

-        Verify confirmation and navigate to home page.

 
