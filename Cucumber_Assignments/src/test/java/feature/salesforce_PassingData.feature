Feature: Create the account in salesforce


Scenario Outline: Create account using multiple account names


Given launch browser and load the URL
When enter the valid username
And enter the valid password
And click Login button
And click the App launcher
And click view All option
And click Account option
When click on New button
And enter Account Name as <AccountName>
When select ownership as Public
And click Save
Then verify the Account Name 

Examples:
|AccountName|
|ArunSekar2681997|
|ArunSekar Panneer Selvam|
|ArunSekar PS| 