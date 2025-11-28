Feature: Create the account in the application

Background:
Given Launch the browser and load the URL

Scenario: Login the testleaf application and create the account
When Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click login button
And Click CRMSFA button
And Click lead button
And Click create lead option
And Enter company name as 'TestLeaf'
And Enter first name as 'ArunSekar'
And Enter last name as 'Panneer Selvam'
And Click submit button
Then Verify the page
