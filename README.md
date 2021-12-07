# A Task given 

Points on which the implementation was needed:

	1- Backend webservice should use spring
	2- Front end is advantage using  Angular  but you can expose APIs using swagger or make simple (OPTIONAL)
	3- use H2 in memory database for ease of testing
	4- List page should have paging 
	5- first_name and last_name should be not be null and more than 2 chars each 
	6- validate that salary is greater than 0
	7- validate phone_number contain only didgits and dashs
	
=== 
With given Schema:
	
    CREATE TABLE employees
    ( employee_id NUMBER(6)
    , first_name VARCHAR2(20)
    , last_name VARCHAR2(25)   
    , email VARCHAR2(25)
    , phone_number VARCHAR2(20)
    , hire_date DATE
    , salary NUMBER(8,2) 
    ) ;

**Implementation Details**

A basic Spring boot project has been created using spring initializer with dependencies:
    
    1. Web starter
    2. Data Starter
    3. Validation Starter
    4. Swagger 3
    5. h2 database

A base structure has been created for keeping basic implementation in mind. Exposed **create** and **fetch** APIs.

###### **_NOTE_**
Client folder contains the ANGULAR implementation.
