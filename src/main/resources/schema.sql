CREATE TABLE IF NOT EXISTS `AUDITDETAIL`
(	
	
	`transactionId`  VARCHAR(15),
    `customerId` VARCHAR(100),
    `accountId` VARCHAR(100),
    `transactionType` VARCHAR(10) ,
    `description` VARCHAR(100) ,
    `trasactionDate` DATE ,
    `amount` DECIMAL(15,2) ,
    `status` VARCHAR(10),
    `transactionCurrency` VARCHAR(10) ,
    `accountBalance` DECIMAL(15,2),
    `accountBalanceInUSD` DECIMAL(15,2) ,
     `failureReason` VARCHAR(100)
    
);