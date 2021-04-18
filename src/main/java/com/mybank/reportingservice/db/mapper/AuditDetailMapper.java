package com.mybank.reportingservice.db.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.mybank.reportingservice.db.model.AuditDetail;

@Mapper
public interface AuditDetailMapper {
	@Select("SELECT * FROM AUDITDETAIL WHERE accountId = #{accountId}")
	List<AuditDetail> getAccountTransactionDetails(@Param("accountId") String accountId);
	
	
	 @Insert("INSERT INTO AUDITDETAIL(transactionId, customerId, accountId,transactionType,description,trasactionDate,amount,status,transactionCurrency,accountBalance,accountBalanceInUSD,failureReason) VALUES "
	    		+ "(#{transactionId}, #{customerId},#{accountId},#{transactionType},#{description},#{trasactionDate},#{amount},#{status},#{transactionCurrency},#{accountBalance},#{accountBalanceInUSD},#{failureReason})")
    void insertAccountAudit(AuditDetail auditDetail);

}
