package com.MO.Software.Bill.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MO.Software.Bill.billModel;
import com.MO.Software.Bill.DTO.billDTO;
import com.MO.Software.Bill.billProducts.DTO.billProductDTO;
import com.MO.Software.base.baseRepository;

@Repository
public interface billRepository extends baseRepository<billModel,Long>{

	@Query("SELECT b from billModel b where b.returnedBill=true")
	List<billModel> findByReturnedBill();

	@Query("SELECT COUNT(b) FROM billModel b WHERE b.dayModel.id = :dayId")
    int countBillsByDay(@Param("dayId") Long dayId);
	
	@Query("SELECT b FROM billModel b WHERE " +
		       "(:employeeName IS NULL OR b.employeeName LIKE %:employeeName%) AND " +
		       "(:employeeId IS NULL OR b.employeeId = :employeeId) AND " +
		       "(:billTypeId IS NULL OR b.billType.id = :billTypeId) AND " +
		       "(:startDate IS NULL OR b.dateTime >= :startDate) AND " +
		       "(:endDate IS NULL OR b.dateTime <= :endDate) AND " +
		       "(:billTotal IS NULL OR b.billTotal = :billTotal) AND " +
		       "(:returnedBill IS NULL OR b.returnedBill = :returnedBill) AND " +
		       "(:fetchedBillIds IS NULL OR b.id IN :fetchedBillIds)")
		List<billModel> findBillModels(
		    @Param("employeeName") String employeeName,
		    @Param("employeeId") Long employeeId,
		    @Param("billTypeId") Integer billTypeId,
		    @Param("startDate") LocalDateTime startDate,
		    @Param("endDate") LocalDateTime endDate,
		    @Param("billTotal") Integer billTotal,
		    @Param("returnedBill") Boolean returnedBill,
		    @Param("fetchedBillIds") List<Long> fetchedBillIds);
		
		@Query("SELECT b.id FROM billModel b WHERE " +
			       "(:employeeName IS NULL OR b.employeeName LIKE %:employeeName%) AND " +
			       "(:employeeId IS NULL OR b.employeeId = :employeeId) AND " +
			       "(:billTypeId IS NULL OR b.billType.id = :billTypeId) AND " +
			       "(:startDate IS NULL OR b.dateTime >= :startDate) AND " +
			       "(:endDate IS NULL OR b.dateTime <= :endDate) AND " +
			       "(:billTotal IS NULL OR b.billTotal = :billTotal) AND " +
			       "(:returnedBill IS NULL OR b.returnedBill = :returnedBill) AND " +
			       "(:fetchedBillIds IS NULL OR b.id IN :fetchedBillIds)")
			List<Long> findBillModelIds(
			    @Param("employeeName") String employeeName,
			    @Param("employeeId") Long employeeId,
			    @Param("billTypeId") Integer billTypeId,
			    @Param("startDate") LocalDateTime startDate,
			    @Param("endDate") LocalDateTime endDate,
			    @Param("billTotal") Integer billTotal,
			    @Param("returnedBill") Boolean returnedBill,
			    @Param("fetchedBillIds") List<Long> fetchedBillIds);

	@Query("SELECT b from billModel b where b.billType.id=:billTypeId")
	List<billDTO> findByBillTypeId(Integer billTypeId);


}
