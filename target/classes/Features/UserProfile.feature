@User
Feature: User profile functionalities for a user

Background:
Given User is logged in and on View Profile page
|anikajoshics19@acropolis.in|Inlinked@123|

@Intro
Scenario: To validate Edit Intro functionality
When User clicks on Edit Intro button
And enters Industry and City
|IT System Testing and Evaluation|Mumbai, Maharashtra|
And clicks on Save
Then changes should get saved

@Skill
Scenario Outline: To validate Add Skill option functionality
When User clicks on Add Skill option
And enters the "<skill>"
And clicks on the Save button
Then Skill should be added
Examples:
|skill|
|Java|

@Experience
Scenario: To validate Add Experience functionality
When User clicks on Add Experience option
And enters Title, Company Name, Start Month, and Start Year
|Analyst|Capgemini|January|2024|
And clicks on Save option
Then Experience should be saved and displayed

@Post
Scenario: To validate Create a Post functionality
When User clicks on Create a Post option
And enters Details of their Post
|Hello Connections|
And clicks on Post option
Then that Post should be displayed

@Contact
Scenario: To validate Edit Contact info functionality
When User clicks on Contact Info and clicks on Edit button
And enters Phone Number, Phone Type, Address, Birth Month, and Birth Date
|Abcde|Home|Airoli, Navi Mumbai|February|2|
And clicks on Save button
Then changes should not get saved
