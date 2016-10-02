Feature: Test

@foo
Scenario: google search

Given Google page "http://www.google.com"
When I enter "Prashanth Sams" in search box
When I press enter key
Then I should get the results of "Prashanth Sams"