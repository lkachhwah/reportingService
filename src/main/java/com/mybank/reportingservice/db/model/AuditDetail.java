package com.mybank.reportingservice.db.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditDetail {
	private String transactionId;
	private String  customerId;
	private String accountId;
	private String transactionType;
	private String description;
	private Date trasactionDate;
	private BigDecimal amount;
	private String status;
	private String transactionCurrency;
	private BigDecimal accountBalance;
	private BigDecimal accountBalanceInUSD;
	private String failureReason;
}
