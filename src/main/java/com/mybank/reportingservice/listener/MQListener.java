package com.mybank.reportingservice.listener;

import java.util.Objects;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.reportingservice.db.mapper.AuditDetailMapper;
import com.mybank.reportingservice.db.model.AuditDetail;
import com.mybank.reportingservice.dto.PublisherDto;
import com.mybank.reportingservice.dto.TrasnsactionDetailDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MQListener<T> implements RabbitListenerConfigurer {
    
	@Autowired
	AuditDetailMapper accountMapper;
	
	ObjectMapper objectMapper= new ObjectMapper();
    
    @RabbitListener(queues = "${reportservice.topic.name}")
    @SuppressWarnings("null")
    public void receivedMessage(PublisherDto<T> message) {
        log.info("Recieved Message" +message );
        if(  Objects.nonNull(message) &&  Objects.nonNull(message.get()))
        {
        	 TrasnsactionDetailDto trasnsactionDetailDto=objectMapper.convertValue(message.get(),TrasnsactionDetailDto.class);
        	accountMapper.insertAccountAudit(objectMapper.convertValue(trasnsactionDetailDto,AuditDetail.class));
        }
    }
	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar arg0) {
		// TODO Auto-generated method stub
		
	}
}
