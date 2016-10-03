Feature: Test

@foo
Scenario: First Test Case

Given Run Whit "Chrome"
When I go to "http://automatizacion.herokuapp.com/dvilla/"
When I press the Appointment Scheduling button
When I enter "12/12/2016" in the date day box
When I enter "1112784253" in the patient identification box
When I enter "1112784253" in the doctor identification box
When I enter "Prueba Automatizacion" in the scheduling notes box
Then I press the save button and should get "Datos guardados correctamente."