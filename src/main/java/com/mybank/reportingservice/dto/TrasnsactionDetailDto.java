package com.mybank.reportingservice.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrasnsactionDetailDto implements Serializable{
	private static final long serialVersionUID = 6939358267671033448L;
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
