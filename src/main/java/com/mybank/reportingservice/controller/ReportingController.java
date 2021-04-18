package com.mybank.reportingservice.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reporting")
@Slf4j
public class ReportingController {

	@Autowired
	AuditDetailMapper acccountMapper;
	
	
	@GetMapping
	public List<AuditDetail> getAllTransaction(@RequestHeader String accountId)
	{
		List<AuditDetail> details= acccountMapper.getAccountTransactionDetails(accountId);
		return CollectionUtils.isEmpty(details)?new ArrayList<AuditDetail>():details;
	}
}