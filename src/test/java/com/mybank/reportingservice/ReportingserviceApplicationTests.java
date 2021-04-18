package com.mybank.reportingservice;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;

@SpringBootTest(
	webEnvironment=WebEnvironment.RANDOM_PORT,
	classes= ReportingserviceApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
class ReportingserviceApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	AuditDetailMapper auditDetailMapper;
	
	@Test
	void contextLoads() throws Exception {
		
		AuditDetail auditDetail=AuditDetail.builder().accountId("AccountId").customerId("CustomerID")
		.accountBalanceInUSD(new BigDecimal(555)).transactionId("TransactionId").build();
		auditDetailMapper.insertAccountAudit(auditDetail);
		System.out.println("Sample Data for integration :"+auditDetail);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/reporting")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.header("accountId", "AccountId"))
				.andReturn();
		System.out.println("Component are integrated :"+result.getResponse().getContentAsString());
		Assertions.assertTrue(200==result.getResponse().getStatus());
		
	}

}

