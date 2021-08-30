Steps to Run the application:
1. update the maven project if any error persist in the project
2. download the lombok dependency from the [link](https://projectlombok.org/download) and install the runnable jar
3. Scripts for testing the API is available in the folder [postman](/app_lcs_generator/postman)

Sample: 

POST http://localhost:8080/lcs

Request body :
  {
   "setOfStrings":[
      {
         "value":"comcast"
      }
      ,
      {
         "value":"communicate"
      },
      {
         "value":"commutation"
      }
   ]
}




