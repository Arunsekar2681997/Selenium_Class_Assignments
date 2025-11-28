Feature: Edit the account details

Scenario: Edit the existing account details
Given launch browser and load the URL
When enter the valid username
And enter the valid password
And click Login button
And click the App launcher
And click view All option
And click Account option
And Search for the account using unique account name 'ArunSekar2681997'
And Click the dropdown icon next to the account and select Edit
And Set Type to Technology Partner
And Set Industry to Healthcare
And Select the country For Billing Address 'India'
And Select the state for Billing Address 'Tamil Nadu'
And Enter the street name for Billing Address 'TET Street'
And Enter the City for billing address 'Theni'
And Enter the Pincode for billing address '625520'
And Select the country for Shipping Address 'India'
And Enter the street for shippling address 'SFT Street'
And Enter the city for shipping address 'Chennai'
And Enter the state for shipping address 'Tamil Nadu'
And Enter the Pin code for shipping address '654789'
And Set Customer Priority to Low
And Set SLA to Silver
And Set Active to NO
And Enter a phone number '9876543210'
And Set Upsell Opportunity to No
Then Click Save and verify the phone number