Feature:  ref

Scenario Outline: User Registration Valid
When the user fills all in the registration form with valid details
Then the user should be successfully registered
Examples:
|email|userName|city|phoneNumber|password|
| Abdelrahman@gmail    |  Abdelrahman      | Jenin    |  0548739226         |123456      |

Scenario Outline: User Registration NotValid
When the user Not fills all in the registration form
Then  should show please fill all informations
Examples:
|emailUser|userName|city|phoneNumber|userPassword|
| Abdelrahman@gmail    |       | Jenin    |  0548739226         |123456      |
|    |  Abdelrahman     | Jenin    |  0548739226         |123456      |
| Abdelrahman@gmail    |       |    |  0548739226         |123456      |
| Abdelrahman@gmail    |       | Jenin    |         |123456      |
| Abdelrahman@gmail    |       | Jenin    |  0548739226         |    |
|                      |       |          |                     |    |

Scenario Outline: user Login Valid
When the user enters their email and password Valid '<email>','<password>'
Then the user should be logged in successfully
Examples:
|email|passwrod|
| Abdelrahman@gmail.com    | 123456       |
Scenario Outline: user Login NotValid
When the user enters their email or password notValid
Then check the email or password is notValid
Examples:
|email|passwrod|
| Abdelrahman@gmail.com    | 1234      |
|    Abdelrahman@gmailm                       | 123456          |
Scenario Outline: Admin Registration Valid
When the admin fills in the registration form with valid details
Then the admin should be successfully registered
Examples:
|emailAdmin |userName |city|adminPassword|
|admin@admin.com|admin|nablus|123456|

Scenario Outline: Admin Registration NotValid
When the admin Not fills all valid details
Then should show please fill all informations
Examples:
|emailAdmin |userName |city|adminPassword|
|admin@admin.com||nablus|123456|
||admin|nablus|123456|

|admin@admin.com|admin||123456|

|admin@admin.com|admin|nablus||


Scenario Outline: Admin Login Valid
When the admin enters their username and password '<emailAdmin>','<adminPassword>'
Then the admin should be logged in successfully
Examples:



|emailAdmin|adminPassword|
|admin@admin.com|123456|
Scenario Outline: Admin Login NotValid
When the admin enters NotValid username and password
Then show please check your email and password
Examples:
|emailAdmin|adminPassword|
|admin@admin.com|1236|


Scenario Outline: service Registration Valid
When the service fills all field form with valid details
Then the service should be successfully Registration
Examples:
|email|userName|city|address|serviceProvide|phonenum |password|
| Abd@gm.com    |  Abd      | Jenin   |kharobah | flowerDesigner| 0548739226         |123456      |

Scenario Outline: service Registration NotValid
When the service Not fills all field form
Then  should show please fill all informations
Examples:
|email|userName|city|address|serviceProvide|phonenum |password|
| Abd@gm.com    |  Abd      | Jenin   |kharobah | flowerDesigner| 0548739226         |123456      |
| Abd@gm.com    |       | Jenin   |kharobah | flowerDesigner| 0548739226         |123456      |
| Abd@gm.com    |  Abd      |    |kharobah | flowerDesigner|        |123456      |

Scenario Outline: service Login Valid
When the service enters their username and password '<email>','<password>'
Then the service should be logged in successfully
Examples:

|email|password|
|Abd@gm.com|123456|
Scenario Outline: service Login NotValid
When the service enters NotValid username and password
Then show please check your email and password
Examples:
|email|password|
|admin@admin.com|123456|
