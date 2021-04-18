package com.mybank.reportingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;


@ExtendWith(SpringExtension.class)
public class ReportingControllerTest {
	private MockMvc mockMvc;

	@InjectMocks
	private ReportingController reportingController;

	@Mock
	AuditDetailMapper acccountMapper;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(reportingController).build();
	}

	@Test
	void contextLoads() throws Exception {
		List<AuditDetail> list = new ArrayList<>();
		list.add(AuditDetail.builder().accountId("Test").build());
		Mockito.when(acccountMapper.getAccountTransactionDetails(Mockito.anyString())).thenReturn(list);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/reporting")
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.header("accountId", "accountId"))
				.andReturn();
		System.out.println("erro*******"+ result.getResponse().getContentAsString());
		
		Assertions.assertTrue(result.getResponse().getStatus()==200);
	}
}
