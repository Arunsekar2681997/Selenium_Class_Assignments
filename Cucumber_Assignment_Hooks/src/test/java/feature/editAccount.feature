Feature: Edit the account in the application

Background:
Given Launch the browser and load the URL

Scenario: Login the testleaf application and edit the account
When Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
And Click login button
And Click CRMSFA button
And Click lead button
And Click find leads option
And Click phone option
And Enter phone number and search as '99'
And Click the first record
And Click edit button
And Edit the value as 'TCS'
And Click the submit button for edit flow
Then Verify the page