## Pre install software need:
* Rabbit MQ
* MVN
* Java 8 JDK

## Steps To Run:
~~~
1.check out Project from repository : https://github.com/lkachhwah/accountService.git ,using git .
2.Check above Software are installed and keep rabbit MQ up and running.
3. Go to application.properties 
  1. Update RabbitMq property :
     reportservice.topic.name=myTestQueue

4. Go to the path where project is checkout and run command "mvn clean install"
5. Once build is ready run application using command : java -jar reportingservice-0.0.1-SNAPSHOT.jar
6. Verification step check log And we should be able see log : "*************Started************" .
7. Open the swagger ui : localhost:<server.port>/swagger-ui.html
8. This application act as listener to event publish by transaction service.
~~~
## Operation Details
~~~
1. Transaction Details for a AccountId [GET]:
   - This endpoint is used to get all  trasactions details  for a accountId.Please refer below sample request and attribute details.
      * Request:
      * Header - accountId: <Account number generated in create call> e.g: 1618755265713
      * URL : http://localhost:<server.port>/reporting
      * Response:
	[{
	  "transactionId": "1618756518024",
	  "customerId": "lkachhwah",
	  "accountId": "1618755265713",
	  "transactionType": "OUT",
	  "description": "Token Amount",
	  "trasactionDate": "2021-04-18T14:35:18.024+00:00", 
	  "amount": 10,
	  "status": "SUCCESS",
	  "transactionCurrency": "EUR",
	  "accountBalance": "72.65",  - remaining balance after operation in transactionCurrency.
	  "accountBalanceInUSD": "87.51" - remaining balance after operation in USD.
	}]
~~~
