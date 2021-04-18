package com.mybank.reportingservice.listener;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;
import com.mybank.reportingservice.dto.PublisherDto;
import com.mybank.reportingservice.dto.TrasnsactionDetailDto;


@ExtendWith(MockitoExtension.class)
public class MQListenerTest {

	@InjectMocks
	MQListener mqListener;
	
	@Mock
	AuditDetailMapper accountMapper;
	
	@Test
	public void  receivedMessageTest ()
	{
		PublisherDto message=new PublisherDto();
		TrasnsactionDetailDto trasnsactionDetailDto= new TrasnsactionDetailDto();
		trasnsactionDetailDto.setAccountId("TestId");
		message.add(trasnsactionDetailDto);
		Mockito.doNothing().when(accountMapper).insertAccountAudit(Mockito.any(AuditDetail.class));
		mqListener.receivedMessage(message);
		Mockito.verify(accountMapper, Mockito.times(1)).insertAccountAudit(Mockito.any(AuditDetail.class));
	}
	
}
