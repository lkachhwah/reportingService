/*package com.mybank.reportingservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mybank.reportingservice.controller.ReportingController;
import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;

@ExtendWith(SpringExtension.class)
public class ReportingserviceApplicationUnitTests {

	@InjectMocks
	private ReportingController reportingController;
	
	@Mock
	private AuditDetailMapper auditDetailMapper;
	
	@Mock
	MockMvc mockMvc;
	
	@@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(reportingController).build();
	
	}
	
	@Test
	void contextLoads() throws Exception {
		List<AuditDetail> list= new ArrayList<>();
		list.add(AuditDetail.builder().accountId("Test").build());
		Mockito.when(auditDetailMapper.getAccountTransactionDetails(Mockito.anyString()))
		.thenReturn(list);
		
		MvcResult result=mockMvc.perform(
				MockMvcRequestBuilders.get("/report")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		Mockito.verify(auditDetailMapper).getAccountTransactionDetails(Mockito.anyString());
	}
	
}
*/